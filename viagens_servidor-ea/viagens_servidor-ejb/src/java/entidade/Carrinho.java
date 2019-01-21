/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "carrinho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c")
    , @NamedQuery(name = "Carrinho.findByIdCarrinho", query = "SELECT c FROM Carrinho c WHERE c.idCarrinho = :idCarrinho")
    , @NamedQuery(name = "Carrinho.findByIdUtilizador", query = "SELECT c FROM Carrinho c WHERE c.idUtilizador = :idUtilizador")
    , @NamedQuery(name = "Carrinho.findByValorTotal", query = "SELECT c FROM Carrinho c WHERE c.valorTotal = :valorTotal")
    , @NamedQuery(name = "Carrinho.findByNumeroLugares", query = "SELECT c FROM Carrinho c WHERE c.numeroLugares = :numeroLugares")
    , @NamedQuery(name = "Carrinho.findByDataCompra", query = "SELECT c FROM Carrinho c WHERE c.dataCompra = :dataCompra")
    , @NamedQuery(name = "Carrinho.findByEstadoCarrinho", query = "SELECT c FROM Carrinho c WHERE c.estadoCarrinho = :estadoCarrinho")
    , @NamedQuery(name = "Carrinho.findByTipoCompra", query = "SELECT c FROM Carrinho c WHERE c.tipoCompra = :tipoCompra")})
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrinho")
    private Integer idCarrinho;
    @Basic(optional = false)
    @Column(name = "id_utilizador")
    private int idUtilizador;
    @Basic(optional = false)
    @Column(name = "valor_total")
    private double valorTotal;
    @Basic(optional = false)
    @Column(name = "numero_lugares")
    private int numeroLugares;
    @Basic(optional = false)
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Basic(optional = false)
    @Column(name = "estado_carrinho")
    private String estadoCarrinho;
    @Basic(optional = false)
    @Column(name = "tipo_compra")
    private String tipoCompra;
    @JoinColumn(name = "id_voo", referencedColumnName = "id_voo")
    @ManyToOne(optional = false)
    private Voo idVoo;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Carrinho(Integer idCarrinho, int idUtilizador, double valorTotal, int numeroLugares, Date dataCompra, String estadoCarrinho, String tipoCompra) {
        this.idCarrinho = idCarrinho;
        this.idUtilizador = idUtilizador;
        this.valorTotal = valorTotal;
        this.numeroLugares = numeroLugares;
        this.dataCompra = dataCompra;
        this.estadoCarrinho = estadoCarrinho;
        this.tipoCompra = tipoCompra;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(int idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getNumeroLugares() {
        return numeroLugares;
    }

    public void setNumeroLugares(int numeroLugares) {
        this.numeroLugares = numeroLugares;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEstadoCarrinho() {
        return estadoCarrinho;
    }

    public void setEstadoCarrinho(String estadoCarrinho) {
        this.estadoCarrinho = estadoCarrinho;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
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
        hash += (idCarrinho != null ? idCarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.idCarrinho == null && other.idCarrinho != null) || (this.idCarrinho != null && !this.idCarrinho.equals(other.idCarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Carrinho[ idCarrinho=" + idCarrinho + " ]";
    }
    
}
