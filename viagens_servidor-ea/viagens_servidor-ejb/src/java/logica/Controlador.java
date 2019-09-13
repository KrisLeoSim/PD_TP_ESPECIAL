/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import entidade.Agencia;
import entidade.Companhia;
import entidade.Local;
import entidade.Utilizador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import persistencia.AgenciaFacadeLocal;
import persistencia.CompanhiaFacadeLocal;
import persistencia.LocalFacadeLocal;
import persistencia.TempoFacadeLocal;
import persistencia.UtilizadorFacadeLocal;
import persistencia.VooFacadeLocal;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LocalPojo;
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
    
    @EJB
    private AgenciaFacadeLocal agenciaFacade;
    
    @EJB
    private LocalFacadeLocal localFacade;
    
    

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
    public void velocidadeDoTempo(int valor) {
        tempoFacade.velocidadeDoTempo(valor);
    }
    
    @Override
    public void activarTempo(){
        tempoFacade.activarTempo();
    }
    
    @Override
    public void paraTempo(){
        tempoFacade.paraTempo();
    }

    @Override
    public boolean isTempoActivado(){
        return tempoFacade.isTempoActivado();
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
   

    @Override
    public boolean registarCompanhia(CompanhiaPojo companhiaPojo) {
        try {
             Companhia entidadeAactualizar = util.convertePojoToEntity.converteCompanhiaPojoToCompanhia(companhiaPojo);

            if (entidadeAactualizar == null) {
                return false;
            }
           
            companhiaFacade.editarCompanhia(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
    //voos
    
    @Override
    public ArrayList<VooPojo> listaVoos() {
        return util.converteEntityToPojo.converteListaDeVooToVooPojo(vooFacade.getAllVoos()); 
    }

    @Override
    public boolean editarCompanhia(CompanhiaPojo companhiaPojo) {
      try {
             Companhia entidadeAactualizar = util.convertePojoToEntity.converteCompanhiaPojoToCompanhia(companhiaPojo);

            if (entidadeAactualizar == null) {
                return false;
            }

            companhiaFacade.editarCompanhia(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<CompanhiaPojo> listaCompanhias() {
        return util.converteEntityToPojo.converteListaDeCompanhiaToCompanhiaPojo(companhiaFacade.getAllCompanhias()); 
    }

    @Override
    public boolean registarAgencia(AgenciaPojo agenciaPojo) {
          try {
             Agencia entidadeAactualizar = util.convertePojoToEntity.converteAgenciaPojoToAgencia(agenciaPojo);

            if (entidadeAactualizar == null) {
                return false;
            }
           
            agenciaFacade.editarAgencia(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean editarAgencia(AgenciaPojo agenciaPojo) {
        try {
             Agencia entidadeAactualizar = util.convertePojoToEntity.converteAgenciaPojoToAgencia(agenciaPojo);

            if (entidadeAactualizar == null) {
                return false;
            }

            agenciaFacade.editarAgencia(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<AgenciaPojo> listaAgencias() {
        return util.converteEntityToPojo.converteListaDeAgenciaToAgenciaPojo(agenciaFacade.getAllAgencias()); 
    }

    @Override
    public boolean registarLocal(LocalPojo localPojo) {
          try {
             Local entidadeAactualizar = util.convertePojoToEntity.converteLocalPojoToLocal(localPojo);

            if (entidadeAactualizar == null) {
                return false;
            }
           
            localFacade.editarLocal(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean editarLocal(LocalPojo localPojo) {
     try {
             Local entidadeAactualizar = util.convertePojoToEntity.converteLocalPojoToLocal(localPojo);

            if (entidadeAactualizar == null) {
                return false;
            }

            localFacade.editarLocal(entidadeAactualizar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<LocalPojo> listaLocais() {
        return util.converteEntityToPojo.converteListaDeLocalToLocalPojo(localFacade.getAllLocais()); 
    }

    @Override
    public boolean excluirCompanhia(CompanhiaPojo companhiaPojo) {
        try {
            Companhia companhiaAapagar = companhiaFacade.getCompanhia(companhiaPojo.getIdCompanhia());

            if (companhiaAapagar == null) {
                return false;
            }
          
            companhiaFacade.excluirCompanhia(companhiaAapagar);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean excluirAgencia(AgenciaPojo agenciaPojo) {
       try {
            Agencia agenciaaAapagar = agenciaFacade.getAgencia(agenciaPojo.getIdAgencia());

            if (agenciaaAapagar == null) {
                return false;
            }
          
            agenciaFacade.excluirAgencia(agenciaaAapagar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean excluirLocal(LocalPojo localPojo) {
         try {
            Local localAapagar = localFacade.getLocal(localPojo.getIdLocal());

            if (localAapagar == null) {
                return false;
            }
          
            localFacade.excluirLocal(localAapagar);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
