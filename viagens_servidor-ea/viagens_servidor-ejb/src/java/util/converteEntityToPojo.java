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
        
        for(Utilizador entidadeUtilizador : listUtilizador){
        
        UtilizadorPojo pojoUtilizador= new UtilizadorPojo();
            
        pojoUtilizador.setIdUtilizador(entidadeUtilizador.getIdUtilizador());
        pojoUtilizador.setTipoUser(entidadeUtilizador.getTipoUser());
        pojoUtilizador.setUsername(entidadeUtilizador.getUsername());
        pojoUtilizador.setPassword(entidadeUtilizador.getPassword());
        pojoUtilizador.setNif(entidadeUtilizador.getNif());
        pojoUtilizador.setNacionalidade(entidadeUtilizador.getNacionalidade());
        pojoUtilizador.setEstado(entidadeUtilizador.getEstado());
        
        
        listaConvertida.add(pojoUtilizador);
        }

         return listaConvertida;
    }
    
    public static UtilizadorPojo converteUtilizadorToUtilizadorPojo(Utilizador entidadeUtilizador){
        
        UtilizadorPojo pojoUtilizador= new UtilizadorPojo();
        
        if(entidadeUtilizador == null){
        return pojoUtilizador;
        }
                   
        pojoUtilizador.setIdUtilizador(entidadeUtilizador.getIdUtilizador());
        pojoUtilizador.setTipoUser(entidadeUtilizador.getTipoUser());
        pojoUtilizador.setUsername(entidadeUtilizador.getUsername());
        pojoUtilizador.setPassword(entidadeUtilizador.getPassword());
        pojoUtilizador.setNif(entidadeUtilizador.getNif());
        pojoUtilizador.setNacionalidade(entidadeUtilizador.getNacionalidade());
        pojoUtilizador.setEstado(entidadeUtilizador.getEstado());
      
    return pojoUtilizador;
    }
}
