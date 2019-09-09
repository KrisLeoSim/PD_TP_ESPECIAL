/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author sergio
 */
public class Tempo {
    private final int VALOR_MAX = 30;
    private final int VALOR_MIN = 0;
    int tempo;

    public Tempo(int valorInicial) {
        this.tempo = valorInicial;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getVALOR_MAX() {
        return VALOR_MAX;
    }

    public int getVALOR_MIN() {
        return VALOR_MIN;
    }
    
    @Override
    public String toString() {
        return "Tempo{" + "tempo=" + tempo + '}';
    }

}
