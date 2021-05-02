package fr.doranco.livretout.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotNull
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotNull
	@Column(name = "email", nullable = false)
	@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères")
	private String email;
	
	@NotNull
	@Column(name = "password", nullable = false)
	@Size(min = 6, max = 15, message = "Le mot de passe doit être compris entre 6 et 15 caractères")
	private byte[] password;
	
	@NotNull
	@Column(name = "cle_cryptage", nullable = false)
	private byte[] cleCryptage;
//	
//	@NotEmpty
//	@Column(name = "isActif", nullable = false)
//	private Boolean isActif;
//	
//	@NotEmpty
//	@Column(name = "profil", nullable = false)
//	private String profil;
//	
//	@NotEmpty
//	@Column(name = "date_naissance", nullable = false)
//	private Date dateNaissance;
	
	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
//	@NotEmpty
//	@Column(name = "telephone", nullable = false)
//	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Adresse> adresses;
	
//	@NotNull
//	@Column(name = "adresse_facturation", nullable = false)
//	private Integer adresseFacturationId;
//	
//	@NotNull
//	@Column(name = "adresse_livraison", nullable = false)
//	private Integer adresseLivraisonId;
//	
//	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//	private List<CartePaiement> cartes;
//	
//	//@NotNull
//	//@Column(name = "carte_paiement_default", nullable = false)
//	private Integer cartePaiementDefautId;
//	
//	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//	private List<Commande> commandes;
//	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
//	
//	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//	private List<ArticlePanier> panier;

	public User() {
		// Tu instancies dans le constructeur les listes pour éviter de les avoir en null et retourner une exception
		adresses = new ArrayList<Adresse>();
//		cartes = new ArrayList<CartePaiement>();
//		commandes = new ArrayList<Commande>();
//		panier = new ArrayList<ArticlePanier>();
		commentaires = new ArrayList<Commentaire>();
		
	}
	
	

	public User(@NotEmpty String nom, @NotEmpty String prenom,
		@NotEmpty @Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères") String email) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	adresses = new ArrayList<Adresse>();
	commentaires = new ArrayList<Commentaire>();
}



	public List<Adresse> getAdresses() {
		return adresses;
	}
	

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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



	public byte[] getPassword() {
		return password;
	}



	public void setPassword(byte[] password) {
		this.password = password;
	}



	public byte[] getCleCryptage() {
		return cleCryptage;
	}



	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	
	
	
	
	
	
	
}
