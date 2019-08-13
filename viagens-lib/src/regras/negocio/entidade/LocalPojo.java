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

public class LocalPojo implements Serializable {
  
    private int idLocal;    
    private String pais;   
    private String cidade;   
    private String descricaoLocal;   
    private ArrayList<PartidaPojo> lista_partidas;    
    private ArrayList<FeedbackPojo> lista_feedbacks;   
    private ArrayList<ChegadaPojo> lista_chegadas;

    public LocalPojo(String pais, String cidade) {
        this.pais = pais;
        this.cidade = cidade;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public ArrayList<PartidaPojo> getLista_partidas() {
        return lista_partidas;
    }

    public void setLista_partidas(ArrayList<PartidaPojo> lista_partidas) {
        this.lista_partidas = lista_partidas;
    }

    public ArrayList<FeedbackPojo> getLista_feedbacks() {
        return lista_feedbacks;
    }

    public void setLista_feedbacks(ArrayList<FeedbackPojo> lista_feedbacks) {
        this.lista_feedbacks = lista_feedbacks;
    }

    public ArrayList<ChegadaPojo> getLista_chegadas() {
        return lista_chegadas;
    }

    public void setLista_chegadas(ArrayList<ChegadaPojo> lista_chegadas) {
        this.lista_chegadas = lista_chegadas;
    }

    @Override
    public String toString() {
        return "LocalPojo{" + "idLocal=" + idLocal + ", pais=" + pais + ", cidade=" + cidade + ", descricaoLocal=" + descricaoLocal + ", lista_partidas=" + lista_partidas + ", lista_feedbacks=" + lista_feedbacks + ", lista_chegadas=" + lista_chegadas + '}';
    }

    
}
