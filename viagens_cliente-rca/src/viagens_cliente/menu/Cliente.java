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
public class Cliente extends Menu{

    public Cliente(ControladorRemote controladorEJB) {
        super(controladorEJB);
    }

    @Override
    protected void imprimeMenu() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Cliente");
        System.out.println("  1  - Consultar voos activos");    
        System.out.println("--------------------------");
        System.out.println("  0  - logout");
        System.out.println("--------------------------");
    }

    @Override
    public int cicloDeVida() {
       int estado = ESTADO_CLIENTE;
        try {         
            while(naoSair) {
                imprimeMenu();
                opcao = obtemOpcaoMenu(2);

                switch(opcao) {
                    case 1:
                   //List<VoosPojo> listaVoos = controladorEJB.obtemVoosActivos();
                        break;                
                    case 0:
                        //controladorEJB.logout();
                        naoSair = false;
                        estado = ESTADO_VISITANTE;
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
    
}
