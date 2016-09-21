package org.sx.was.app.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;

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

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.login(this.username, this.password);
		} catch (ServletException e) {

			context.addMessage(null, new FacesMessage("Login failed."));
			return "error";
		}
		return "protected/welcome.xhtml?faces-redirect=true";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try {
			request.logout();
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        //return "protected/welcome.xhtml?faces-redirect=true";
	        //return "login.xhtml?faces-redirect=true";
			System.out.println("login");
			
			return "/logout";
	        
		} catch (ServletException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("Logout failed."));
		}
		
		return null;
	}

}
