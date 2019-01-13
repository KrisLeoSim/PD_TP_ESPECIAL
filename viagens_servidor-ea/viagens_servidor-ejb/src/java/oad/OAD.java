/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oad;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import regras.acesso.persistencia.UtilizadorP;

/**
 *
 * @author sergio
 */
@Singleton
public class OAD implements OADLocal {
    
    @PersistenceContext
    private EntityManager em;

    private UtilizadorP utilizadorPersistencia;

    
//   @Override
//    public UtilizadorExtended login(String username, String password) {
//        return utilizadorPersistencia.getUtilizador(username, password);
//    }
//    
//    @Override
//    public Utilizador getUtilizador(int id) throws Exception {
//        return utilizadorPersistencia.getEntidade(id);
//    }
//
//    @Override
//    public Utilizador criarUtilizador(Utilizador utilizador) throws Exception{
//        return utilizadorPersistencia.criarEntidade(utilizador);
//    }
//
//    @Override
//    public void excluirUtilizador(Utilizador utilizador) throws Exception{
//        utilizadorPersistencia.excluirEntidade(utilizador);
//    }
    
    
    
    
    
    @PostConstruct
    void inicia() {
       utilizadorPersistencia = new UtilizadorP();
//        perfilController = new PerfilController();
//        produtoController = new ProdutoController();
    }
    
     @PreDestroy
    void encerra() {
        em.close();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
