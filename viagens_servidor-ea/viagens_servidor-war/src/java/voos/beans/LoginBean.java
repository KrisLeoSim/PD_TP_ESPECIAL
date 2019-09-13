/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voos.beans;



import javax.inject.Named;
import javax.ejb.EJB;
import persistencia.UtilizadorFacadeLocal;
import entidade.Utilizador;
import static java.awt.SystemColor.window;
import java.io.IOException;
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
    
    private String registoUsername;
    private String registoPassword; 
    private String registoNif; 
    
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
    
    
    public String logout(Boolean confirma) {
        if (confirma){
            FacesContext context = FacesContext.getCurrentInstance();
            this.userLogado = null;
            context.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Efetuou logout"));
            context.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            return "/home/index.xhtml?faces-redirect=true?";
        }
        else{
            return "/perfil/perfil.xhtml?faces-redirect=true";
        }

    }
    
    
    public String registar(){
        
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();           
            
            utilizadorFacade.registar(registoUsername, registoPassword, registoNif, "cliente");
            
            context.addMessage("grow1", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Utilizador criado com sucesso"));
        } catch (Exception ex) {
            context.addMessage("grow1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao criar o utilizador"));
            return null;
        } finally {
            context.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
            return "/home/listavooshome.xhtml?faces-redirect=true";
        } 
    }
    
    public String entrarOuPerfil(){
        
        if (logado == true){
            return "../perfil/perfil.xhtml";
        }else{
            return "../autentication/login.xhtml";
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

    public String getRegistoUsername() {
        return registoUsername;
    }

    public void setRegistoUsername(String registoUsername) {
        this.registoUsername = registoUsername;
    }

    public String getRegistoPassword() {
        return registoPassword;
    }

    public void setRegistoPassword(String registoPassword) {
        this.registoPassword = registoPassword;
    }

    public String getRegistoNif() {
        return registoNif;
    }

    public void setRegistoNif(String registoNif) {
        this.registoNif = registoNif;
    }

    public Utilizador getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Utilizador userLogado) {
        this.userLogado = userLogado;
    }

    




    
            
    
    
    
}
