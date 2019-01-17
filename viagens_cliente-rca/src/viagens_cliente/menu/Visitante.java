/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import logica.ControladorRemote;
import regras.negocio.entidade.UtilizadorPojo;

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
                opcao = obtemOpcaoMenu(10);

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
        try {
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            //String password = readPassword();
            String password = sc.nextLine();
            System.out.println();
            username = "joao";
            password="1234";
            int estado = controladorEJB.login(username, password);
            
            if(estado != 1){
            System.out.println("Bem vindo " + username +"estado: " +estado );
            return estado;
        }
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
        return 1;
    }
    
    private void regista() {
        try {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("  Registar - BREVEMENTE");
        System.out.println("--------------------------");
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private int getEstado(UtilizadorPojo utilizadorPojo) {
        int estado = ESTADO_VISITANTE;
        if(utilizadorPojo != null){
        System.out.println("Bem vindo " + utilizadorPojo.getPrimeiroNome());
        switch(utilizadorPojo.getTipoUser()){
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
