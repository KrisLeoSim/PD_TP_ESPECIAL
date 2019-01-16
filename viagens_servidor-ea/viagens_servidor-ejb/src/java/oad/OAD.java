/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oad;


import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio
 */
@Singleton
public class OAD implements OADLocal {
    
    
    @PersistenceContext(unitName="viagens_servidor-ejbPU")
    private EntityManager em;

   // private UtilizadorP utilizadorPersistencia;

//    
//   @Override
//    public User login(String username, String password) {
//       
//        return utilizadorPersistencia.getUtilizador(username, password);
//    }
//    
//    @Override
//    public User getUtilizador(int id) {
//      //  return utilizadorPersistencia.getEntidade(id);
//      return null;
//    }
//
//    @Override
//    public Utilizador criarUtilizador(Utilizador utilizador) throws Exception{
//        return utilizadorPersistencia.criarEntidade(utilizador);
//    }
//
//    @Override
//    public void excluirUtilizador(Utilizador utilizador) throws Exception{
//        utilizadorPersistencia.excluirEntidade(utilizador);
//    }
    
    
    
    
    
//    @PostConstruct
//    public void initialize() {
//    utilizadorPersistencia = new UtilizadorP();
//    }       
    
     @PreDestroy
    public void encerra() {
        em.close();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
