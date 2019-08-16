/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Companhia;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 */
@Local
public interface CompanhiaFacadeLocal {

    public EntityManager getEntityManager();

    public boolean registarCompanhia(Companhia entidade);

    public boolean excluirCompanhia(Companhia entidade);

    public boolean editarCompanhia(Companhia entidade);

    public Companhia getCompanhia(int id);

    public List<Companhia> getAllCompanhias();
}
