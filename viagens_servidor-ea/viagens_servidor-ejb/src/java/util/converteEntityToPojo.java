/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Agencia;
import entidade.Companhia;
import entidade.Utilizador;
import entidade.Voo;
import java.util.ArrayList;
import java.util.List;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.ChegadaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LugarPojo;
import regras.negocio.entidade.PartidaPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;

/**
 *
 * @author sergio
 */
public class converteEntityToPojo {

    public static ArrayList<UtilizadorPojo> converteListaDeUtilizadorToUtilizadorPojo(List<Utilizador> listUtilizador) {

        ArrayList<UtilizadorPojo> listaConvertida = new ArrayList<>();

        if (listUtilizador == null || listUtilizador.isEmpty()) {
            return listaConvertida;
        }

        for (Utilizador entidadeUtilizador : listUtilizador) {

            UtilizadorPojo pojoUtilizador = converteUtilizadorToUtilizadorPojo(entidadeUtilizador);

            if (pojoUtilizador != null) {
                listaConvertida.add(pojoUtilizador);
            }
        }
        return listaConvertida;
    }

    public static UtilizadorPojo converteUtilizadorToUtilizadorPojo(Utilizador entidadeUtilizador) {

        UtilizadorPojo pojoUtilizador = new UtilizadorPojo();

        if (entidadeUtilizador == null) {
            return null;
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

    //Voo
    public static ArrayList<VooPojo> converteListaDeVooToVooPojo(List<Voo> listVoo) {

        ArrayList<VooPojo> listaConvertida = new ArrayList<>();

        if (listVoo == null || listVoo.isEmpty()) {
            return listaConvertida;
        }

        for (Voo entidadeVoo : listVoo) {

            VooPojo pojoVoo = converteVooToVooPojo(entidadeVoo);

            if (pojoVoo != null) {
                listaConvertida.add(pojoVoo);
            }

        }

        return listaConvertida;
    }

    public static VooPojo converteVooToVooPojo(Voo entidadeVoo) {
        VooPojo pojoVoo = new VooPojo();

        if (entidadeVoo == null) {
            return null;
        }

        pojoVoo.setIdVoo(entidadeVoo.getIdVoo());
        pojoVoo.setDuracaoVoo(entidadeVoo.getDuracaoVoo());
        pojoVoo.setLugaresDisponiveis(entidadeVoo.getLugaresDisponiveis());
        pojoVoo.setLugaresMaximo(entidadeVoo.getLugaresMaximo());

        
        //estas listas provavelmente nao vao dar sem antes ter o conversor ou seja conversor de listas como no utlizdor
        //pojoVoo.setLista_partidas((ArrayList<PartidaPojo>) (List) entidadeVoo.getPartidaCollection());
        //pojoVoo.setLista_chegadas((ArrayList<ChegadaPojo>) (List) entidadeVoo.getChegadaCollection());
        //pojoVoo.setLista_lugars((ArrayList<LugarPojo>) (List) entidadeVoo.getLugarCollection());
        
        
        
        pojoVoo.setIdAgencia(
                converteAgenciaToAgenciaPojo(entidadeVoo.getIdAgencia()));
        
        
        //pojoVoo.setIdCompanhia(converteCompanhiaToCompanhiaPojo(entidadeVoo.getIdCompanhia()));

        return pojoVoo;
    }
    
    
    //agencia
     public static AgenciaPojo converteAgenciaToAgenciaPojo(Agencia entidadeAgencia) {
        AgenciaPojo pojoAgencia = new AgenciaPojo();

        if (entidadeAgencia == null) {
            return null;
        }

        pojoAgencia.setIdAgencia(entidadeAgencia.getIdAgencia());
        pojoAgencia.setNome(entidadeAgencia.getNome());
        
        
        
        //pojoAgencia.setVoos(voos);

        return pojoAgencia;
    }
     
     
     //companhia
     public static CompanhiaPojo converteCompanhiaToCompanhiaPojo(Companhia entidadeCompanhia) {
        CompanhiaPojo pojoCompanhia = new CompanhiaPojo();

        if (entidadeCompanhia == null) {
            return null;
        }

        pojoCompanhia.setIdCompanhia(entidadeCompanhia.getIdCompanhia());
         pojoCompanhia.setNome(entidadeCompanhia.getNome());
        
        
        
       // pojoCompanhia.setLista_feedbacks(lista_feedbacks);
       // pojoCompanhia.setLista_voos(lista_voos);

        return pojoCompanhia;
    }
}
