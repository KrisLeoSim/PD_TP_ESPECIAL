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
        System.out.println("Gestão de utilizadores");
        System.out.println("  1  - Adicionar Utilizador");
        System.out.println("  2  - Remover Utilizador");
        System.out.println("  3  - Pedidos de registos pendentes");
        System.out.println("--------------------------");
        System.out.println("  0  - Sair");
        System.out.println("--------------------------");
    }
    
    public void cicloDeVidaGestaoUtilizadores() {
      
        try {         
            while(naoSair) {
                imprimeMenuGestaoUtilizadores();
                opcao = obtemOpcaoMenu(4);

                switch(opcao) {
                    case 1:
                        ListaDeUtilizadoresComRegistoPendente();
                        break;
                    case 2:
                       //obtemVoos();
                        break;      
                    case 3:
                         ListaDeUtilizadoresComRegistoPendente();
                        break;
                    case 0:
                       //logout();
                    naoSair = false;
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
    
    //public void obtemVoos(){
    //    List<VoosPojo> listaVoos = controladorEJB.obtemVoos();
    //    for....
    //    imprime....
    //    }

    //public void ListaDeUtilizadoresComRegistoPendente(){
    //listar nome dos utilizadores com registo pendente                      
    //List<String> lista_UCRP =   controladorEJB.ListaDeUtilizadoresComRegistoPendente();
    //listar tambem utilizadores registados no sistema
    //poder selecionar e ver perfil? e editar os dados? (da muito trablaho ... com interface web é bem mais simples ver se é
    //necesario)
    //}
    
    public void ListaDeUtilizadoresComRegistoPendente(){
        
        try {
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("  UTILIZADORES QUE AGUARDAM APROVAÇÂO ");
            System.out.println("--------------------------");
            
            ArrayList<UtilizadorPojo> lista_utilizadores= controladorEJB.listaContasQueAguardamAprovação();
            int i = 1;
            for(UtilizadorPojo utilizadorPojo : lista_utilizadores){
                
            System.out.println(" " + i + "-" + utilizadorPojo.getUsername() + " tipo:" + utilizadorPojo.getTipoUser());
            i++;
            
            }
            System.out.println("0 - sair");
            System.out.println("--------------------------");
            
           // System.out.print("inserir o numero do utilizador: ");
            //String username = sc.nextLine();
            //System.out.println();
     
            
        } catch(Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace(System.out);
        }
  
    }
    
}
