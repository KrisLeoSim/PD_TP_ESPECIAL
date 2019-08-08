/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

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
@Table(name = "chegada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chegada.findAll", query = "SELECT c FROM Chegada c")
    , @NamedQuery(name = "Chegada.findByIdChegada", query = "SELECT c FROM Chegada c WHERE c.idChegada = :idChegada")
    , @NamedQuery(name = "Chegada.findByDataChegada", query = "SELECT c FROM Chegada c WHERE c.dataChegada = :dataChegada")})
public class Chegada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_chegada")
    private Integer idChegada;
    @Column(name = "data_chegada")
    private Integer dataChegada;
    @JoinColumn(name = "id_local", referencedColumnName = "id_local")
    @ManyToOne(optional = false)
    private Local idLocal;
    @JoinColumn(name = "id_voo", referencedColumnName = "id_voo")
    @ManyToOne(optional = false)
    private Voo idVoo;

    public Chegada() {
    }

    public Chegada(Integer idChegada) {
        this.idChegada = idChegada;
    }

    public Integer getIdChegada() {
        return idChegada;
    }

    public void setIdChegada(Integer idChegada) {
        this.idChegada = idChegada;
    }

    public Integer getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Integer dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
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
        hash += (idChegada != null ? idChegada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chegada)) {
            return false;
        }
        Chegada other = (Chegada) object;
        if ((this.idChegada == null && other.idChegada != null) || (this.idChegada != null && !this.idChegada.equals(other.idChegada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Chegada[ idChegada=" + idChegada + " ]";
    }
    
}
