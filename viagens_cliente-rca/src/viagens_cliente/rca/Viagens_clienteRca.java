/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.rca;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import regras.negocio.ControladorRemote;
import viagens_cliente.menu.Cliente;
import viagens_cliente.menu.Menu;
import viagens_cliente.menu.Operador;
import viagens_cliente.menu.Visitante;

/**
 *
 * @author sergio
 */
public class Viagens_clienteRca {

    public static ControladorRemote controladorEJB;
    
    
    //variaveis
    public static String nome = "java:global/viagens_servidor-ea/viagens_servidor-ejb/Controlador!regras.negocio.ControladorRemote";
   
    //public final static String nome = "libregras.negocio.ControladorRemote";
    public  static String ip = "192.168.56.175";
    public  static String port = "3700"; 
     
    // "Ejb_controlos.Utilizador_Remote_BeanRemote"
     
    public static void getRemoteReferences() {

        InitialContext ctx = null;
        Properties prop = new Properties();

        prop.setProperty("java.naming.factory.initial",

                     "com.sun.enterprise.naming.SerialInitContextFactory");

        prop.setProperty("java.naming.factory.url.pkgs",

                     "com.sun.enterprise.naming");

        prop.setProperty("java.naming.factory.state",

                     "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        prop.setProperty("org.omg.CORBA.ORBInitialHost", ip);

        prop.setProperty("org.omg.CORBA.ORBInitialPort", port);

        try {
            ctx = new InitialContext(prop);

        }catch (NamingException e) {

            System.out.println(e.getMessage());

            System.exit(1);
        }

        System.out.println("InitialContext done");

        try {

            System.out.println("start lookup");
            controladorEJB = (ControladorRemote)  ctx.lookup(nome);
            
        }catch(NamingException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("JNDI lookup done");
    }
    
    public static void main(String[] args) throws Exception {
   
        boolean activo = true;
        int estado = 1;
        
        try {
            getRemoteReferences();

            while(activo) {               
                switch(estado) {
                    case 1: //visitante 
                        Menu mVisitante= new Visitante(controladorEJB);
                        estado = mVisitante.cicloDeVida();                    
                        break;
                    case 2://Cliente
                        Menu mCliente= new Cliente(controladorEJB);
                        estado = mCliente.cicloDeVida(); 
                        break;
                    case 3://Operador
                        Menu mOperador= new Operador(controladorEJB);
                        estado = mOperador.cicloDeVida();  
                        break;                      
                    case 0:
                        activo = false;
                        break;
                    default:
                        System.out.println("estado invalido");
                        break;
                }
            }      
            System.out.println("fim do programa");
            
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.exit(0);
        }
    }
       

//             System.out.println("adicionar utilizador");
//        Utilizador um = new Utilizador(); 
//        
//        um.setNome("Joao");
//        //um.setDataNascimento(df.parce("11/5/2000"));
//        um = ejb.guardar(um);
//        System.out.println("utilizador salvo com id: "+ um.getId());
        
        
        
    
    
}
