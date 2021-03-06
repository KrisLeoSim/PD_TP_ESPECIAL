/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "companhia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companhia.findAll", query = "SELECT c FROM Companhia c")
    , @NamedQuery(name = "Companhia.findByIdCompanhia", query = "SELECT c FROM Companhia c WHERE c.idCompanhia = :idCompanhia")
    , @NamedQuery(name = "Companhia.findByNome", query = "SELECT c FROM Companhia c WHERE c.nome = :nome")})
public class Companhia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_companhia")
    private Integer idCompanhia;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompanhia")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompanhia")
    private Collection<Voo> vooCollection;

    public Companhia() {
    }

    public Companhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Integer getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Voo> getVooCollection() {
        return vooCollection;
    }

    public void setVooCollection(Collection<Voo> vooCollection) {
        this.vooCollection = vooCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompanhia != null ? idCompanhia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companhia)) {
            return false;
        }
        Companhia other = (Companhia) object;
        if ((this.idCompanhia == null && other.idCompanhia != null) || (this.idCompanhia != null && !this.idCompanhia.equals(other.idCompanhia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Companhia[ idCompanhia=" + idCompanhia + " ]";
    }
    
}
