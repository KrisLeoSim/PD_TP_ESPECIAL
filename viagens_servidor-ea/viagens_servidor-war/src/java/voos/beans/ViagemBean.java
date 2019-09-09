/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voos.beans;

import entidade.Chegada;
import entidade.Partida;
import entidade.Voo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import persistencia.VooFacadeLocal;
import persistencia.PartidaFacadeLocal;

@Named
@SessionScoped
public class ViagemBean implements Serializable{
    
    @EJB
    private VooFacadeLocal vooFacade;
    private PartidaFacadeLocal partidaFacade;
    
    public List<Voo> listaVoo(){
        
        //FacesContext context = FacesContext.getCurrentInstance();
        return vooFacade.getAllVoos();
    }
    
    public String getPartidaByVooID(Collection<Partida> partidaCollection) {
        if (partidaCollection.iterator().hasNext()){
            return partidaCollection.iterator().next().getDataPartida().toString();
        }
        else{
            return "...";
        }
    }
    
        public String getChegadaByVooID(Collection<Chegada> chegadaCollection) {
        if (chegadaCollection.iterator().hasNext()){
            return chegadaCollection.iterator().next().getDataChegada().toString();
        }
        else{
            return "...";
        }
    }


    
    
}
