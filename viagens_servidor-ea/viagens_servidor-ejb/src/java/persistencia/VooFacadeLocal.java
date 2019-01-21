/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Utilizador;
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
    
    
    public List<Voo> obtemVoosActivos();
    
    
    //operações basicas
    public EntityManager getEntityManager();
    
    public Voo criarVoo(Voo entidade) throws Exception;   
    public void excluirVoo(Voo entidade) throws Exception;  
    public Voo editarVoo(Voo entidade) throws Exception;

    public Voo getVoo(int id);
    public List<Voo> getAllVoo();
}
