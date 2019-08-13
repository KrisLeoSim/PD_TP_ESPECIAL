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
public class FeedbackPojo implements Serializable {

    private int idFeedback;
    private int avaliacao;
   //( private CompanhiaPojo idCompanhia;
   // private LocalPojo idLocal;
    //private UtilizadorPojo idUtilizador;

    public FeedbackPojo(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "FeedbackPojo{" + "idFeedback=" + idFeedback + ", avaliacao=" + avaliacao + '}';
    }

    

}
