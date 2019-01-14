/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regras.acesso.entidade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergio
 */
@Entity
@Table(name = "voo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voo.findAll", query = "SELECT v FROM Voo v")
    , @NamedQuery(name = "Voo.findByIdVoo", query = "SELECT v FROM Voo v WHERE v.idVoo = :idVoo")
    , @NamedQuery(name = "Voo.findByLugaresMaximo", query = "SELECT v FROM Voo v WHERE v.lugaresMaximo = :lugaresMaximo")
    , @NamedQuery(name = "Voo.findByLugaresDisponiveis", query = "SELECT v FROM Voo v WHERE v.lugaresDisponiveis = :lugaresDisponiveis")
    , @NamedQuery(name = "Voo.findByPrecoBilhete", query = "SELECT v FROM Voo v WHERE v.precoBilhete = :precoBilhete")
    , @NamedQuery(name = "Voo.findByDataPartida", query = "SELECT v FROM Voo v WHERE v.dataPartida = :dataPartida")
    , @NamedQuery(name = "Voo.findByHoraPartida", query = "SELECT v FROM Voo v WHERE v.horaPartida = :horaPartida")
    , @NamedQuery(name = "Voo.findByDuracaoVoo", query = "SELECT v FROM Voo v WHERE v.duracaoVoo = :duracaoVoo")
    , @NamedQuery(name = "Voo.findByMaiorLicitacao", query = "SELECT v FROM Voo v WHERE v.maiorLicitacao = :maiorLicitacao")})
public class Voo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voo")
    private Integer idVoo;
    @Basic(optional = false)
    @Column(name = "lugares_maximo")
    private int lugaresMaximo;
    @Basic(optional = false)
    @Column(name = "lugares_disponiveis")
    private int lugaresDisponiveis;
    @Basic(optional = false)
    @Column(name = "preco_bilhete")
    private double precoBilhete;
    @Basic(optional = false)
    @Column(name = "data_partida")
    @Temporal(TemporalType.DATE)
    private Date dataPartida;
    @Basic(optional = false)
    @Column(name = "hora_partida")
    private int horaPartida;
    @Basic(optional = false)
    @Column(name = "duracao_voo")
    private int duracaoVoo;
    @Basic(optional = false)
    @Column(name = "maior_licitacao")
    private double maiorLicitacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "id_companhia", referencedColumnName = "id_companhia")
    @ManyToOne(optional = false)
    private Companhia idCompanhia;
    @JoinColumn(name = "id_destino", referencedColumnName = "id_destino")
    @ManyToOne(optional = false)
    private Destinos idDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Carrinho> carrinhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Licitacoes> licitacoesCollection;

    public Voo() {
    }

    public Voo(Integer idVoo) {
        this.idVoo = idVoo;
    }

    public Voo(Integer idVoo, int lugaresMaximo, int lugaresDisponiveis, double precoBilhete, Date dataPartida, int horaPartida, int duracaoVoo, double maiorLicitacao) {
        this.idVoo = idVoo;
        this.lugaresMaximo = lugaresMaximo;
        this.lugaresDisponiveis = lugaresDisponiveis;
        this.precoBilhete = precoBilhete;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
        this.duracaoVoo = duracaoVoo;
        this.maiorLicitacao = maiorLicitacao;
    }

    public Integer getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Integer idVoo) {
        this.idVoo = idVoo;
    }

    public int getLugaresMaximo() {
        return lugaresMaximo;
    }

    public void setLugaresMaximo(int lugaresMaximo) {
        this.lugaresMaximo = lugaresMaximo;
    }

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    public void setLugaresDisponiveis(int lugaresDisponiveis) {
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public double getPrecoBilhete() {
        return precoBilhete;
    }

    public void setPrecoBilhete(double precoBilhete) {
        this.precoBilhete = precoBilhete;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public int getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(int horaPartida) {
        this.horaPartida = horaPartida;
    }

    public int getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(int duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    public double getMaiorLicitacao() {
        return maiorLicitacao;
    }

    public void setMaiorLicitacao(double maiorLicitacao) {
        this.maiorLicitacao = maiorLicitacao;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public Companhia getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(Companhia idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Destinos getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Destinos idDestino) {
        this.idDestino = idDestino;
    }

    @XmlTransient
    public Collection<Carrinho> getCarrinhoCollection() {
        return carrinhoCollection;
    }

    public void setCarrinhoCollection(Collection<Carrinho> carrinhoCollection) {
        this.carrinhoCollection = carrinhoCollection;
    }

    @XmlTransient
    public Collection<Licitacoes> getLicitacoesCollection() {
        return licitacoesCollection;
    }

    public void setLicitacoesCollection(Collection<Licitacoes> licitacoesCollection) {
        this.licitacoesCollection = licitacoesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoo != null ? idVoo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voo)) {
            return false;
        }
        Voo other = (Voo) object;
        if ((this.idVoo == null && other.idVoo != null) || (this.idVoo != null && !this.idVoo.equals(other.idVoo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.Voo[ idVoo=" + idVoo + " ]";
    }
    
}
