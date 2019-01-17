/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import persistencia.DAOLocal;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sergio
 */
@Singleton
public class DAO implements DAOLocal {
    
    @PersistenceContext(unitName = "viagensPU")
    private EntityManager em;
   
    //private EntityManagerFactory emf;

    @PostConstruct
    public void initializa() {
    //em = emf.createEntityManager();
    }       
    
     @PreDestroy
    public void encerra() {
        em.close();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
