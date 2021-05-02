package fr.doranco.livretout.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="carte_paiement")
public class CartePaiement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "nom_proprietaire", length=45, nullable = false)
	private String nomProprietaire;
	
	@Column(name = "prenom_proprietaire", length=45, nullable = false)
	private String prenomProprietaire;
	
	@NotNull
	@Column(name = "numero", length=5, nullable = false)
	private byte[] numero;
	
	
	@Column(name = "date_limite", length=45, nullable = false)
	//@Temporal(TemporalType.DATE)
	private String dateLimite;
	
	@NotNull
	@Column(name = "cryptogramme", length=5, nullable = false)
	private byte[] cryptogramme;
	
	@NotNull
	@Column(name = "cle_cryptage", nullable = false)
	private byte[] cleCryptage;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	// mettre surement une propriete avec enumeration (visa, mastercard etc...)
	
	public CartePaiement() {
	
	}


	public CartePaiement(String nomProprietaire, String prenomProprietaire, @NotNull byte[] numero, String dateLimite,
			@NotNull byte[] cryptogramme, @NotNull byte[] cleCryptage) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateLimite = dateLimite;
		this.cryptogramme = cryptogramme;
		this.cleCryptage = cleCryptage;
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



	public byte[] getNumero() {
		return numero;
	}



	public void setNumero(byte[] numero) {
		this.numero = numero;
	}





	public String getDateLimite() {
		return dateLimite;
	}


	public void setDateLimite(String dateLimite) {
		this.dateLimite = dateLimite;
	}


	public byte[] getCryptogramme() {
		return cryptogramme;
	}





	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}





	public byte[] getCleCryptage() {
		return cleCryptage;
	}





	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}










	




}
