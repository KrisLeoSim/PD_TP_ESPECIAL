/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Voo;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 */
@Local
public interface VooFacadeLocal {

    public EntityManager getEntityManager();

    public boolean registarVoo(Voo entidade);

    public boolean excluirVoo(Voo entidade);

    public boolean editarVoo(Voo entidade);

    public Voo getVoo(int id);

    public List<Voo> getAllVoos();
    
    public List<Voo> viagensMaisLugaresDisponiveis();

}
