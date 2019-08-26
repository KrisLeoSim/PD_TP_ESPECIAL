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
import persistencia.CompanhiaFacadeLocal;
import persistencia.TempoFacadeLocal;
import persistencia.UtilizadorFacadeLocal;
import persistencia.VooFacadeLocal;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;


/**
 *
 * @author sergio
 */
@Stateful
public class Controlador implements ControladorRemote {

    @EJB
    private TempoFacadeLocal tempoFacade;

    @EJB
    private VooFacadeLocal vooFacade;

    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    
    @EJB
    private CompanhiaFacadeLocal companhiaFacade;
    
    

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
        return tempoFacade.getTempoAtual();
    }

    @Override
    public void alteraTempo(int valor) {
        tempoFacade.alterarTempo(valor);
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
    public boolean editarUtilizador(UtilizadorPojo novosDados) {
        
        try {
             Utilizador utilizadorAactualizar = util.convertePojoToEntity.converteUtilizadorToUtilizadorPojo(novosDados);

            if (utilizadorAactualizar == null) {
                return false;
            }

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
    public UtilizadorPojo selecionarUtilizador(int id) {
        return util.converteEntityToPojo.converteUtilizadorToUtilizadorPojo(utilizadorFacade.getUtilizador(id));
    }
    
    /*
    //Companhia
    public boolean registaCompanhia(CompanhiaPojo companhiaPojo){
 
    }
    
    
    public boolean editarCompanhia(CompanhiaPojo companhiaPojo);
    public boolean apagaCompanhia(int idCompanhia){
    try {
            Companhia companhiaAapagar = companhiaFacade.getCompanhia(idCompanhia);

            if (companhiaAapagar == null) {
                return false;
            }
          
            companhiaFacade.excluirCompanhia(companhiaAapagar);

        } catch (Exception e) {
            return false;
        }

        return true;
    
    }
    public ArrayList<CompanhiaPojo> getCompanhias();
*/

    @Override
    public boolean registaCompanhia(CompanhiaPojo companhiaPojo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //voos
    
    @Override
    public ArrayList<VooPojo> listaVoos() {
        return util.converteEntityToPojo.converteListaDeVooToVooPojo(vooFacade.getAllVoos()); 
    }
}
