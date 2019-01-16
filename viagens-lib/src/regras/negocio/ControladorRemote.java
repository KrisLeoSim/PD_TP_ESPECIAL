/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio;

import javax.ejb.Remote;
import regras.negocio.entidade.UtilizadorPojo;

/**
 *
 * @author sergio
 */
@Remote
public interface ControladorRemote {

    
    
    UtilizadorPojo login(String nomeutilizador, String palavrapass);
    
}
