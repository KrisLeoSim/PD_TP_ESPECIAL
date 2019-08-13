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

public class ItemCarrinhoPojo implements Serializable {
    
    private int idItemCarrinho;   
    private int idCarrinho;   
    private int valorLugar;    
    private int dataAdicionado;    
    private String estado;
    
    //private LugarPojo idLugar;
   
    //private UtilizadorPojo idUtilizador;

    public ItemCarrinhoPojo(int valorLugar, int dataAdicionado, String estado) {
        this.valorLugar = valorLugar;
        this.dataAdicionado = dataAdicionado;
        this.estado = estado;
    }

    public int getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(int idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getValorLugar() {
        return valorLugar;
    }

    public void setValorLugar(int valorLugar) {
        this.valorLugar = valorLugar;
    }

    public int getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(int dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ItemCarrinhoPojo{" + "idItemCarrinho=" + idItemCarrinho + ", idCarrinho=" + idCarrinho + ", valorLugar=" + valorLugar + ", dataAdicionado=" + dataAdicionado + ", estado=" + estado + '}';
    }

    
    
}
