/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import util.Tempo;

/**
 *
 * @author sergio
 */
@Singleton
//@Startup
public class TempoFacade implements TempoFacadeLocal {
    
private int valor_atual=1;
private int incremento=1;
private boolean tempoActivado = true;

private final Tempo tempo = new Tempo(valor_atual);
    
    @Schedule(second="*/1", minute="*", hour="*")
    public void incrementaTempo(){
        
        if(tempoActivado){       
        valor_atual+= incremento;
        tempo.setTempo(valor_atual);
        }
        
    }   
    
    @Override
    public void paraTempo(){
        tempoActivado = false;      
    }
    
    @Override
    public void activarTempo(){
        tempoActivado = true;      
    }
    
    @Override
    public void velocidadeDoTempo(int novaVelocidade){
        
        if(novaVelocidade >= tempo.getVALOR_MIN() && novaVelocidade <= tempo.getVALOR_MAX() ){
        incremento = novaVelocidade ;
        }
    
    }
    
    @Override
    public void alterarTempo(int novoTempo){
        tempo.setTempo(novoTempo);
        this.valor_atual = novoTempo;
    }
  
     @Override
    public int getTempoAtual(){
        return this.tempo.getTempo();
    }

    @Override
    public boolean isTempoActivado() {
        return tempoActivado;
    }
    
}
