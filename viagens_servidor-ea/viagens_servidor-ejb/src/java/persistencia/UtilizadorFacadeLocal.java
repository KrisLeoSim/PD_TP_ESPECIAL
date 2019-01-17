/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import entidade.Utilizador;

/**
 *
 * @author sergio
 */
@Local
public interface UtilizadorFacadeLocal {

    public EntityManager getEntityManager();
    
    
    public int login(String nome, String palavrapass );
    
    
    public Utilizador criar(Utilizador entidade) throws Exception;   
    public void excluir(Utilizador entidade) throws Exception;  
    public Utilizador editar(Utilizador entidade) throws Exception;

    public Utilizador get(int id);
    public List<Utilizador> getAll();
}
