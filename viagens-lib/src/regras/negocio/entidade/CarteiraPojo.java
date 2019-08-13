/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio.entidade;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author sergio
 */

public class CarteiraPojo implements Serializable {
    
    private int idCarteira;   
    private int montante;    
    //private UtilizadorPojo idUtilizador; 
    private ArrayList<MovimentoPojo> listaMovimentos;

    public CarteiraPojo(int montante) {
        this.montante = montante;
        this.listaMovimentos = new ArrayList<>();
    }

    public int getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(int idCarteira) {
        this.idCarteira = idCarteira;
    }

    public int getMontante() {
        return montante;
    }

    public void setMontante(int montante) {
        this.montante = montante;
    }

    public ArrayList<MovimentoPojo> getListaMovimentos() {
        return listaMovimentos;
    }

    public void setListaMovimentos(ArrayList<MovimentoPojo> listaMovimentos) {
        this.listaMovimentos = listaMovimentos;
    }

    @Override
    public String toString() {
        return "CarteiraPojo{" + "idCarteira=" + idCarteira + ", montante=" + montante + ", listaMovimentos=" + listaMovimentos + '}';
    }
 
}
