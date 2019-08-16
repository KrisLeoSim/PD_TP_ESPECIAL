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

    @Override
    public String toString() {
        return "Tempo{" + "tempo=" + tempo + '}';
    }

}
