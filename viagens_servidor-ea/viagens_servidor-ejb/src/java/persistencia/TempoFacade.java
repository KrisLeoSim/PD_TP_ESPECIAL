/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Compra_;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.Timer;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import util.Tempo;

/**
 *
 * @author sergio
 */
@Singleton
//@Startup
public class TempoFacade implements TempoFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //@Resource
    //private  SessionContext sessionCtx;    
    
    //String timer_name = "Tempo";
    
    //private TimerService timeService;
    private int valor_atual=1;
private final Tempo tempo = new Tempo(valor_atual);
 /*
    
    
    
    
    @PostConstruct
    private void startCrono(){
        apagaTempos();
        timeService= sessionCtx.getTimerService();
        tempo = new Tempo(0);
        //cronometro de 1 em 1 segundo
        timeService.createTimer(10*1000,1*1000, timer_name);
    }
    */
    
    @Schedule(second="*/1", minute="*", hour="*")
    public void incrementaTempo(){
        valor_atual++;
        tempo.setTempo(valor_atual);
    }
    
    
    //@PreDestroy
    @Override
    public void para(){
       // apagaTempos();
    }
    
    @Override
    public void apagaTempos(){
        /*TimerService timers_em_execucao= this.sessionCtx.getTimerService();
        Collection<Timer> cronos= timers_em_execucao.getTimers();
        
        cronos.stream().filter((x) -> (x.getInfo().equals(this.timer_name)==true)).forEachOrdered((x) -> {
            x.cancel();
        });*/
        
        
        
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
    
    
}
