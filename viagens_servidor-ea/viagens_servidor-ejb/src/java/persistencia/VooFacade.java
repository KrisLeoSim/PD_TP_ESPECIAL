/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Voo;
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
public class VooFacade implements VooFacadeLocal {

    @EJB
    private DAOLocal dao;

    @Override
    public EntityManager getEntityManager() {
        return dao.getEntityManager();
    }

    @Override
    public boolean registarVoo(Voo entidade) {
        try {
            getEntityManager().persist(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(VooFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean excluirVoo(Voo entidade) {
        try {
            getEntityManager().remove(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(VooFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public boolean editarVoo(Voo entidade) {
        try {
            getEntityManager().merge(entidade);
            getEntityManager().flush();
        } catch (Exception e) {
            Logger.getLogger(VooFacade.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return true;
    }

    @Override
    public Voo getVoo(int id) {
        Query query = getEntityManager().createNamedQuery("Companhia.findByIdVoo");
        query.setParameter("idVoo", id);
        return (Voo) query.getSingleResult();
    }

    @Override
    public List<Voo> getAllVoos() {
        Query query = getEntityManager().createNamedQuery("Voo.findAll");
        return query.getResultList();
    }
    
   
    @Override
    public List<Voo> viagensMaisLugaresDisponiveis() {
        Query query = getEntityManager().createNativeQuery("select * from (select Distinct id_voo as voo_id, preco_compra from lugar) as vooPreco, voo where voo.id_voo =  vooPreco.voo_id order by preco_compra Limit 10",entidade.Voo.class);
        return query.getResultList();
        
        
       
    }

}
