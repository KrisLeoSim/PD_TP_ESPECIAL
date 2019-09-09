/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Agencia;
import entidade.Chegada;
import entidade.Companhia;
import entidade.Partida;
import entidade.Utilizador;
import entidade.Local;
import entidade.Voo;
import java.util.ArrayList;
import java.util.List;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.ChegadaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LocalPojo;
import regras.negocio.entidade.PartidaPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;

/**
 *
 * @author sergio
 */
public class converteEntityToPojo {

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
        pojoVoo.setLista_partidas(
                converteListaDePartidaToPartidaPojo((List) entidadeVoo.getPartidaCollection()));
        pojoVoo.setLista_chegadas(
                converteListaDeChegadaToChegadaPojo((List) entidadeVoo.getChegadaCollection()));

        //pojoVoo.setLista_lugars((ArrayList<LugarPojo>) (List) entidadeVoo.getLugarCollection());
        pojoVoo.setIdAgencia(
                converteAgenciaToAgenciaPojo(entidadeVoo.getIdAgencia()));

        pojoVoo.setIdCompanhia(
                converteCompanhiaToCompanhiaPojo(entidadeVoo.getIdCompanhia()));

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

    //local
    public static LocalPojo converteLocalToPLocalPojo(Local entidadeLocal) {
        LocalPojo pojoLocal = new LocalPojo();

        if (entidadeLocal == null) {
            return null;
        }

        pojoLocal.setIdLocal(entidadeLocal.getIdLocal());
        pojoLocal.setCidade(entidadeLocal.getCidade());
        pojoLocal.setPais(entidadeLocal.getPais());

        //pojoAgencia.setVoos(voos);
        return pojoLocal;
    }

    //partida
    public static PartidaPojo convertePartidaToPartidaPojo(Partida entidadePartida) {
        PartidaPojo pojoPartida = new PartidaPojo();

        if (entidadePartida == null) {
            return null;
        }

        pojoPartida.setIdPartida(entidadePartida.getIdPartida());
        pojoPartida.setDataPartida(entidadePartida.getDataPartida());

        pojoPartida.setIdLocal(
                converteLocalToPLocalPojo(entidadePartida.getIdLocal()));

        //pojoAgencia.setVoos(voos);
        return pojoPartida;
    }

    //chegada
    public static ChegadaPojo converteChegadaToChegadaPojo(Chegada entidadeChegada) {
        ChegadaPojo pojoChegada = new ChegadaPojo();

        if (entidadeChegada == null) {
            return null;
        }

        pojoChegada.setIdChegada(entidadeChegada.getIdChegada());
        pojoChegada.setDataChegada(entidadeChegada.getDataChegada());

        pojoChegada.setIdLocal(
                converteLocalToPLocalPojo(entidadeChegada.getIdLocal()));

        //pojoAgencia.setVoos(voos);
        return pojoChegada;
    }

    //local
    public static LocalPojo converteLocalToLocalPojo(Local entidadeLocal) {
        LocalPojo pojolocal = new LocalPojo();

        if (entidadeLocal == null) {
            return null;
        }

        pojolocal.setIdLocal(entidadeLocal.getIdLocal());
        pojolocal.setPais(entidadeLocal.getPais());
        pojolocal.setCidade(entidadeLocal.getCidade());
        pojolocal.setDescricaoLocal(entidadeLocal.getDescricaoLocal());
        //pojoAgencia.setVoos(voos);
        return pojolocal;
    }

    //LISTAS
    //Partida lista
    public static ArrayList<PartidaPojo> converteListaDePartidaToPartidaPojo(List<Partida> listPartida) {

        ArrayList<PartidaPojo> listaConvertida = new ArrayList<>();

        if (listPartida == null || listPartida.isEmpty()) {
            return listaConvertida;
        }

        listPartida.stream().map((entidadePartida) -> convertePartidaToPartidaPojo(entidadePartida)).filter((pojoPartida) -> (pojoPartida != null)).forEachOrdered((pojoPartida) -> {
            listaConvertida.add(pojoPartida);
        });

        return listaConvertida;
    }

    //Chegada lista
    public static ArrayList<ChegadaPojo> converteListaDeChegadaToChegadaPojo(List<Chegada> listChegada) {

        ArrayList<ChegadaPojo> listaConvertida = new ArrayList<>();

        if (listChegada == null || listChegada.isEmpty()) {
            return listaConvertida;
        }

        for (Chegada entidadeChegada : listChegada) {

            ChegadaPojo pojoChegada = converteChegadaToChegadaPojo(entidadeChegada);

            if (pojoChegada != null) {
                listaConvertida.add(pojoChegada);
            }

        }

        return listaConvertida;
    }

    //utilizador lista
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

    //Voo lista
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

    //lista companhia
    public static ArrayList<CompanhiaPojo> converteListaDeCompanhiaToCompanhiaPojo(List<Companhia> listCompanhia) {

        ArrayList<CompanhiaPojo> listaConvertida = new ArrayList<>();

        if (listCompanhia == null || listCompanhia.isEmpty()) {
            return listaConvertida;
        }

        for (Companhia entidade : listCompanhia) {

            CompanhiaPojo pojoCompanhia = converteCompanhiaToCompanhiaPojo(entidade);

            if (pojoCompanhia != null) {
                listaConvertida.add(pojoCompanhia);
            }

        }

        return listaConvertida;
    }

    //lista de agencias
    public static ArrayList<AgenciaPojo> converteListaDeAgenciaToAgenciaPojo(List<Agencia> listAgencia) {

        ArrayList<AgenciaPojo> listaConvertida = new ArrayList<>();

        if (listAgencia == null || listAgencia.isEmpty()) {
            return listaConvertida;
        }

        for (Agencia entidade : listAgencia) {

            AgenciaPojo pojoAgencia = converteAgenciaToAgenciaPojo(entidade);

            if (pojoAgencia != null) {
                listaConvertida.add(pojoAgencia);
            }

        }

        return listaConvertida;
    }

    //lista de locais
    public static ArrayList<LocalPojo> converteListaDeLocalToLocalPojo(List<Local> listlocal) {

        ArrayList<LocalPojo> listaConvertida = new ArrayList<>();

        if (listlocal == null || listlocal.isEmpty()) {
            return listaConvertida;
        }

        for (Local entidade : listlocal) {

            LocalPojo pojoLocal = converteLocalToLocalPojo(entidade);

            if (pojoLocal != null) {
                listaConvertida.add(pojoLocal);
            }

        }

        return listaConvertida;
    }
}
