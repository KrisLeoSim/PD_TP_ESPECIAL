/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

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
@Table(name = "utilizador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")
    , @NamedQuery(name = "Utilizador.findByIdUtilizador", query = "SELECT u FROM Utilizador u WHERE u.idUtilizador = :idUtilizador")
    , @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT u FROM Utilizador u WHERE u.username = :username")
    , @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT u FROM Utilizador u WHERE u.password = :password")
    , @NamedQuery(name = "Utilizador.findByPrimeiroNome", query = "SELECT u FROM Utilizador u WHERE u.primeiroNome = :primeiroNome")
    , @NamedQuery(name = "Utilizador.findByUltimoNome", query = "SELECT u FROM Utilizador u WHERE u.ultimoNome = :ultimoNome")
    , @NamedQuery(name = "Utilizador.findByNif", query = "SELECT u FROM Utilizador u WHERE u.nif = :nif")
    , @NamedQuery(name = "Utilizador.findByCc", query = "SELECT u FROM Utilizador u WHERE u.cc = :cc")
    , @NamedQuery(name = "Utilizador.findByPassaporte", query = "SELECT u FROM Utilizador u WHERE u.passaporte = :passaporte")
    , @NamedQuery(name = "Utilizador.findByNacionalidade", query = "SELECT u FROM Utilizador u WHERE u.nacionalidade = :nacionalidade")
    , @NamedQuery(name = "Utilizador.findByDataNascimento", query = "SELECT u FROM Utilizador u WHERE u.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Utilizador.findByRua", query = "SELECT u FROM Utilizador u WHERE u.rua = :rua")
    , @NamedQuery(name = "Utilizador.findByNPorta", query = "SELECT u FROM Utilizador u WHERE u.nPorta = :nPorta")
    , @NamedQuery(name = "Utilizador.findByCodigoPostal", query = "SELECT u FROM Utilizador u WHERE u.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Utilizador.findByLocalidade", query = "SELECT u FROM Utilizador u WHERE u.localidade = :localidade")
    , @NamedQuery(name = "Utilizador.findByDistrito", query = "SELECT u FROM Utilizador u WHERE u.distrito = :distrito")
    , @NamedQuery(name = "Utilizador.findByPais", query = "SELECT u FROM Utilizador u WHERE u.pais = :pais")
    , @NamedQuery(name = "Utilizador.findByTipoUser", query = "SELECT u FROM Utilizador u WHERE u.tipoUser = :tipoUser")
    , @NamedQuery(name = "Utilizador.findByEstado", query = "SELECT u FROM Utilizador u WHERE u.estado = :estado")
    , @NamedQuery(name = "Utilizador.findByDataUltimoLogin", query = "SELECT u FROM Utilizador u WHERE u.dataUltimoLogin = :dataUltimoLogin")})
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilizador")
    private Integer idUtilizador;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Column(name = "ultimo_nome")
    private String ultimoNome;
    @Column(name = "nif")
    private String nif;
    @Column(name = "cc")
    private String cc;
    @Column(name = "passaporte")
    private String passaporte;
    @Column(name = "nacionalidade")
    private String nacionalidade;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "rua")
    private String rua;
    @Column(name = "n_porta")
    private String nPorta;
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "distrito")
    private String distrito;
    @Column(name = "pais")
    private String pais;
    @Column(name = "tipo_user")
    private String tipoUser;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "data_ultimo_login")
    private Integer dataUltimoLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Compra> compraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Licitacao> licitacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<ItemCarrinho> itemCarrinhoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Carteira> carteiraCollection;

    public Utilizador() {
    }

    public Utilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNPorta() {
        return nPorta;
    }

    public void setNPorta(String nPorta) {
        this.nPorta = nPorta;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public void setDataUltimoLogin(Integer dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
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

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<Carteira> getCarteiraCollection() {
        return carteiraCollection;
    }

    public void setCarteiraCollection(Collection<Carteira> carteiraCollection) {
        this.carteiraCollection = carteiraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.idUtilizador == null && other.idUtilizador != null) || (this.idUtilizador != null && !this.idUtilizador.equals(other.idUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.Utilizador[ idUtilizador=" + idUtilizador + " ]";
    }
    
}
