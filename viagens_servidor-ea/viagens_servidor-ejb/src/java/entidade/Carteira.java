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
@Table(name = "carteira")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carteira.findAll", query = "SELECT c FROM Carteira c")
    , @NamedQuery(name = "Carteira.findByIdCarteira", query = "SELECT c FROM Carteira c WHERE c.idCarteira = :idCarteira")
    , @NamedQuery(name = "Carteira.findByMontante", query = "SELECT c FROM Carteira c WHERE c.montante = :montante")})
public class Carteira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carteira")
    private Integer idCarteira;
    @Basic(optional = false)
    @Column(name = "montante")
    private double montante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarteira")
    private Collection<Movimentos> movimentosCollection;

    public Carteira() {
    }

    public Carteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Carteira(Integer idCarteira, double montante) {
        this.idCarteira = idCarteira;
        this.montante = montante;
    }

    public Integer getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    @XmlTransient
    public Collection<Movimentos> getMovimentosCollection() {
        return movimentosCollection;
    }

    public void setMovimentosCollection(Collection<Movimentos> movimentosCollection) {
        this.movimentosCollection = movimentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarteira != null ? idCarteira.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carteira)) {
            return false;
        }
        Carteira other = (Carteira) object;
        if ((this.idCarteira == null && other.idCarteira != null) || (this.idCarteira != null && !this.idCarteira.equals(other.idCarteira))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Carteira[ idCarteira=" + idCarteira + " ]";
    }
    
}
