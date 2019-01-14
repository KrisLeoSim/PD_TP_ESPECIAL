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
@Table(name = "movimentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentos.findAll", query = "SELECT m FROM Movimentos m")
    , @NamedQuery(name = "Movimentos.findByIdMovimento", query = "SELECT m FROM Movimentos m WHERE m.idMovimento = :idMovimento")
    , @NamedQuery(name = "Movimentos.findByDescricaoMovimento", query = "SELECT m FROM Movimentos m WHERE m.descricaoMovimento = :descricaoMovimento")
    , @NamedQuery(name = "Movimentos.findByData", query = "SELECT m FROM Movimentos m WHERE m.data = :data")
    , @NamedQuery(name = "Movimentos.findByHora", query = "SELECT m FROM Movimentos m WHERE m.hora = :hora")})
public class Movimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movimento")
    private Integer idMovimento;
    @Basic(optional = false)
    @Column(name = "descricao_movimento")
    private String descricaoMovimento;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "hora")
    private int hora;
    @JoinColumn(name = "id_carteira", referencedColumnName = "id_carteira")
    @ManyToOne(optional = false)
    private Carteira idCarteira;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Movimentos() {
    }

    public Movimentos(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Movimentos(Integer idMovimento, String descricaoMovimento, Date data, int hora) {
        this.idMovimento = idMovimento;
        this.descricaoMovimento = descricaoMovimento;
        this.data = data;
        this.hora = hora;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public String getDescricaoMovimento() {
        return descricaoMovimento;
    }

    public void setDescricaoMovimento(String descricaoMovimento) {
        this.descricaoMovimento = descricaoMovimento;
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

    public Carteira getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(Carteira idCarteira) {
        this.idCarteira = idCarteira;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Movimentos)) {
            return false;
        }
        Movimentos other = (Movimentos) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.Movimentos[ idMovimento=" + idMovimento + " ]";
    }
    
}
