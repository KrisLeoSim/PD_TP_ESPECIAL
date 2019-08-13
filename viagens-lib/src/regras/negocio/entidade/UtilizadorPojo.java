/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author sergio
 */

public class UtilizadorPojo implements Serializable {

    
    private int idUtilizador;
    
    private String username;
    
    private String password;
    
    private String primeiroNome;
   
    private String ultimoNome;
   
    private String nif;
    
    private String cc;
    
    private String passaporte;
    
    private String nacionalidade;
    
    private Date dataNascimento;
    
    private String rua;
    
    private String nPorta;
    
    private String codigoPostal;
    
    private String localidade;
    
    private String distrito;
    
    private String pais;
    
    private String tipoUser;
    
    private int estado;
    
    private int dataUltimoLogin;
    
    private ArrayList<CompraPojo> lista_compras;
    
    private ArrayList<LicitacaoPojo> lista_licitacoes;
    
    private ArrayList<ItemCarrinhoPojo> lista_itemsCarrinho;
    
    private ArrayList<FeedbackPojo> lista_feedbacks;
    
    private ArrayList<CarteiraPojo> lista_carteiras;

    //precisa de ter variaveis a serem passadas obrigatoriamente? hummm
    //pensar melhor se é necessario indicar parametros no constructor

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getnPorta() {
        return nPorta;
    }

    public void setnPorta(String nPorta) {
        this.nPorta = nPorta;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public void setDataUltimoLogin(int dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
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

    public ArrayList<FeedbackPojo> getLista_feedbacks() {
        return lista_feedbacks;
    }

    public void setLista_feedbacks(ArrayList<FeedbackPojo> lista_feedbacks) {
        this.lista_feedbacks = lista_feedbacks;
    }

    public ArrayList<CarteiraPojo> getLista_carteiras() {
        return lista_carteiras;
    }

    public void setLista_carteiras(ArrayList<CarteiraPojo> lista_carteiras) {
        this.lista_carteiras = lista_carteiras;
    }

    @Override
    public String toString() {
        return "UtilizadorPojo{" + "idUtilizador=" + idUtilizador + ", username=" + username + ", password=" + password + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + ", nif=" + nif + ", cc=" + cc + ", passaporte=" + passaporte + ", nacionalidade=" + nacionalidade + ", dataNascimento=" + dataNascimento + ", rua=" + rua + ", nPorta=" + nPorta + ", codigoPostal=" + codigoPostal + ", localidade=" + localidade + ", distrito=" + distrito + ", pais=" + pais + ", tipoUser=" + tipoUser + ", estado=" + estado + ", dataUltimoLogin=" + dataUltimoLogin + ", lista_compras=" + lista_compras + ", lista_licitacoes=" + lista_licitacoes + ", lista_itemsCarrinho=" + lista_itemsCarrinho + ", lista_feedbacks=" + lista_feedbacks + ", lista_carteiras=" + lista_carteiras + '}';
    }
    
    
}
