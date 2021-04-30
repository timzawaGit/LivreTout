package fr.doranco.livretout.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.IUserMetier;
import fr.doranco.livretout.control.UserMetier;
import fr.doranco.livretout.entity.User;


@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;

	public LoginBean() {
	}
	
	public String toLogin() {
		User user;
		try {
			user = userMetier.toLogin(email, password);
			if (user != null) {
				return "success?faces-redirect=true";
			}
			messageError = "Email et/ou Password incorrects ! Veuillez réessayer.";
		} catch (Exception e) {
			messageError = "Erreur lors de la connexion de l'utilisateur !\n" + e.getMessage();
		}
		return "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + ", messageSuccess=" + messageSuccess
				+ ", messageError=" + messageError + "]";
	}
	
	
	
}
