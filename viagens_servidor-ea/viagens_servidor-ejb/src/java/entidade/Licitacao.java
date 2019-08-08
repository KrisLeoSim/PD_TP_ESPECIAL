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
@Table(name = "licitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licitacao.findAll", query = "SELECT l FROM Licitacao l")
    , @NamedQuery(name = "Licitacao.findByIdLicitacao", query = "SELECT l FROM Licitacao l WHERE l.idLicitacao = :idLicitacao")
    , @NamedQuery(name = "Licitacao.findByValor", query = "SELECT l FROM Licitacao l WHERE l.valor = :valor")
    , @NamedQuery(name = "Licitacao.findByData", query = "SELECT l FROM Licitacao l WHERE l.data = :data")
    , @NamedQuery(name = "Licitacao.findByEstado", query = "SELECT l FROM Licitacao l WHERE l.estado = :estado")})
public class Licitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licitacao")
    private Integer idLicitacao;
    @Column(name = "valor")
    private BigInteger valor;
    @Column(name = "data")
    private Integer data;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_lugar", referencedColumnName = "id_lugar")
    @ManyToOne(optional = false)
    private Lugar idLugar;
    @JoinColumn(name = "id_utilizador", referencedColumnName = "id_utilizador")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public Licitacao() {
    }

    public Licitacao(Integer idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public Integer getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(Integer idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
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
        hash += (idLicitacao != null ? idLicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licitacao)) {
            return false;
        }
        Licitacao other = (Licitacao) object;
        if ((this.idLicitacao == null && other.idLicitacao != null) || (this.idLicitacao != null && !this.idLicitacao.equals(other.idLicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Licitacao[ idLicitacao=" + idLicitacao + " ]";
    }
    
}
