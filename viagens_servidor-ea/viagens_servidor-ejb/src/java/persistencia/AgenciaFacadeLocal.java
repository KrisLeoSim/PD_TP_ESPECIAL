/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Agencia;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 */
@Local
public interface AgenciaFacadeLocal {
    public EntityManager getEntityManager();

    public boolean registarAgencia(Agencia entidade);

    public boolean excluirAgencia(Agencia entidade);

    public boolean editarAgencia(Agencia entidade);

    public Agencia getAgencia(int id);

    public List<Agencia> getAllAgencias(); 
}
