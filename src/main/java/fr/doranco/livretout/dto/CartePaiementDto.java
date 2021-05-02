package fr.doranco.livretout.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import fr.doranco.livretout.entity.User;

public class CartePaiementDto {
	
	private Integer id;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String numero;
	private String dateLimite;
	private String cryptogramme;
	private String cleCryptage;
	// je pense : il y a un seul user donc pas de list
	private User userCarte;
	
	
	public CartePaiementDto() {
		// eventuellement on pourrait rajouter une liste ds le constructeur
		// si on fait un OneToMany ou ManyToMany
	}



	public CartePaiementDto(String nomProprietaire, String prenomProprietaire, String numero, String dateLimite,
			String cryptogramme, String cleCryptage, User userCarte) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateLimite = dateLimite;
		this.cryptogramme = cryptogramme;
		this.cleCryptage = cleCryptage;
		this.userCarte = userCarte;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
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



	public String getCleCryptage() {
		return cleCryptage;
	}



	public void setCleCryptage(String cleCryptage) {
		this.cleCryptage = cleCryptage;
	}



	public User getUserCarte() {
		return userCarte;
	}



	public void setUserCarte(User userCarte) {
		this.userCarte = userCarte;
	}





	
	
	
	

}
