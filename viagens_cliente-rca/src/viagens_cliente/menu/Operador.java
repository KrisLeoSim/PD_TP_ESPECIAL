/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import java.util.ArrayList;
import logica.ControladorRemote;
import regras.negocio.entidade.UtilizadorPojo;

/**
 *
 * @author sergio
 */
public class Operador extends Menu {

    public Operador(ControladorRemote controladorEJB) {
        super(controladorEJB);
    }

    @Override
    protected void imprimeMenu() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Operador");
        System.out.println("  1  - Gestão de utilizadores");
        System.out.println("  2  - Controlo do tempo");
        System.out.println("  3  - Consultar voos e ocupações");
        System.out.println("  4  - Consultar logs da aplicação");    
        System.out.println("--------------------------");
        System.out.println("  0  - logout");
        System.out.println("--------------------------");
    }
    
    protected void imprimeMenuGestaoUtilizadores() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("GESTÂO DE UTILIZADORES");
        System.out.println("  1  - Registar utilizador");
        System.out.println("  2  - Remover utilizador");
        System.out.println("  3  - Editar utilizadores");
        System.out.println("  4  - Pedidos de registo pendentes");        
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }
     
    protected void imprimeMenuGestaoUtilizadores_Registar() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("REGISTAR");
        System.out.println("  1  - Cliente");
        System.out.println("  2  - Operador");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }
    
    protected void imprimeMenuGestaoUtilizadores_Editar() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("EDITAR");
        System.out.println("  1  - Username");
        System.out.println("  2  - Password");
        System.out.println("  3  - Cidade");
        System.out.println("  4  - Nif");
        System.out.println("--------------------------");
        System.out.println("  0  - Voltar");
        System.out.println("--------------------------");
    }
    
    public void cicloDeVidaGestaoUtilizadores_Registar() {
      boolean naoSairRegistar= true;
       
      try {         
            while(naoSairRegistar) {
                imprimeMenuGestaoUtilizadores_Registar();
                
                opcao = obtemOpcaoMenu(3);

                switch(opcao) {
                    case 1:
                        registarCliente();
                        break;
                    case 2:
                        registarOperador();
                        break;      
                    case 0:
                    naoSairRegistar = false;
                    break;                        
                    default:                      
                        break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();        
        } 
    } 
     
    public void cicloDeVidaGestaoUtilizadores() {
      boolean naoSairUtilizador = true;
       
      try {         
            while(naoSairUtilizador) {
                imprimeMenuGestaoUtilizadores();
                
                opcao = obtemOpcaoMenu(5);

                switch(opcao) {
                    case 1:
                        cicloDeVidaGestaoUtilizadores_Registar();
                        break;
                    case 2:
                        removerUtilizador() ;
                        break;      
                    case 3:
                        editarUtilizadores(); 
                         
                        break;
                    case 4:
                        ListaDeUtilizadoresComRegistoPendente();                 
                        break;
                    case 0:
                       //logout();
                    naoSairUtilizador = false;
                    break;                        
                    default:                      
                        break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();        
        } 
    }
    
    @Override
    public int cicloDeVida() {
       int estado = ESTADO_OPERADOR;
        try {         
            while(naoSair) {
                imprimeMenu();
                opcao = obtemOpcaoMenu(5);

                switch(opcao) {
                    case 1:
                        cicloDeVidaGestaoUtilizadores();
                        break;
                    case 2:
                       //obtemVoos();
                        break;      
                    case 3:
                        
                        break;
                    case 4:
                  
                        break;
                    case 0:
                       //logout();
                    naoSair = false;
                    estado = ESTADO_VISITANTE;
                    System.out.println("Operador log out");
                    break;                        
                    default:                      
                        break;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();        
        } 
        return estado;
    }

    //Utilizadores
    
    public ArrayList<UtilizadorPojo> ListarUtilizadores(){
            
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  UTILIZADORES ");
            System.out.println("--------------------------");
            
            ArrayList<UtilizadorPojo> lista_utilizadores= controladorEJB.listaClientes();
            
            int i = 1;
            for(UtilizadorPojo utilizadorPojo : lista_utilizadores){
                
                System.out.println(" " + i + "-" + utilizadorPojo.getUsername() + " tipo:" + utilizadorPojo.getTipoUser());
                i++;
            
            }
            
            if(lista_utilizadores.isEmpty()){            
            System.out.println("Não tem Utilizadores");
            }
            
    return lista_utilizadores;
    }
    
    public void ListaDeUtilizadoresComRegistoPendente(){
        
        try {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  UTILIZADORES QUE AGUARDAM APROVAÇÂO ");
            System.out.println("--------------------------------------");
            
            ArrayList<UtilizadorPojo> lista_utilizadores= controladorEJB.listaContasQueAguardamAprovação();
            int i = 1;
            for(UtilizadorPojo utilizadorPojo : lista_utilizadores){

                System.out.println(" " + i + "-" + utilizadorPojo.getUsername() + " tipo:" + utilizadorPojo.getTipoUser());
                i++;

            }
            
            if(!lista_utilizadores.isEmpty()){
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
                --opcao;
                if(opcao != -1){
                
                    UtilizadorPojo utilizadorPojo = lista_utilizadores.get(opcao);
                    utilizadorPojo.setEstado(1);
                    
                    controladorEJB.actualizaUtilizadorEstado(utilizadorPojo);
              
                }

            }else{
            System.out.println("Não tem pedido pendentes");
            }
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
  
    }
    
    
    private void editarUtilizadores(){
        try {
            
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  EDITAR UTILIZADORES  ");
            System.out.println("--------------------------------------");
            
            ArrayList<UtilizadorPojo> lista_utilizadores = ListarUtilizadores();
                              
            if(!lista_utilizadores.isEmpty()){
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
            --opcao;
            if(opcao != -1){
                
                UtilizadorPojo utilizadorPojo = lista_utilizadores.get(opcao);      
                imprimeMenuGestaoUtilizadores_Editar();
                
                opcao = obtemOpcaoMenu(5);
              
                switch(opcao){
                    case 1:
                        System.out.print("username: ");
                        String username = sc.nextLine();
                        utilizadorPojo.setUsername(username);
                        break;
                    case 2:
                         System.out.print("password: ");
                         String password = sc.nextLine();
                        utilizadorPojo.setPassword(password);
                        break;
                    case 3:
                         System.out.print("cidade: ");
                         String cidade = sc.nextLine(); 
                         utilizadorPojo.setPais(cidade);
                    case 4:
                         System.out.print("nif: ");
                         String nif = sc.next(); 
                         utilizadorPojo.setNif(nif);
                        break;
                
                }              
                
            if(controladorEJB.editarUtilizador(utilizadorPojo)){
                System.out.print("Editou COM sucesso");
            }else{
                System.out.print("Não foi possivel editar");
            }
            }
            
            
            }else{
            System.out.println("Não ha utilizadores");
            }

        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
    
    }
    
    private void removerUtilizador() {
        
        try {
            
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("  UTILIZADORES  ");
            System.out.println("--------------------------------------");
            
            ArrayList<UtilizadorPojo> lista_utilizadores = ListarUtilizadores();
          
                    
            if(!lista_utilizadores.isEmpty()){
                System.out.println("0 - Voltar ...");
                opcao = obtemOpcaoMenu(lista_utilizadores.size());
            --opcao;
            if(opcao != -1){
                
                int id = lista_utilizadores.get(opcao).getIdUtilizador();
                
            if(controladorEJB.apagaUtilizador(id)){
                System.out.print("Apagou COM sucesso");
            }else{
                System.out.print("Não foi possivel apagar");
            }
            }
            
            
            }else{
            System.out.println("Não ha utilizadores");
            }

        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
    }
    
    private void registarCliente() {
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR CLIENTE");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.print("nif: ");
            String nif = sc.next();    
            //TODO fazer verificaçao do nif
            System.out.println();
            if(controladorEJB.registarUtilizador(username, password, nif)){
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
    
    private void registarOperador() {
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  REGISTAR OPERADOR");
            System.out.println("--------------------------");
            System.out.print("username: ");
            String username = sc.nextLine();
            System.out.print("password: ");
            String password = sc.nextLine();
            System.out.print("nif: ");
            String nif = sc.next();    
            //TODO fazer verificaçao do nif
            System.out.println();
            if(controladorEJB.registarUtilizador(username, password, nif)){
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
}
