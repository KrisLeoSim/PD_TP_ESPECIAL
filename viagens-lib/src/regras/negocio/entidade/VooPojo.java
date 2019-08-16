/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.negocio.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author sergio
 */

public class VooPojo implements Serializable {

    private int idVoo;
    private int lugaresMaximo;
    private int lugaresDisponiveis;
    private int duracaoVoo;
    private ArrayList<LugarPojo> lista_lugars;
    private ArrayList<PartidaPojo> lista_partidas;   
    private ArrayList<ChegadaPojo> lista_chegadas;    
    private AgenciaPojo idAgencia;
    private CompanhiaPojo idCompanhia;

    public VooPojo(int lugaresMaximo, int lugaresDisponiveis, int duracaoVoo) {
        this.lugaresMaximo = lugaresMaximo;
        this.lugaresDisponiveis = lugaresDisponiveis;
        this.duracaoVoo = duracaoVoo;
    }

    public VooPojo() {
        
    }

    public int getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public int getLugaresMaximo() {
        return lugaresMaximo;
    }

    public void setLugaresMaximo(int lugaresMaximo) {
        this.lugaresMaximo = lugaresMaximo;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    public void setLugaresDisponiveis(int lugaresDisponiveis) {
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public int getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(int duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public ArrayList<LugarPojo> getLista_lugars() {
        return lista_lugars;
    }

    public void setLista_lugars(ArrayList<LugarPojo> lista_lugars) {
        this.lista_lugars = lista_lugars;
    }

    public ArrayList<PartidaPojo> getLista_partidas() {
        return lista_partidas;
    }

    public void setLista_partidas(ArrayList<PartidaPojo> lista_partidas) {
        this.lista_partidas = lista_partidas;
    }

    public ArrayList<ChegadaPojo> getLista_chegadas() {
        return lista_chegadas;
    }

    public void setLista_chegadas(ArrayList<ChegadaPojo> lista_chegadas) {
        this.lista_chegadas = lista_chegadas;
    }

    public AgenciaPojo getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(AgenciaPojo idAgencia) {
        this.idAgencia = idAgencia;
    }

    public CompanhiaPojo getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(CompanhiaPojo idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    @Override
    public String toString() {
        return "VooPojo{" + "idVoo=" + idVoo + ", lugaresMaximo=" + lugaresMaximo + ", lugaresDisponiveis=" + lugaresDisponiveis + ", duracaoVoo=" + duracaoVoo + ", lista_lugars=" + lista_lugars + ", lista_partidas=" + lista_partidas + ", lista_chegadas=" + lista_chegadas + '}';
    }

    
    
}
