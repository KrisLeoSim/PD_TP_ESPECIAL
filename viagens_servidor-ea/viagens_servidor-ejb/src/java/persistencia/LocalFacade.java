/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Local;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author sergio
 */
@Stateless
public class LocalFacade implements LocalFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private DAOLocal dao;

    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager();
    }

    @Override
    public boolean registarLocal(Local entidade) {
        try {
            getEntityManager().persist(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(LocalFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirLocal(Local entidade) {
        try {
            getEntityManager().remove(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(LocalFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean editarLocal(Local entidade) {
        try {
            getEntityManager().merge(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(LocalFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public Local getLocal(int id) {
        Query query = getEntityManager().createNamedQuery("Local.findByIdLocal");
        query.setParameter("idLocal", id);
        return (Local) query.getSingleResult();
    }

    @Override
    public List<Local> getAllLocais() {
        Query query = getEntityManager().createNamedQuery("Local.findAll");
        return query.getResultList();
    }
}
