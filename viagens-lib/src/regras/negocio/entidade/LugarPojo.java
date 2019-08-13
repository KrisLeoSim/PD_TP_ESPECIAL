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

public class LugarPojo implements Serializable {

    
    private int idLugar;
    
    private String tipo;
    
    private String estado;
    
    private int precoCompra;
    
    private ArrayList<CompraPojo> lista_compras;
    
    private ArrayList<LicitacaoPojo> lista_licitacoes;
    
    private ArrayList<ItemCarrinhoPojo> lista_itemsCarrinho;
    
    //private VooPojo idVoo;

    public LugarPojo(String tipo, String estado, int precoCompra) {
        this.tipo = tipo;
        this.estado = estado;
        this.precoCompra = precoCompra;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(int precoCompra) {
        this.precoCompra = precoCompra;
    }

    public ArrayList<CompraPojo> getLista_compras() {
        return lista_compras;
    }

    public void setLista_compras(ArrayList<CompraPojo> lista_compras) {
        this.lista_compras = lista_compras;
    }

    public ArrayList<LicitacaoPojo> getLista_licitacoes() {
        return lista_licitacoes;
    }

    public void setLista_licitacoes(ArrayList<LicitacaoPojo> lista_licitacoes) {
        this.lista_licitacoes = lista_licitacoes;
    }

    public ArrayList<ItemCarrinhoPojo> getLista_itemsCarrinho() {
        return lista_itemsCarrinho;
    }

    public void setLista_itemsCarrinho(ArrayList<ItemCarrinhoPojo> lista_itemsCarrinho) {
        this.lista_itemsCarrinho = lista_itemsCarrinho;
    }

    @Override
    public String toString() {
        return "LugarPojo{" + "idLugar=" + idLugar + ", tipo=" + tipo + ", estado=" + estado + ", precoCompra=" + precoCompra + ", lista_compras=" + lista_compras + ", lista_licitacoes=" + lista_licitacoes + ", lista_itemsCarrinho=" + lista_itemsCarrinho + '}';
    }

    
    
}
