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
@Table(name = "destinos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinos.findAll", query = "SELECT d FROM Destinos d")
    , @NamedQuery(name = "Destinos.findByIdDestino", query = "SELECT d FROM Destinos d WHERE d.idDestino = :idDestino")
    , @NamedQuery(name = "Destinos.findByPais", query = "SELECT d FROM Destinos d WHERE d.pais = :pais")
    , @NamedQuery(name = "Destinos.findByCidade", query = "SELECT d FROM Destinos d WHERE d.cidade = :cidade")
    , @NamedQuery(name = "Destinos.findByDescricaoDestino", query = "SELECT d FROM Destinos d WHERE d.descricaoDestino = :descricaoDestino")
    , @NamedQuery(name = "Destinos.findByMediaDestino", query = "SELECT d FROM Destinos d WHERE d.mediaDestino = :mediaDestino")})
public class Destinos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_destino")
    private Integer idDestino;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "descricao_destino")
    private String descricaoDestino;
    @Basic(optional = false)
    @Column(name = "media_destino")
    private long mediaDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDestino")
    private Collection<Voo> vooCollection;

    public Destinos() {
    }

    public Destinos(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public Destinos(Integer idDestino, String pais, String cidade, String descricaoDestino, long mediaDestino) {
        this.idDestino = idDestino;
        this.pais = pais;
        this.cidade = cidade;
        this.descricaoDestino = descricaoDestino;
        this.mediaDestino = mediaDestino;
    }

    public Integer getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricaoDestino() {
        return descricaoDestino;
    }

    public void setDescricaoDestino(String descricaoDestino) {
        this.descricaoDestino = descricaoDestino;
    }

    public long getMediaDestino() {
        return mediaDestino;
    }

    public void setMediaDestino(long mediaDestino) {
        this.mediaDestino = mediaDestino;
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
        hash += (idDestino != null ? idDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinos)) {
            return false;
        }
        Destinos other = (Destinos) object;
        if ((this.idDestino == null && other.idDestino != null) || (this.idDestino != null && !this.idDestino.equals(other.idDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Destinos[ idDestino=" + idDestino + " ]";
    }
    
}
