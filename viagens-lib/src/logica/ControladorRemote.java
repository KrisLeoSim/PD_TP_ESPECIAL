/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import javax.ejb.Remote;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LocalPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;


/**
 *
 * @author sergio
 */
@Remote
public interface ControladorRemote {

    boolean login(String utilizador, String password);
    String getTipoDeUtilizador(final String tipoDeUtilizador);
    
    //Tempo
    int tempoAtual();
    void alteraTempo(int valor);
    void velocidadeDoTempo(int valor);
    void activarTempo();
    void paraTempo();
    boolean isTempoActivado();
    
    boolean registarOperador(String username, String password, String nif);
    boolean registarUtilizador(String username, String password, String nif);
    
    //Utilizador  
    boolean actualizaUtilizadorEstado(UtilizadorPojo novosDados);
    boolean apagaUtilizador(int idUtilizador);
    boolean editarUtilizador(UtilizadorPojo novosDados);
    UtilizadorPojo selecionarUtilizador(int id);
    
    ArrayList<UtilizadorPojo> listaContasQueAguardamAprovação();
    ArrayList<UtilizadorPojo> listaClientes();
    ArrayList<UtilizadorPojo> listaOperadores();
    
    //Companhia
    boolean registarCompanhia(CompanhiaPojo companhiaPojo);
    boolean editarCompanhia(CompanhiaPojo companhiaPojo);
    boolean excluirCompanhia(CompanhiaPojo companhiaPojo);
    ArrayList<CompanhiaPojo> listaCompanhias();
    
    //Agencia
    boolean registarAgencia(AgenciaPojo agenciaPojo);
    boolean editarAgencia(AgenciaPojo agenciaPojo);
    boolean excluirAgencia(AgenciaPojo agenciaPojo);
    ArrayList<AgenciaPojo> listaAgencias();
    
    //Local
    boolean registarLocal(LocalPojo localPojo);
    boolean editarLocal(LocalPojo localPojo);
    boolean excluirLocal(LocalPojo localPojo);
    ArrayList<LocalPojo> listaLocais();
    
    //voo
    ArrayList<VooPojo> listaVoos();    
}
