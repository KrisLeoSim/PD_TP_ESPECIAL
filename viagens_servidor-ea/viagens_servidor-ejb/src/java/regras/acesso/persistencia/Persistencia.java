/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.persistencia;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author sergio
 * @param <T>
 */
public interface Persistencia<T> {
     
    
    public EntityManager getEntityManager();
    
    public T criar(T entidade) throws Exception;   
    public void excluir(T entidade) throws Exception;  
    public T editar(T entidade) throws Exception;

    public T get(int id);
    public List<T> getAll();
}
