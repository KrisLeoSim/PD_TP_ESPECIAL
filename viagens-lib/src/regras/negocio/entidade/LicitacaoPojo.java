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

public class LicitacaoPojo implements Serializable {

    private int idLicitacao;   
    private int valor;   
    private int data; 
    private String estado;
   
    //private LugarPojo idLugar;
  
    //private UtilizadorPojo idUtilizador;

    public LicitacaoPojo(int valor, int data, String estado) {
        this.valor = valor;
        this.data = data;
        this.estado = estado;
    }

    public int getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(int idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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
        return "LicitacaoPojo{" + "idLicitacao=" + idLicitacao + ", valor=" + valor + ", data=" + data + ", estado=" + estado + '}';
    }

   
    
}
