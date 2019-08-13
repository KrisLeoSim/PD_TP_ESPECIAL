/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio.entidade;

import java.io.Serializable;


/**
 *
 * @author sergio
 */

public class ChegadaPojo implements Serializable {
    
    private int idChegada;
    private int dataChegada;
   
    //private LocalPojo idLocal;
  
    //private VooPojo idVoo;

    public ChegadaPojo(int dataChegada) {
        this.dataChegada = dataChegada;
    }

    public int getIdChegada() {
        return idChegada;
    }

    public void setIdChegada(int idChegada) {
        this.idChegada = idChegada;
    }

    public int getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(int dataChegada) {
        this.dataChegada = dataChegada;
    }

    @Override
    public String toString() {
        return "ChegadaPojo{" + "idChegada=" + idChegada + ", dataChegada=" + dataChegada + '}';
    }
 
}
