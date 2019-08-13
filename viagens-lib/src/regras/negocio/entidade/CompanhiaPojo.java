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

public class CompanhiaPojo implements Serializable {
    
    private int idCompanhia;   
    private String nome;  
    private ArrayList<FeedbackPojo> lista_feedbacks;  
    private ArrayList<VooPojo> lista_voos;

    public CompanhiaPojo(String nome) {
        this.nome = nome;
    }

    public int getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(int idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<FeedbackPojo> getLista_feedbacks() {
        return lista_feedbacks;
    }

    public void setLista_feedbacks(ArrayList<FeedbackPojo> lista_feedbacks) {
        this.lista_feedbacks = lista_feedbacks;
    }

    public ArrayList<VooPojo> getLista_voos() {
        return lista_voos;
    }

    public void setLista_voos(ArrayList<VooPojo> lista_voos) {
        this.lista_voos = lista_voos;
    }

    @Override
    public String toString() {
        return "CompanhiaPojo{" + "idCompanhia=" + idCompanhia + ", nome=" + nome + ", lista_feedbacks=" + lista_feedbacks + ", lista_voos=" + lista_voos + '}';
    }

    
    
}
