/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Agencia;
import entidade.Companhia;
import entidade.Local;
import entidade.Utilizador;
import entidade.Voo;
import java.util.Collection;
import regras.negocio.entidade.AgenciaPojo;
import regras.negocio.entidade.CompanhiaPojo;
import regras.negocio.entidade.LocalPojo;
import regras.negocio.entidade.UtilizadorPojo;
import regras.negocio.entidade.VooPojo;

/**
 *
 * @author sergio
 */
public class convertePojoToEntity {

    public static Utilizador converteUtilizadorToUtilizadorPojo(UtilizadorPojo utilizadorPojo) {

        Utilizador entityUtilizador = new Utilizador();

        if (utilizadorPojo == null) {
            return null;
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

    //Voo
    public static Voo converteVooToVooPojo(VooPojo vooPojo) {

        Voo entityVoo = new Voo();

        if (vooPojo == null) {
            return null;
        }

        entityVoo.setIdVoo(vooPojo.getIdVoo());
        entityVoo.setDuracaoVoo(vooPojo.getDuracaoVoo());
        entityVoo.setLugaresDisponiveis(vooPojo.getLugaresDisponiveis());
        entityVoo.setLugaresMaximo(vooPojo.getLugaresMaximo());

        entityVoo.setPartidaCollection((Collection) vooPojo.getLista_partidas());
        entityVoo.setChegadaCollection((Collection) vooPojo.getLista_chegadas());
        //entityVoo.setLugarCollection((Collection) vooPojo.getLista_lugars());

        return entityVoo;
    }

    //local
    //local
    public static Local converteLocalPojoToLocal(LocalPojo PojoLocal) {
        Local entidade = new Local();

        if (PojoLocal == null) {
            return null;
        }

        entidade.setIdLocal(PojoLocal.getIdLocal());
        entidade.setPais(PojoLocal.getPais());
        entidade.setCidade(PojoLocal.getCidade());
        entidade.setDescricaoLocal(PojoLocal.getDescricaoLocal());
        //pojoAgencia.setVoos(voos);
        return entidade;
    }

    public static Companhia converteCompanhiaPojoToCompanhia(CompanhiaPojo PojoCompanhia) {
        Companhia entidade = new Companhia();

        if (PojoCompanhia == null) {
            return null;
        }

        entidade.setIdCompanhia(PojoCompanhia.getIdCompanhia());
        entidade.setNome(PojoCompanhia.getNome());

        return entidade;
    }

    public static Agencia converteAgenciaPojoToAgencia(AgenciaPojo PojoAgencia) {
        Agencia entidade = new Agencia();

        if (PojoAgencia == null) {
            return null;
        }

        entidade.setIdAgencia(PojoAgencia.getIdAgencia());
        entidade.setNome(PojoAgencia.getNome());

        return entidade;
    }
}
