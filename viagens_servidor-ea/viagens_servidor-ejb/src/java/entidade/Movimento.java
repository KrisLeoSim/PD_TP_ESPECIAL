/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m")
    , @NamedQuery(name = "Movimento.findByIdMovimento", query = "SELECT m FROM Movimento m WHERE m.idMovimento = :idMovimento")
    , @NamedQuery(name = "Movimento.findByValor", query = "SELECT m FROM Movimento m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimento.findByTipoMovimento", query = "SELECT m FROM Movimento m WHERE m.tipoMovimento = :tipoMovimento")
    , @NamedQuery(name = "Movimento.findByDescricaoMovimento", query = "SELECT m FROM Movimento m WHERE m.descricaoMovimento = :descricaoMovimento")
    , @NamedQuery(name = "Movimento.findByData", query = "SELECT m FROM Movimento m WHERE m.data = :data")
    , @NamedQuery(name = "Movimento.findByEstado", query = "SELECT m FROM Movimento m WHERE m.estado = :estado")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimento")
    private Integer idMovimento;
    @Column(name = "valor")
    private BigInteger valor;
    @Column(name = "tipo_movimento")
    private String tipoMovimento;
    @Column(name = "descricao_movimento")
    private String descricaoMovimento;
    @Column(name = "data")
    private Integer data;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_carteira", referencedColumnName = "id_carteira")
    @ManyToOne(optional = false)
    private Carteira idCarteira;

    public Movimento() {
    }

    public Movimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getDescricaoMovimento() {
        return descricaoMovimento;
    }

    public void setDescricaoMovimento(String descricaoMovimento) {
        this.descricaoMovimento = descricaoMovimento;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carteira getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Carteira idCarteira) {
        this.idCarteira = idCarteira;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimento != null ? idMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Movimento[ idMovimento=" + idMovimento + " ]";
    }
    
}
