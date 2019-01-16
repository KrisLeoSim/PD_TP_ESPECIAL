/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import regras.negocio.ControladorRemote;

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
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Operador");
        System.out.println("--------------------------");
        return ESTADO_VISITANTE;
    }
    
}
