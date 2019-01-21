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

    @Override
    public int cicloDeVida() {
       int estado = ESTADO_OPERADOR;
        try {         
            while(naoSair) {
                imprimeMenu();
                opcao = obtemOpcaoMenu(5);

                switch(opcao) {
                    case 1:
                     //ListaDeUtilizadoresComRegistoPendente();
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
    
}
