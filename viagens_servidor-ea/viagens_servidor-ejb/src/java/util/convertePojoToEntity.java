/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Utilizador;
import entidade.Voo;
import java.util.Collection;
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
        entityVoo.setLugarCollection((Collection) vooPojo.getLista_lugars());

        return entityVoo;
    }
}
