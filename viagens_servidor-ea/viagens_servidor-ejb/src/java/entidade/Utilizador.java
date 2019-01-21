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
    , @NamedQuery(name = "Utilizador.findByMorada", query = "SELECT u FROM Utilizador u WHERE u.morada = :morada")
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

    public Utilizador() {
    }

    public Utilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Utilizador(Integer idUtilizador, String username, String password, String primeiroNome, String ultimoNome, int nif, String morada, String tipoUser, int estado, Date dataUltimoLogin) {
        this.idUtilizador = idUtilizador;
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
