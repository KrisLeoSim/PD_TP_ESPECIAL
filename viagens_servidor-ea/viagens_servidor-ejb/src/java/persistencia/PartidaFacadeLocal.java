/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Companhia;
import entidade.Partida;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 */
@Local
public interface PartidaFacadeLocal {

    public EntityManager getEntityManager();

    public boolean registarPartida(Partida entidade);

    public boolean excluirPartida(Partida entidade);

    public boolean editarPartida(Partida entidade);

    public Companhia getPartida(int id);

    public List<Companhia> getAllPartidas();
}
