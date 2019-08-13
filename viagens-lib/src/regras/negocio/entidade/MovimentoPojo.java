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

public class MovimentoPojo implements Serializable {
   
    private int idMovimento;    
    private int valor;   
    private String tipoMovimento;   
    private String descricaoMovimento;    
    private int data;
    private String estado;
    
    //private CarteiraPojo idCarteira;

    public MovimentoPojo(int valor, String tipoMovimento, int data, String estado) {
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
        this.data = data;
        this.estado = estado;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getDescricaoMovimento() {
        return descricaoMovimento;
    }

    public void setDescricaoMovimento(String descricaoMovimento) {
        this.descricaoMovimento = descricaoMovimento;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MovimentoPojo{" + "idMovimento=" + idMovimento + ", valor=" + valor + ", tipoMovimento=" + tipoMovimento + ", descricaoMovimento=" + descricaoMovimento + ", data=" + data + ", estado=" + estado + '}';
    }

    
    
}
