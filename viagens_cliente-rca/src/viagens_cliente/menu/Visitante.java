/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import logica.ControladorRemote;

/**
 *
 * @author sergio
 */
public class Visitante extends Menu{    
    
    public Visitante(ControladorRemote controladorEJB) {
        super(controladorEJB);
    }
    
    @Override
    protected void imprimeMenu() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Viagens");
        System.out.println("  1  - Login");
        System.out.println("  2  - Registar");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }

    @Override
    public int cicloDeVida() {
        int estado = ESTADO_VISITANTE;
        try {         
            while(naoSair) {
                imprimeMenu();
                opcao = obtemOpcaoMenu(3);

                switch(opcao) {
                    case 1:
                        estado = login();
                        if(estado != ESTADO_SAIR || estado != ESTADO_VISITANTE)
                        return estado;
                        break;
                    case 2:
                        regista();
                        break;      
                    case 0:                       
                        naoSair = false;
                        estado = ESTADO_SAIR;
                        break;
                    default:                      
                        break;
                }
            }
            System.out.println("fim do menu Visitante");
            
        } catch(Exception e) {
            e.printStackTrace();        
        } 
        return estado;
    }
    
    private int login() {
        
        String tipoDeUtilizador;
        int estado = ESTADO_VISITANTE;
        
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  LOGIN  ");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.println();
            
            
            
            if(controladorEJB.login(username, password)){
            System.out.println("Bem vindo " + username);
            
            tipoDeUtilizador = controladorEJB.getTipoDeUtilizador(username);
            
            estado = getEstado(tipoDeUtilizador);
            
            }
            
            return estado;
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
        return estado;
    }
    
    private void regista() {
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.print("nif: ");
            int nif = sc.nextInt();    
            
            System.out.println();
            if(controladorEJB.registar(username, password, nif)){
                System.out.print("Registou COM sucesso");
            }else{
                System.out.print("Não registou");
            }
            
            System.out.println();
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private int getEstado(String utilizador) {
        int estado = ESTADO_VISITANTE;
        if(utilizador != null){
        
        switch(utilizador){
            case "operador":
                estado = ESTADO_OPERADOR;
                break;
            case "cliente":
                estado = ESTADO_CLIENTE;
                break;
            default:                
        }       
        }       
        return estado;
    }

}
