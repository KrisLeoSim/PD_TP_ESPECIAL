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
@Table(name = "lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugar.findAll", query = "SELECT l FROM Lugar l")
    , @NamedQuery(name = "Lugar.findByIdLugar", query = "SELECT l FROM Lugar l WHERE l.idLugar = :idLugar")
    , @NamedQuery(name = "Lugar.findByTipo", query = "SELECT l FROM Lugar l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Lugar.findByEstado", query = "SELECT l FROM Lugar l WHERE l.estado = :estado")
    , @NamedQuery(name = "Lugar.findByPrecoCompra", query = "SELECT l FROM Lugar l WHERE l.precoCompra = :precoCompra")})
public class Lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lugar")
    private Integer idLugar;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "estado")
    private String estado;
    @Column(name = "preco_compra")
    private BigInteger precoCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugar")
    private Collection<Compra> compraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugar")
    private Collection<Licitacao> licitacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugar")
    private Collection<ItemCarrinho> itemCarrinhoCollection;
    @JoinColumn(name = "id_voo", referencedColumnName = "id_voo")
    @ManyToOne(optional = false)
    private Voo idVoo;

    public Lugar() {
    }

    public Lugar(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public Integer getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigInteger precoCompra) {
        this.precoCompra = precoCompra;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<Licitacao> getLicitacaoCollection() {
        return licitacaoCollection;
    }

    public void setLicitacaoCollection(Collection<Licitacao> licitacaoCollection) {
        this.licitacaoCollection = licitacaoCollection;
    }

    @XmlTransient
    public Collection<ItemCarrinho> getItemCarrinhoCollection() {
        return itemCarrinhoCollection;
    }

    public void setItemCarrinhoCollection(Collection<ItemCarrinho> itemCarrinhoCollection) {
        this.itemCarrinhoCollection = itemCarrinhoCollection;
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
        hash += (idLugar != null ? idLugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugar)) {
            return false;
        }
        Lugar other = (Lugar) object;
        if ((this.idLugar == null && other.idLugar != null) || (this.idLugar != null && !this.idLugar.equals(other.idLugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Lugar[ idLugar=" + idLugar + " ]";
    }
    
}
