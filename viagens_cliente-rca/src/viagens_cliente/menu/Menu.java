/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viagens_cliente.menu;

import java.util.Scanner;
import logica.ControladorRemote;

/**
 *
 * @author sergio
 */
public abstract class Menu {
    static Scanner sc = new Scanner(System.in);
    public ControladorRemote controladorEJB;
    public int opcao = -1;
    public boolean naoSair = true;
    public final static int ESTADO_SAIR = 0;
    public final static int ESTADO_VISITANTE = 1;
    public final static int ESTADO_CLIENTE = 2;
    public final static int ESTADO_OPERADOR = 3;
    
    
    
    public Menu(ControladorRemote controladorEJB) {
        this.controladorEJB=controladorEJB;
    }
    
    protected abstract void imprimeMenu();
    public abstract int cicloDeVida();
    public static int obtemOpcaoMenu(int max) {
        int opcao = -1;
        String texto;

        while( true ) {
            try {
                //opcao = sc.nextInt();  -- mais falível e difícil de controlar
                System.out.print("opção -> ");
                texto = sc.nextLine();
                opcao = Integer.parseInt(texto);
                if( (opcao >= 0) && (opcao <= max) ) {
                    System.out.println();
                    return opcao;
                }
                System.out.println("Opção errada. Ver melhor as instruções");
            } catch(NumberFormatException e) {
                System.out.println("Problema no teclado");
            }
        }
    }
 
}
