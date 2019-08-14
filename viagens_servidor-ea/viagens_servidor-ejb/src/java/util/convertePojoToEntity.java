/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Utilizador;
import regras.negocio.entidade.UtilizadorPojo;

/**
 *
 * @author sergio
 */
public class convertePojoToEntity {
      
    
   
   public static Utilizador converteUtilizadorToUtilizadorPojo(UtilizadorPojo utilizadorPojo){
        
        Utilizador entityUtilizador= new Utilizador();
        
        if(entityUtilizador == null){
        return entityUtilizador;
        }
                   
        entityUtilizador.setIdUtilizador(utilizadorPojo.getIdUtilizador());
        entityUtilizador.setTipoUser(utilizadorPojo.getTipoUser());
        entityUtilizador.setUsername(utilizadorPojo.getUsername());
        entityUtilizador.setPassword(utilizadorPojo.getPassword());
        entityUtilizador.setNif(utilizadorPojo.getNif());
        entityUtilizador.setNacionalidade(utilizadorPojo.getNacionalidade());
        entityUtilizador.setEstado(utilizadorPojo.getEstado());
      
    return entityUtilizador;
    }
}
