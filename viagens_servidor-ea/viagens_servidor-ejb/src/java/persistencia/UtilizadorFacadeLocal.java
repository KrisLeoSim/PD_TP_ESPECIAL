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
    
    public Utilizador login(String nome, String palavrapass);
    public boolean registar(String nome, String palavrapass, String nif, String tipoDeUtilizador );
    
    public Utilizador atualizaUltimoLogin(Utilizador utilizador) throws Exception;
    //operações basicas
    
    public EntityManager getEntityManager();
    
    public Utilizador criarUtilizador(Utilizador entidade) throws Exception;   
    public void excluirUtilizador(Utilizador entidade) throws Exception;  
    public Utilizador editarUtilizador(Utilizador entidade) throws Exception;

    public Utilizador getUtilizador(int id);
    public List<Utilizador> getAllUtilizadores();
    
    public List<Utilizador> getTodosUtilizadoresQueAguardamAprovacao();
    public List<Utilizador> getClientes();
    public List<Utilizador> getOperadores();
}
