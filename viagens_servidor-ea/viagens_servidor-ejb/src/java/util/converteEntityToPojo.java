/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Utilizador;
import java.util.ArrayList;
import java.util.List;
import regras.negocio.entidade.UtilizadorPojo;

/**
 *
 * @author sergio
 */
public class converteEntityToPojo {
    
    
    public static ArrayList<UtilizadorPojo> converteListaDeUtilizadorToUtilizadorPojo(List<Utilizador> listUtilizador){
    
        ArrayList<UtilizadorPojo> listaConvertida = new ArrayList<>();
        
        if(listUtilizador == null || listUtilizador.isEmpty()){
        return listaConvertida;
        }
        
        for(Utilizador utilizador : listUtilizador){
        
        UtilizadorPojo pojoUtilizador= new UtilizadorPojo();
            
        pojoUtilizador.setIdUtilizador(utilizador.getIdUtilizador());
        pojoUtilizador.setTipoUser(utilizador.getTipoUser());
        pojoUtilizador.setUsername(utilizador.getUsername());
        pojoUtilizador.setPassword(utilizador.getPassword());
        
        //Continuar com o resto se necessario .. enfim demasiados dados 
        listaConvertida.add(pojoUtilizador);
        }

         return listaConvertida;
    }
}
