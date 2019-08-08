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
@Table(name = "item_carrinho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCarrinho.findAll", query = "SELECT i FROM ItemCarrinho i")
    , @NamedQuery(name = "ItemCarrinho.findByIdItemCarrinho", query = "SELECT i FROM ItemCarrinho i WHERE i.idItemCarrinho = :idItemCarrinho")
    , @NamedQuery(name = "ItemCarrinho.findByIdCarrinho", query = "SELECT i FROM ItemCarrinho i WHERE i.idCarrinho = :idCarrinho")
    , @NamedQuery(name = "ItemCarrinho.findByValorLugar", query = "SELECT i FROM ItemCarrinho i WHERE i.valorLugar = :valorLugar")
    , @NamedQuery(name = "ItemCarrinho.findByDataAdicionado", query = "SELECT i FROM ItemCarrinho i WHERE i.dataAdicionado = :dataAdicionado")
    , @NamedQuery(name = "ItemCarrinho.findByEstado", query = "SELECT i FROM ItemCarrinho i WHERE i.estado = :estado")})
public class ItemCarrinho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_carrinho")
    private Integer idItemCarrinho;
    @Basic(optional = false)
    @Column(name = "id_carrinho")
    private int idCarrinho;
    @Column(name = "valor_lugar")
    private Integer valorLugar;
    @Column(name = "data_adicionado")
    private Integer dataAdicionado;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar")
    @ManyToOne(optional = false)
    private Lugar idLugar;
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id_utilizador")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public ItemCarrinho() {
    }

    public ItemCarrinho(Integer idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public ItemCarrinho(Integer idItemCarrinho, int idCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdItemCarrinho() {
        return idItemCarrinho;
    }

    public void setIdItemCarrinho(Integer idItemCarrinho) {
        this.idItemCarrinho = idItemCarrinho;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getValorLugar() {
        return valorLugar;
    }

    public void setValorLugar(Integer valorLugar) {
        this.valorLugar = valorLugar;
    }

    public Integer getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(Integer dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Lugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Lugar idLugar) {
        this.idLugar = idLugar;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemCarrinho != null ? idItemCarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCarrinho)) {
            return false;
        }
        ItemCarrinho other = (ItemCarrinho) object;
        if ((this.idItemCarrinho == null && other.idItemCarrinho != null) || (this.idItemCarrinho != null && !this.idItemCarrinho.equals(other.idItemCarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.ItemCarrinho[ idItemCarrinho=" + idItemCarrinho + " ]";
    }
    
}
