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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sergio
 */
@Stateless
public class UtilizadorFacade implements UtilizadorFacadeLocal{
    
    @EJB
    private DAOLocal dao;

    //METODOS A UTILIZAR
    
    @Override
    public Utilizador login(String nome, String palavrapass ) {
        
        Query query = getEntityManager().createNamedQuery("Utilizador.findByUsername");
        query.setParameter("username", nome);
        List<Utilizador> users = query.getResultList();
        
        if (!users.isEmpty() || users != null) {
           return users.get(0);
        }
   
        return null;
    }

    @Override
    public boolean registar(String nome, String palavrapass, String nif, String tipoDeUtilizador ) {
        boolean registou = false;
      //ver se ja ha algum utilizador com o mesmo nome
 
      Utilizador novoUtilizador = new Utilizador();
      //novoUtilizador.setIdUtilizador(5);
      novoUtilizador.setUsername(nome);
      novoUtilizador.setPassword(palavrapass);
      novoUtilizador.setNif(nif);
      novoUtilizador.setEstado(0);
      novoUtilizador.setTipoUser(tipoDeUtilizador);
      
      
        try {
            criarUtilizador(novoUtilizador);
            registou = true;
        } catch (Exception ex) {
            Logger.getLogger(UtilizadorFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return registou;
    }

    //Metodos privados para uso apenas da class
    
    @Override
    public Utilizador atualizaUltimoLogin(Utilizador utilizador) throws Exception {  
        utilizador.setDataUltimoLogin(5);       
        return (Utilizador) editarUtilizador(utilizador);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager(); 
    }

    @Override
    public Utilizador criarUtilizador(Utilizador entidade) throws Exception {
        getEntityManager().persist(entidade);
        getEntityManager().flush();
        return entidade;
    }

    @Override
    public void excluirUtilizador(Utilizador entidade) throws Exception {
        getEntityManager().remove(entidade);
        getEntityManager().flush();
    }

    @Override
    public Utilizador editarUtilizador(Utilizador entidade) throws Exception {
        getEntityManager().merge(entidade);
        getEntityManager().flush();
        
        return entidade;
    }

    @Override
    public Utilizador getUtilizador(int id) {
        Query query = getEntityManager().createNamedQuery("Utilizador.findByIdUtilizador");
        query.setParameter("idUtilizador", id);
        return (Utilizador) query.getSingleResult();
    }

    @Override
    public List<Utilizador> getAllUtilizadores() {
          Query query = getEntityManager().createNamedQuery("Utilizador.findAll");
        return query.getResultList();
    }

    @Override
    public List<Utilizador> getTodosUtilizadoresQueAguardamAprovacao() {
        Query query = getEntityManager().createNamedQuery("Utilizador.findByEstado");
        query.setParameter("estado", 0);
        return query.getResultList();
    }
    
    @Override
    public List<Utilizador> getClientes() {      
        Query query = getEntityManager().createNamedQuery("Utilizador.findByTipoUser");
        query.setParameter("tipoUser", "cliente");
        return query.getResultList();
    }
    
    @Override
    public List<Utilizador> getOperadores() {
        Query query = getEntityManager().createNamedQuery("Utilizador.findByTipoUser");
        query.setParameter("tipoUser", "operador");
        return query.getResultList();
    }
  
}
