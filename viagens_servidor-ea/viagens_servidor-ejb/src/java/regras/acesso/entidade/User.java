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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByPrimeiroNome", query = "SELECT u FROM User u WHERE u.primeiroNome = :primeiroNome")
    , @NamedQuery(name = "User.findByUltimoNome", query = "SELECT u FROM User u WHERE u.ultimoNome = :ultimoNome")
    , @NamedQuery(name = "User.findByNif", query = "SELECT u FROM User u WHERE u.nif = :nif")
    , @NamedQuery(name = "User.findByMorada", query = "SELECT u FROM User u WHERE u.morada = :morada")
    , @NamedQuery(name = "User.findByTipoUser", query = "SELECT u FROM User u WHERE u.tipoUser = :tipoUser")
    , @NamedQuery(name = "User.findByEstado", query = "SELECT u FROM User u WHERE u.estado = :estado")
    , @NamedQuery(name = "User.findByDataUltimoLogin", query = "SELECT u FROM User u WHERE u.dataUltimoLogin = :dataUltimoLogin")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Basic(optional = false)
    @Column(name = "ultimo_nome")
    private String ultimoNome;
    @Basic(optional = false)
    @Column(name = "nif")
    private int nif;
    @Basic(optional = false)
    @Column(name = "morada")
    private String morada;
    @Basic(optional = false)
    @Column(name = "tipo_user")
    private String tipoUser;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @Column(name = "data_ultimo_login")
    @Temporal(TemporalType.DATE)
    private Date dataUltimoLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Movimentos> movimentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Carrinho> carrinhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserRemetente")
    private Collection<Mensagens> mensagensCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Licitacoes> licitacoesCollection;

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public User(Integer idUser, String username, String password, String primeiroNome, String ultimoNome, int nif, String morada, String tipoUser, int estado, Date dataUltimoLogin) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.nif = nif;
        this.morada = morada;
        this.tipoUser = tipoUser;
        this.estado = estado;
        this.dataUltimoLogin = dataUltimoLogin;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public void setDataUltimoLogin(Date dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Movimentos> getMovimentosCollection() {
        return movimentosCollection;
    }

    public void setMovimentosCollection(Collection<Movimentos> movimentosCollection) {
        this.movimentosCollection = movimentosCollection;
    }

    @XmlTransient
    public Collection<Carrinho> getCarrinhoCollection() {
        return carrinhoCollection;
    }

    public void setCarrinhoCollection(Collection<Carrinho> carrinhoCollection) {
        this.carrinhoCollection = carrinhoCollection;
    }

    @XmlTransient
    public Collection<Mensagens> getMensagensCollection() {
        return mensagensCollection;
    }

    public void setMensagensCollection(Collection<Mensagens> mensagensCollection) {
        this.mensagensCollection = mensagensCollection;
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
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "regras.acesso.entidade.User[ idUser=" + idUser + " ]";
    }
    
}
