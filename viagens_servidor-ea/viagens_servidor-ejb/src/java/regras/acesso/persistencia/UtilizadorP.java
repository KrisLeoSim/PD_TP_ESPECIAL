/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.persistencia;


import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import oad.OADLocal;
import regras.acesso.entidade.User;

/**
 *
 * @author sergio
 */
@Stateless
@LocalBean
public class UtilizadorP implements Persistencia<Object>{
    
    @EJB
    private OADLocal oad;

    public User atualizaUltimoLogin(User utilizador) throws Exception {
    
        utilizador.setDataUltimoLogin(new Date());
       
        return (User) editar(utilizador);
    }
    
    
    public User getUtilizador(String nome, String palavrapass ) {
        
        Query query = getEntityManager().createNamedQuery("User.findByUsername");
        query.setParameter("username", nome);
        List<User> users = query.getResultList();
         
          System.out.println("****************************************  " + users.get(0).getUsername());
        
        if (users.isEmpty()) {
            return null;
        }
        System.out.println("GETUSER:   " + users.get(0).getPrimeiroNome());
        User utilizador = (User) users.get(0);
       
        if (utilizador.getPassword().equals(palavrapass)) {
            return  utilizador;
        }
        return null;
    }
    
    //overide metodos da interface Persistencia
    
    @Override
    public Object criar(Object entidade) throws Exception {
        
        
        getEntityManager().persist(entidade);
        getEntityManager().flush();

        return entidade;
    }

    @Override
    public void excluir(Object entidade) throws Exception {
       
        //ver dependencias
//        if( !entidade.getProdutoCollection().isEmpty() ||
//                !entidade.getOfertaCollection().isEmpty() ||
//                !entidade.getAvaliacaoOfertaCollection().isEmpty() ) {
//            throw new Exception("Tem dependências");
//        }
        
//EXCLUIR
        if (!getEntityManager().contains(entidade)) {
            entidade = getEntityManager().merge(entidade);
        }
        getEntityManager().remove(entidade);
        getEntityManager().flush();
    }

    @Override
    public Object editar(Object entidade) throws Exception {
        getEntityManager().merge(entidade);
        getEntityManager().flush();
        
        return entidade;
    }

    @Override
    public Object get(int id) {
        
        
//        Query query = getEntityManager().createNamedQuery(type.getSimpleName()+".findById");
//        query.setParameter("id", id);
//        List<T> entidades = query.getResultList();
//        
//        if (entidades.isEmpty() || entidades.get(0) == null) {
//            return null;
//        }
//        return entidades.get(0);
        
        Query query = getEntityManager().createNamedQuery("User.findByIdUser");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }
    
    @Override
    public List<Object> getAll(){
        Query query = getEntityManager().createNamedQuery("User.findAll");
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return oad.getEntityManager(); 
    }
  
}
