/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Local;

/**
 *
 * @author sergio
 */
@Local
public interface TempoFacadeLocal {
    void velocidadeDoTempo(int novaVelocidade);
    void alterarTempo(int novoTempo);
    int getTempoAtual();
    void paraTempo();
    void activarTempo();
    boolean isTempoActivado();
}
