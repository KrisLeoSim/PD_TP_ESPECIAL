/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Remote;


/**
 *
 * @author sergio
 */
@Remote
public interface ControladorRemote {

    boolean login(String utilizador, String password);
    boolean registar(String username, String password, String nif);
    String getTipoDeUtilizador(final String tipoDeUtilizador);

}
