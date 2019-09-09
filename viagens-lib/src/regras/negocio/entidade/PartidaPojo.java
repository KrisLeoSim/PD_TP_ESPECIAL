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

public class PartidaPojo implements Serializable {

    
    private int idPartida;    
    private int dataPartida;
    
    private LocalPojo idLocal;
   
    //private Voo idVoo;

    public PartidaPojo(int dataPartida) {
        this.dataPartida = dataPartida;
    }

    public PartidaPojo() {
     
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(int dataPartida) {
        this.dataPartida = dataPartida;
    }

    public LocalPojo getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(LocalPojo idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public String toString() {
        return "PartidaPojo{" + "idPartida=" + idPartida + ", dataPartida=" + dataPartida + '}';
    }

    
    
}
