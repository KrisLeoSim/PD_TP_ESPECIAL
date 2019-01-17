/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import javax.ejb.EJB;
import javax.ejb.Stateful;
import persistencia.UtilizadorFacade;
import persistencia.UtilizadorFacadeLocal;


/**
 *
 * @author sergio
 */
@Stateful
public class Controlador implements ControladorRemote {

    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;

    private boolean logado = false;
    
   


    @Override
    public int login(String utilizador, String password) {
                   int estado;
            
            estado = utilizadorFacade.login(utilizador, password);

            if(estado != 1)
                logado = true;
            
         return estado;   
    }
      
}
