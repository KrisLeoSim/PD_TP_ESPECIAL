/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Agencia;
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
public class AgenciaFacade implements AgenciaFacadeLocal {

    @EJB
    private DAOLocal dao;

    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager();
    }

    @Override
    public boolean registarAgencia(Agencia entidade) {
        try {
            getEntityManager().persist(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(AgenciaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirAgencia(Agencia entidade) {
        try {
            getEntityManager().remove(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(AgenciaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean editarAgencia(Agencia entidade) {
        try {
            getEntityManager().merge(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(AgenciaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public Agencia getAgencia(int id) {
        Query query = getEntityManager().createNamedQuery("Agencia.findByIdAgencia");
        query.setParameter("idAgencia", id);
        return (Agencia) query.getSingleResult();
    }

    @Override
    public List<Agencia> getAllAgencias() {
        Query query = getEntityManager().createNamedQuery("Agencia.findAll");
        return query.getResultList();
    }
}
