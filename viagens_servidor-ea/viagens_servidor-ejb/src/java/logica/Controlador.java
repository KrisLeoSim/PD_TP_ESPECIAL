/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import entidade.Utilizador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import persistencia.UtilizadorFacadeLocal;
import persistencia.VooFacadeLocal;


/**
 *
 * @author sergio
 */
@Stateful
public class Controlador implements ControladorRemote {

    @EJB
    private VooFacadeLocal vooFacade;

    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    
    

    private boolean logado = false;
    private Utilizador utilizador;
    

    @Override
    public boolean login(String nome, String password) {
                 
         this.utilizador = utilizadorFacade.login(nome, password);

         if(utilizador != null){      
             try {
                 utilizadorFacade.atualizaUltimoLogin(this.utilizador);
             } catch (Exception ex) {
                 Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
             }
             logado =true;       
         }
  
         return logado;   
    }
    
    @Override
    public boolean registar(String username, String password, int nif) {
        return utilizadorFacade.registar(username, password, nif);
    }
    
    @Override
    public String getTipoDeUtilizador(final String tipoDeUtilizador) {
        return utilizador.getTipoUser();
    }

   //logout89;
    //obtemListaVoos();
     // ...
    
    
    
}
