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
@Table(name = "voo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voo.findAll", query = "SELECT v FROM Voo v")
    , @NamedQuery(name = "Voo.findByIdVoo", query = "SELECT v FROM Voo v WHERE v.idVoo = :idVoo")
    , @NamedQuery(name = "Voo.findByLugaresMaximo", query = "SELECT v FROM Voo v WHERE v.lugaresMaximo = :lugaresMaximo")
    , @NamedQuery(name = "Voo.findByLugaresDisponiveis", query = "SELECT v FROM Voo v WHERE v.lugaresDisponiveis = :lugaresDisponiveis")
    , @NamedQuery(name = "Voo.findByDuracaoVoo", query = "SELECT v FROM Voo v WHERE v.duracaoVoo = :duracaoVoo")})
public class Voo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_voo")
    private Integer idVoo;
    @Column(name = "lugares_maximo")
    private Integer lugaresMaximo;
    @Column(name = "lugares_disponiveis")
    private Integer lugaresDisponiveis;
    @Column(name = "duracao_voo")
    private Integer duracaoVoo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Lugar> lugarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Partida> partidaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVoo")
    private Collection<Chegada> chegadaCollection;
    @JoinColumn(name = "id_agencia", referencedColumnName = "id_agencia")
    @ManyToOne(optional = false)
    private Agencia idAgencia;
    @JoinColumn(name = "id_companhia", referencedColumnName = "id_companhia")
    @ManyToOne(optional = false)
    private Companhia idCompanhia;

    public Voo() {
    }

    public Voo(Integer idVoo) {
        this.idVoo = idVoo;
    }

    public Integer getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(Integer idVoo) {
        this.idVoo = idVoo;
    }

    public Integer getLugaresMaximo() {
        return lugaresMaximo;
    }

    public void setLugaresMaximo(Integer lugaresMaximo) {
        this.lugaresMaximo = lugaresMaximo;
    }

    public Integer getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }

    public void setLugaresDisponiveis(Integer lugaresDisponiveis) {
        this.lugaresDisponiveis = lugaresDisponiveis;
    }

    public Integer getDuracaoVoo() {
        return duracaoVoo;
    }

    public void setDuracaoVoo(Integer duracaoVoo) {
        this.duracaoVoo = duracaoVoo;
    }

    @XmlTransient
    public Collection<Lugar> getLugarCollection() {
        return lugarCollection;
    }

    public void setLugarCollection(Collection<Lugar> lugarCollection) {
        this.lugarCollection = lugarCollection;
    }

    @XmlTransient
    public Collection<Partida> getPartidaCollection() {
        return partidaCollection;
    }

    public void setPartidaCollection(Collection<Partida> partidaCollection) {
        this.partidaCollection = partidaCollection;
    }

    @XmlTransient
    public Collection<Chegada> getChegadaCollection() {
        return chegadaCollection;
    }

    public void setChegadaCollection(Collection<Chegada> chegadaCollection) {
        this.chegadaCollection = chegadaCollection;
    }

    public Agencia getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Agencia idAgencia) {
        this.idAgencia = idAgencia;
    }

    public Companhia getIdCompanhia() {
        return idCompanhia;
    }

    public void setIdCompanhia(Companhia idCompanhia) {
        this.idCompanhia = idCompanhia;
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
        return "entidade.Voo[ idVoo=" + idVoo + " ]";
    }
    
}
