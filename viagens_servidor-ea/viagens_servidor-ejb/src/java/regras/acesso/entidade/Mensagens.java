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
@Table(name = "mensagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagens.findAll", query = "SELECT m FROM Mensagens m")
    , @NamedQuery(name = "Mensagens.findByIdMensagem", query = "SELECT m FROM Mensagens m WHERE m.idMensagem = :idMensagem")
    , @NamedQuery(name = "Mensagens.findByUsernameDestinatario", query = "SELECT m FROM Mensagens m WHERE m.usernameDestinatario = :usernameDestinatario")
    , @NamedQuery(name = "Mensagens.findByAssunto", query = "SELECT m FROM Mensagens m WHERE m.assunto = :assunto")
    , @NamedQuery(name = "Mensagens.findByMensagem", query = "SELECT m FROM Mensagens m WHERE m.mensagem = :mensagem")
    , @NamedQuery(name = "Mensagens.findByDataMensagem", query = "SELECT m FROM Mensagens m WHERE m.dataMensagem = :dataMensagem")
    , @NamedQuery(name = "Mensagens.findByHoraMensagem", query = "SELECT m FROM Mensagens m WHERE m.horaMensagem = :horaMensagem")})
public class Mensagens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mensagem")
    private Integer idMensagem;
    @Basic(optional = false)
    @Column(name = "username_destinatario")
    private String usernameDestinatario;
    @Basic(optional = false)
    @Column(name = "assunto")
    private String assunto;
    @Basic(optional = false)
    @Column(name = "mensagem")
    private String mensagem;
    @Basic(optional = false)
    @Column(name = "data_mensagem")
    @Temporal(TemporalType.DATE)
    private Date dataMensagem;
    @Basic(optional = false)
    @Column(name = "hora_mensagem")
    private int horaMensagem;
    @JoinColumn(name = "id_user_remetente", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUserRemetente;

    public Mensagens() {
    }

    public Mensagens(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Mensagens(Integer idMensagem, String usernameDestinatario, String assunto, String mensagem, Date dataMensagem, int horaMensagem) {
        this.idMensagem = idMensagem;
        this.usernameDestinatario = usernameDestinatario;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.dataMensagem = dataMensagem;
        this.horaMensagem = horaMensagem;
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getUsernameDestinatario() {
        return usernameDestinatario;
    }

    public void setUsernameDestinatario(String usernameDestinatario) {
        this.usernameDestinatario = usernameDestinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(Date dataMensagem) {
        this.dataMensagem = dataMensagem;
    }

    public int getHoraMensagem() {
        return horaMensagem;
    }

    public void setHoraMensagem(int horaMensagem) {
        this.horaMensagem = horaMensagem;
    }

    public User getIdUserRemetente() {
        return idUserRemetente;
    }

    public void setIdUserRemetente(User idUserRemetente) {
        this.idUserRemetente = idUserRemetente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensagem != null ? idMensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagens)) {
            return false;
        }
        Mensagens other = (Mensagens) object;
        if ((this.idMensagem == null && other.idMensagem != null) || (this.idMensagem != null && !this.idMensagem.equals(other.idMensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.Mensagens[ idMensagem=" + idMensagem + " ]";
    }
    
}
