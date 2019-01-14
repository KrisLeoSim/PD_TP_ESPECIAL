/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import lib.regras.negocio.ControladorRemote;

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
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Operador");
        System.out.println("--------------------------");
        return ESTADO_VISITANTE;
    }
    
}
