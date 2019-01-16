/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import oad.OADLocal;
import regras.acesso.entidade.User;
import regras.acesso.persistencia.UtilizadorP;
import regras.negocio.entidade.UtilizadorPojo;
import utils.Conversor;

/**
 *
 * @author sergio
 */
@Stateful
//@LocalBean
public class Controlador implements ControladorRemote {

    private boolean logado = false;
    
    @EJB
    private UtilizadorP utilizadorPersistence;

    
    @Override
    public UtilizadorPojo login(String nomeutilizador, String palavrapass){
        try {

            System.out.println("CONTRO USER:   " );
           
            User user = utilizadorPersistence.getUtilizador(nomeutilizador, palavrapass);
            System.out.println("*****************************************************************   " + user.getPrimeiroNome());
            if (user == null) {               
                return null;
            }else if (user.getEstado() != 1) {
                System.out.println("ESTADO:   " +  user.getEstado());
                return null;
               
            }
            logado = true;

           // utilizadorPersistence.atualizaUltimoLogin(user);

            Conversor<UtilizadorPojo> UtilizadorToPojo = new Conversor<>();
            UtilizadorPojo utilizadorPojo = UtilizadorToPojo.convert(user, UtilizadorPojo.class);

            utilizadorPojo.setPassword("");
            return utilizadorPojo;
        } catch(Exception e) {
            //throw e;
        }
         
         
       return null;
       
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    
}
