/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;


import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 */
@Local
public interface LocalFacadeLocal {
    public EntityManager getEntityManager();

    public boolean registarLocal(entidade.Local entidade);

    public boolean excluirLocal(entidade.Local entidade);

    public boolean editarLocal(entidade.Local entidade);

    public entidade.Local getLocal(int id);

    public List<entidade.Local> getAllLocais(); 
}
