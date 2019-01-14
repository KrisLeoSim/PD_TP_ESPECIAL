/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.regras.negocio;

import javax.ejb.Remote;
import lib.regras.negocio.entidade.UtilizadorPojo;

/**
 *
 * @author sergio
 */
@Remote
public interface ControladorRemote {

    public UtilizadorPojo login(String username, String password) throws Exception;
    public void logout();
    
    public UtilizadorPojo registaUtilizador(UtilizadorPojo utilizador) throws Exception; 
    public UtilizadorPojo atualizaUtilizador(UtilizadorPojo utilizador) throws Exception;
   
//    public List<UtilizadorC> listaUtilizadores() throws Exception;    
         
}
