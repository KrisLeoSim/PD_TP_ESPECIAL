/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voos.beans;



import com.sun.java.swing.plaf.windows.resources.windows;
import javax.inject.Named;
import javax.ejb.EJB;
import persistencia.UtilizadorFacadeLocal;
import entidade.Utilizador;
import static java.awt.SystemColor.window;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;


@Named
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private UtilizadorFacadeLocal utilizadorFacade;
    private Utilizador userLogado = new Utilizador();
    
    private Boolean logado = false;
    private String username;
    private String password;
    private String nameLogedUserIndex = "Entrar";
    private String nameLogedUserRegisto = "Registar";
    
    public String login(){


        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext context = FacesContext.getCurrentInstance();
        
        userLogado = utilizadorFacade.login(username, password);
        
        if (userLogado != null){  
            logado = true;
            String primeiroNome = userLogado.getPrimeiroNome();
            nameLogedUserIndex = primeiroNome;
            nameLogedUserRegisto = primeiroNome;
            return "/home/listavooshome.xhtml?faces-redirect=true";
        }
        else{
            logado = false;
            context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Inválido", "Username ou Password incorretos"));
            return null;
        }

    }
    
    public String entrarOuPerfil(){
    
        if (logado == true){
            return "/perfil/perfil.xhtml?faces-redirect=true";
        }else{
            return "/autentication/login.xhtml?faces-redirect=true";
        }
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
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

    public String getNameLogedUserIndex() {
        return nameLogedUserIndex;
    }

    public void setNameLogedUserIndex(String nameLogedUserIndex) {
        this.nameLogedUserIndex = nameLogedUserIndex;
    }

    public String getNameLogedUserRegisto() {
        return nameLogedUserRegisto;
    }

    public void setNameLogedUserRegisto(String nameLogedUserRegisto) {
        this.nameLogedUserRegisto = nameLogedUserRegisto;
    }

    




    
            
    
    
    
}
