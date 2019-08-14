/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import entidade.Utilizador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import persistencia.UtilizadorFacadeLocal;
import persistencia.VooFacadeLocal;
import regras.negocio.entidade.UtilizadorPojo;


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
    public boolean registarUtilizador(String username, String password, String nif ) {
        return utilizadorFacade.registar(username, password, nif, "cliente");
    }
    
    @Override
    public boolean registarOperador(String username, String password, String nif ) {
        return utilizadorFacade.registar(username, password, nif, "operador");
    }
    
    @Override
    public String getTipoDeUtilizador(final String tipoDeUtilizador) {
        return utilizador.getTipoUser();
    }

   //logout89;


    @Override
    public int tempoAtual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraTempo(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizaUtilizadorEstado(UtilizadorPojo novosDados) {
        
        try {
             Utilizador utilizadorAactualizar = utilizadorFacade.getUtilizador(novosDados.getIdUtilizador());

            if (utilizadorAactualizar == null) {
                return false;
            }
           
            utilizadorAactualizar.setEstado(novosDados.getEstado());
            utilizadorFacade.editarUtilizador(utilizadorAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean apagaUtilizador(int idUtilizador) {
        
        try {
            Utilizador utilizadorAapagar = utilizadorFacade.getUtilizador(idUtilizador);

            if (utilizadorAapagar == null) {
                return false;
            }

            /*SENAO APAGA A COMPANHIA*/
            utilizadorFacade.excluirUtilizador(utilizadorAapagar);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<UtilizadorPojo> listaContasQueAguardamAprovação() {     
       return util.converteEntityToPojo.converteListaDeUtilizadorToUtilizadorPojo(utilizadorFacade.getTodosUtilizadoresQueAguardamAprovacao());    
    }

    @Override
    public ArrayList<UtilizadorPojo> listaClientes() {
        return util.converteEntityToPojo.converteListaDeUtilizadorToUtilizadorPojo(utilizadorFacade.getClientes()); 
    }

    @Override
    public ArrayList<UtilizadorPojo> listaOperadores() {
        return util.converteEntityToPojo.converteListaDeUtilizadorToUtilizadorPojo(utilizadorFacade.getOperadores()); 
    }

    @Override
    public UtilizadorPojo selecionarUtilizador(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
