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

public class AgenciaPojo implements Serializable {

    private int idAgencia;
    private String nome;
    private ArrayList<VooPojo> voos;

    public AgenciaPojo(String nome) {
        this.nome = nome;
        
    }

    

    public AgenciaPojo(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public AgenciaPojo() {
       
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<VooPojo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<VooPojo> voos) {
        this.voos = voos;
    }


    @Override
    public String toString() {
        return "entidade.Agencia[ idAgencia=" + idAgencia + " ]";
    }
    
}
