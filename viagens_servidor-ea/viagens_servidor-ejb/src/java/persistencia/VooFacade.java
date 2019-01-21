/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Utilizador;
import entidade.Voo;
import java.util.List;
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
    
    //METODOS A UTILIZAR
    @Override
    public List<Voo> obtemVoosActivos(){
     Query query = getEntityManager().createNamedQuery("Utilizador.findAll");
        return query.getResultList();
    }
    
    //operações basicas
    
    @Override
    public EntityManager getEntityManager() {
         return dao.getEntityManager(); 
    }

    @Override
    public Voo criarVoo(Voo entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirVoo(Voo entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Voo editarVoo(Voo entidade) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Voo getVoo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voo> getAllVoo() {
         Query query = getEntityManager().createNamedQuery("Voo.findAll");
        return query.getResultList();
    }


}
