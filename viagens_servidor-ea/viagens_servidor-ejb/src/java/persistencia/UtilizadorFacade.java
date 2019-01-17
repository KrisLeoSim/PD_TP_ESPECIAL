/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;



import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidade.Utilizador;


/**
 *
 * @author sergio
 */
@Stateless
public class UtilizadorFacade implements UtilizadorFacadeLocal{
    
    public final static int ESTADO_VISITANTE = 1;
    public final static int ESTADO_CLIENTE = 2;
    public final static int ESTADO_OPERADOR = 3;
    
    
    @EJB
    private DAOLocal dao;

    
    private int gettipo(String tipo){
    switch(tipo){
        case "operador":
            return ESTADO_OPERADOR;
        default:
            return ESTADO_VISITANTE; 
    }
    
    }
    
    
    @Override
    public int login(String nome, String palavrapass ) {
        
        Query query = getEntityManager().createNamedQuery("Utilizador.findByUsername");
        query.setParameter("username", nome);
        List<Utilizador> users = query.getResultList();
        
        if (!users.isEmpty()) {
           return gettipo(users.get(0).getTipoUser());
        }
   
        return 1;
    }

    
    
    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager(); 
    }

    @Override
    public Utilizador criar(Utilizador entidade) throws Exception {
        getEntityManager().persist(entidade);
        getEntityManager().flush();
        return entidade;
    }

    @Override
    public void excluir(Utilizador entidade) throws Exception {
        getEntityManager().remove(entidade);
        getEntityManager().flush();
    }

    @Override
    public Utilizador editar(Utilizador entidade) throws Exception {
        getEntityManager().merge(entidade);
        getEntityManager().flush();
        
        return entidade;
    }

    @Override
    public Utilizador get(int id) {
        Query query = getEntityManager().createNamedQuery("Utilizador.findByIdUser");
        query.setParameter("id", id);
        return (Utilizador) query.getSingleResult();
    }

    @Override
    public List<Utilizador> getAll() {
          Query query = getEntityManager().createNamedQuery("Utilizador.findAll");
        return query.getResultList();
    }
    
    //    public Utilizador atualizaUltimoLogin(Utilizador utilizador) throws Exception {
//    
//        utilizador.setDataUltimoLogin(new Date());
//       
//        return (Utilizador) editar(utilizador);
//    }
  
}
