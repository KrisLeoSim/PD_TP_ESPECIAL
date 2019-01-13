/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio;

import javax.ejb.Remote;
import regras.negocio.Entidade.UtilizadorC;

/**
 *
 * @author sergio
 */
@Remote
public interface ControladorRemote {

    public UtilizadorC login(String username, String password) throws Exception;
    public void logout();
    
    public UtilizadorC registaUtilizador(UtilizadorC utilizador) throws Exception;
   
//    public UtilizadorC atualizaUtilizador(UtilizadorC utilizador) throws Exception ;
//    public List<UtilizadorC> listaUtilizadores() throws Exception;    
         
}
