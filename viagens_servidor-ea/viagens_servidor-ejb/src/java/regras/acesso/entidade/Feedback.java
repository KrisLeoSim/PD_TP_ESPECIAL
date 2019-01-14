/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByIdFeedback", query = "SELECT f FROM Feedback f WHERE f.idFeedback = :idFeedback")
    , @NamedQuery(name = "Feedback.findByClassificacaoCompanhia", query = "SELECT f FROM Feedback f WHERE f.classificacaoCompanhia = :classificacaoCompanhia")
    , @NamedQuery(name = "Feedback.findByClassificacaoDestinos", query = "SELECT f FROM Feedback f WHERE f.classificacaoDestinos = :classificacaoDestinos")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_feedback")
    private Integer idFeedback;
    @Basic(optional = false)
    @Column(name = "classificacao_companhia")
    private int classificacaoCompanhia;
    @Basic(optional = false)
    @Column(name = "classificacao_destinos")
    private int classificacaoDestinos;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_voo", referencedColumnName = "id_voo")
    @ManyToOne(optional = false)
    private Voo idVoo;

    public Feedback() {
    }

    public Feedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Feedback(Integer idFeedback, int classificacaoCompanhia, int classificacaoDestinos) {
        this.idFeedback = idFeedback;
        this.classificacaoCompanhia = classificacaoCompanhia;
        this.classificacaoDestinos = classificacaoDestinos;
    }

    public Integer getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }

    public int getClassificacaoCompanhia() {
        return classificacaoCompanhia;
    }

    public void setClassificacaoCompanhia(int classificacaoCompanhia) {
        this.classificacaoCompanhia = classificacaoCompanhia;
    }

    public int getClassificacaoDestinos() {
        return classificacaoDestinos;
    }

    public void setClassificacaoDestinos(int classificacaoDestinos) {
        this.classificacaoDestinos = classificacaoDestinos;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Voo getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Voo idVoo) {
        this.idVoo = idVoo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeedback != null ? idFeedback.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.idFeedback == null && other.idFeedback != null) || (this.idFeedback != null && !this.idFeedback.equals(other.idFeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.Feedback[ idFeedback=" + idFeedback + " ]";
    }
    
}
