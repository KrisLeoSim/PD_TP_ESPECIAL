/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Companhia;
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
public class CompanhiaFacade implements CompanhiaFacadeLocal {

    @EJB
    private DAOLocal dao;

    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager();
    }

    @Override
    public boolean registarCompanhia(Companhia entidade) {
        try {
            getEntityManager().persist(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(CompanhiaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirCompanhia(Companhia entidade) {
        try {
            getEntityManager().remove(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(CompanhiaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean editarCompanhia(Companhia entidade) {
        try {
            getEntityManager().merge(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(CompanhiaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public Companhia getCompanhia(int id) {
        Query query = getEntityManager().createNamedQuery("Companhia.findByIdCompanhia");
        query.setParameter("idCompanhia", id);
        return (Companhia) query.getSingleResult();
    }

    @Override
    public List<Companhia> getAllCompanhias() {
        Query query = getEntityManager().createNamedQuery("Companhia.findAll");
        return query.getResultList();
    }

}
