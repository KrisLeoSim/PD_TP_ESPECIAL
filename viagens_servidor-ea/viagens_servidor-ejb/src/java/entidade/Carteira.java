/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @Column(name = "montante")
    private BigInteger montante;
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id_utilizador")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarteira")
    private Collection<Movimento> movimentoCollection;

    public Carteira() {
    }

    public Carteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Integer getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public BigInteger getMontante() {
        return montante;
    }

    public void setMontante(BigInteger montante) {
        this.montante = montante;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @XmlTransient
    public Collection<Movimento> getMovimentoCollection() {
        return movimentoCollection;
    }

    public void setMovimentoCollection(Collection<Movimento> movimentoCollection) {
        this.movimentoCollection = movimentoCollection;
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
