package fr.doranco.livretout.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.IUserMetier;
import fr.doranco.livretout.control.UserMetier;
import fr.doranco.livretout.dto.AdresseDto;
import fr.doranco.livretout.dto.CartePaiementDto;
import fr.doranco.livretout.dto.UserDto;
import fr.doranco.livretout.entity.Adresse;
import fr.doranco.livretout.entity.User;

@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final IUserMetier userMetier = new UserMetier();

	@ManagedProperty(name = "idUser", value = "")
	private String idUser;
	
	@ManagedProperty(name = "id", value = "")
	private int id;
	
	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "prenom", value = "")
	private String prenom;

	
	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	
	// partie adresse 
	@ManagedProperty(name = "numero", value = "")
	private Integer numero;
	
	@ManagedProperty(name = "rue", value = "")
	private String rue;
	
	@ManagedProperty(name = "codePostal", value = "")
	private String codePostal;
	
	@ManagedProperty(name = "ville", value = "")
	private String ville;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;
	
	// attributs des cartes de paiement
	
	@ManagedProperty(name = "nomProprietaire", value = "")
	private String nomProprietaire;
	
	@ManagedProperty(name = "prenomProprietaire", value = "")
	private String prenomProprietaire;
	
	@ManagedProperty(name = "numeroCb", value = "")
	private String numeroCb;
	
	
	@ManagedProperty(name = "dateLimite", value = "")
	private String dateLimite;
	
	
	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;
	
	

	public UserBean() {
	}
	
	public String save() {
		UserDto user = new UserDto();
		AdresseDto adresse = new AdresseDto();
		
		CartePaiementDto cartePaiementDto = new CartePaiementDto();
		
		
		
		user.setNom(nom.trim());
		user.setPrenom(prenom.trim());
		user.setEmail(email.trim());
		user.setPassword(password.trim());
		adresse.setNumero(numero);
		adresse.setRue(rue.trim());
		adresse.setVille(ville.trim());
		adresse.setCodePostal(codePostal.trim());
		user.getAdresses().add(adresse);
		
		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setNumero(numeroCb);
		cartePaiementDto.setDateLimite(dateLimite);
		cartePaiementDto.setCryptogramme(cryptogramme);
		
		user.getCartes().add(cartePaiementDto);
		
		
		
		try {
			userMetier.add(user);
			return "success?faces-redirect=true";
			
		} catch (Exception e) {
			messageError = "Erreur lors de l'inscription de l'utilisateur !\n" + e.getMessage();
		}
		
		return "";
	}
	

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "UserBean [idUser=" + idUser + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", numero=" + numero + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public String getNumeroCb() {
		return numeroCb;
	}

	public void setNumeroCb(String numeroCb) {
		this.numeroCb = numeroCb;
	}

	public String getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	

	
	
	
	
	
}
