/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio;

import lib.regras.negocio.ControladorRemote;
import javax.ejb.ApplicationException;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import regras.acesso.entidade.User;
import regras.acesso.persistencia.UtilizadorP;
import lib.regras.negocio.entidade.UtilizadorPojo;
import utils.Conversor;

/**
 *
 * @author sergio
 */
@Stateful
public class Controlador implements ControladorRemote {

     private boolean logado = false;
    
    @EJB
    private UtilizadorP utilizadorPersistence;
    
    
    @Override
    public UtilizadorPojo login(String username, String password) throws Exception {
       try {
//            String passwordHash = Crypto.messageDigest(password);
        
//            UtilizadorExtended user = operacoes.login(username, passwordHash);
            User user = utilizadorPersistence.getUtilizador(username, password);

            if (user == null) {
                //throw new UserNotFoundException();
                return null;
            }else if (user.getEstado() != 1) {
                return null;
                //throw new UserNotActiveException();
            }
            logado = true;

            utilizadorPersistence.atualizaUltimoLogin(user);

            Conversor<UtilizadorPojo> UtilizadorToPojo = new Conversor<>();
            UtilizadorPojo utilizadorPojo = UtilizadorToPojo.convert(user, UtilizadorPojo.class);

            //utilizadorPojo.setPassword("");
            return utilizadorPojo;
        } catch(Exception e) {
            //throw e;
        }
         //throw new RemoteException(e);
         finally{
       return null;
       }
    }
    
    @Override
    public UtilizadorPojo atualizaUtilizador(UtilizadorPojo utilizador) throws Exception {
       /*   try {
            if( !logado ) {
                //throw new NotLogedOnException();
            }
            Conversor<User> userConverter = new Conversor<>();
            User u = userConverter.convert(utilizador, User.class);

//            Collection<Perfil> listPerfis = operacoes.listaPerfis();
          Collection<Perfil> listPerfis = perfilController.getEntidades();
            ArrayList<Perfil> perfisUtilizador = new ArrayList<>();
            
            //converter perfis
            {
                Collection<PerfilConsola> perfisConsola = utilizador.getPerfilCollection();
                for(PerfilConsola pc : perfisConsola) {

                    for( Perfil p : listPerfis ) {
                        if( p.getId().equals(pc.getId()) ) {
                            if( !perfisUtilizador.contains(p) ) {
                                perfisUtilizador.add(p);
                            }
                            break;
                        }
                    }
                }
                u.setPerfilCollection(perfisUtilizador);
            }

//            operacoes.editarUtilizador(u);
            utilizadorController.editarEntidade(u);
//            Utilizador este = operacoes.getUtilizador(u.getId());
            Utilizador este = utilizadorController.getEntidade(u.getId());

            //registar o utilizador no perfil
            {
                for(Perfil p : listPerfis) {
                    if( p.getUtilizadorCollection().contains(este) && !este.getPerfilCollection().contains(p) ) {
                        p.getUtilizadorCollection().remove(este);
//                        operacoes.editarPerfil(p);
                        perfilController.editarEntidade(p);
                    } else if( !p.getUtilizadorCollection().contains(este) && este.getPerfilCollection().contains(p) ) {
                        p.getUtilizadorCollection().add(este);
//                        operacoes.editarPerfil(p);
                        perfilController.editarEntidade(p);
                    }
                }
            }
            UtilizadorConsola novoUtilizadorConsola = converteUtilizadorParaConsola(este);
            
            novoUtilizadorConsola.setPassword("");
            return novoUtilizadorConsola;
            
        } catch(ApplicationException e) {
            throw e;
        } catch(Exception e) {
            throw new RemoteException(e);
        }*/
       return null;
    }

    @Override
    public void logout() {
        logado = false;
    }

    @Override
    public UtilizadorPojo registaUtilizador(UtilizadorPojo utilizador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
