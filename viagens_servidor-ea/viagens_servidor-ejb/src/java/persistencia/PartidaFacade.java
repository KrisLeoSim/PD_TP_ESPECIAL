/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Companhia;
import entidade.Partida;
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
public class PartidaFacade implements PartidaFacadeLocal {

    @EJB
    private DAOLocal dao;

    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager();
    }

    @Override
    public boolean registarPartida(Partida entidade) {
        try {
            getEntityManager().persist(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(PartidaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirPartida(Partida entidade) {
        try {
            getEntityManager().remove(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(PartidaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean editarPartida(Partida entidade) {
        try {
            getEntityManager().merge(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(PartidaFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public Companhia getPartida(int id) {
        Query query = getEntityManager().createNamedQuery("Companhia.findByIdPartida");
        query.setParameter("idPartida", id);
        return (Companhia) query.getSingleResult();
    }

    @Override
    public List<Companhia> getAllPartidas() {
        Query query = getEntityManager().createNamedQuery("Partida.findAll");
        return query.getResultList();
    }

}
