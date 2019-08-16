/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import javax.ejb.Remote;
import regras.negocio.entidade.CompanhiaPojo;
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
    boolean registaCompanhia(CompanhiaPojo companhiaPojo);
    
    //voo
    ArrayList<VooPojo> listaVoos();    
}
