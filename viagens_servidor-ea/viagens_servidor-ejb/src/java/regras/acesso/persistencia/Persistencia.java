/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.persistencia;

/**
 *
 * @author sergio
 */
public interface Persistencia<T> {
     
    public T criarEntidade(T entidade) throws Exception;   
    public void excluirEntidade(T entidade) throws Exception;  
    public T editarEntidade(T entidade) throws Exception;

    public T getEntidade(int id);
}
