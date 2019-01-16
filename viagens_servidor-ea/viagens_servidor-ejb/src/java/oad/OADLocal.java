/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oad;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import regras.acesso.entidade.User;

/**
 *
 * @author sergio
 */
@Local
public interface OADLocal {

    public EntityManager getEntityManager();
    
//      public User login(String username, String password) ;
//      public User getUtilizador(int id);
//    public Utilizador criarUtilizador(Utilizador utilizador) throws Exception; 
//    public void excluirUtilizador(Utilizador utilizador) throws Exception;
//    public Utilizador editarUtilizador(Utilizador utilizador) throws Exception;
//    public List<Utilizador> listaUtilizadores() throws Exception;
}
