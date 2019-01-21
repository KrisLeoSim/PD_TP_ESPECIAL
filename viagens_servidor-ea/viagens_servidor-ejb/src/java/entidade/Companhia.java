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
    , @NamedQuery(name = "Companhia.findByNomeCompanhia", query = "SELECT c FROM Companhia c WHERE c.nomeCompanhia = :nomeCompanhia")
    , @NamedQuery(name = "Companhia.findByMediaCompanhia", query = "SELECT c FROM Companhia c WHERE c.mediaCompanhia = :mediaCompanhia")})
public class Companhia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_companhia")
    private Integer idCompanhia;
    @Basic(optional = false)
    @Column(name = "nome_companhia")
    private String nomeCompanhia;
    @Basic(optional = false)
    @Column(name = "media_companhia")
    private long mediaCompanhia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompanhia")
    private Collection<Voo> vooCollection;

    public Companhia() {
    }

    public Companhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Companhia(Integer idCompanhia, String nomeCompanhia, long mediaCompanhia) {
        this.idCompanhia = idCompanhia;
        this.nomeCompanhia = nomeCompanhia;
        this.mediaCompanhia = mediaCompanhia;
    }

    public Integer getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public String getNomeCompanhia() {
        return nomeCompanhia;
    }

    public void setNomeCompanhia(String nomeCompanhia) {
        this.nomeCompanhia = nomeCompanhia;
    }

    public long getMediaCompanhia() {
        return mediaCompanhia;
    }

    public void setMediaCompanhia(long mediaCompanhia) {
        this.mediaCompanhia = mediaCompanhia;
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
