/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.entidade;

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
@Table(name = "licitacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licitacoes.findAll", query = "SELECT l FROM Licitacoes l")
    , @NamedQuery(name = "Licitacoes.findByIdLicitacao", query = "SELECT l FROM Licitacoes l WHERE l.idLicitacao = :idLicitacao")
    , @NamedQuery(name = "Licitacoes.findByValor", query = "SELECT l FROM Licitacoes l WHERE l.valor = :valor")
    , @NamedQuery(name = "Licitacoes.findByData", query = "SELECT l FROM Licitacoes l WHERE l.data = :data")
    , @NamedQuery(name = "Licitacoes.findByHora", query = "SELECT l FROM Licitacoes l WHERE l.hora = :hora")
    , @NamedQuery(name = "Licitacoes.findByEstadoLicitacao", query = "SELECT l FROM Licitacoes l WHERE l.estadoLicitacao = :estadoLicitacao")})
public class Licitacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_licitacao")
    private Integer idLicitacao;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora")
    private int hora;
    @Basic(optional = false)
    @Column(name = "estado_licitacao")
    private String estadoLicitacao;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_voo", referencedColumnName = "id_voo")
    @ManyToOne(optional = false)
    private Voo idVoo;

    public Licitacoes() {
    }

    public Licitacoes(Integer idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public Licitacoes(Integer idLicitacao, double valor, Date data, int hora, String estadoLicitacao) {
        this.idLicitacao = idLicitacao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.estadoLicitacao = estadoLicitacao;
    }

    public Integer getIdLicitacao() {
        return idLicitacao;
    }

    public void setIdLicitacao(Integer idLicitacao) {
        this.idLicitacao = idLicitacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getEstadoLicitacao() {
        return estadoLicitacao;
    }

    public void setEstadoLicitacao(String estadoLicitacao) {
        this.estadoLicitacao = estadoLicitacao;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        hash += (idLicitacao != null ? idLicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licitacoes)) {
            return false;
        }
        Licitacoes other = (Licitacoes) object;
        if ((this.idLicitacao == null && other.idLicitacao != null) || (this.idLicitacao != null && !this.idLicitacao.equals(other.idLicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.Licitacoes[ idLicitacao=" + idLicitacao + " ]";
    }
    
}
