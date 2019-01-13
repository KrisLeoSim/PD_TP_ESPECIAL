/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import regras.acesso.persistencia.UtilizadorP;
import regras.negocio.Entidade.UtilizadorC;

/**
 *
 * @author sergio
 */
@Stateful
public class Controlador implements ControladorRemote {

     private boolean logado = false;
    
    @EJB
    private UtilizadorP utilizadorPersistence;
    
    
    @Override
    public UtilizadorC login(String username, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UtilizadorC registaUtilizador(UtilizadorC utilizador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
