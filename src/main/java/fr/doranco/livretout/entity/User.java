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
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotEmpty
	@Column(name = "email", nullable = false)
	@Size(min = 5, max = 20, message = "Le Email doit être compris entre 5 et 20 caractères")
	private String email;
	
	@NotEmpty
	@Column(name = "password", nullable = false)
	@Size(min = 6, max = 15, message = "Le mot de passe doit être compris entre 6 et 15 caractères")
	private byte[] password;
	
	@NotEmpty
	@Column(name = "cle_cryptage", nullable = false)
	private byte[] cleCryptage;
	
	@NotEmpty
	@Column(name = "isActif", nullable = false)
	private Boolean isActif;
	
	@NotEmpty
	@Column(name = "profil", nullable = false)
	private String profil;
	
	@NotEmpty
	@Column(name = "date_naissance", nullable = false)
	private Date dateNaissance;
	
	@NotEmpty
	@Column(name = "telephone", nullable = false)
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Adresse> adresses;
	
	@NotNull
	@Column(name = "adresse_facturation", nullable = false)
	private Integer adresseFacturationId;
	
	@NotNull
	@Column(name = "adresse_livraison", nullable = false)
	private Integer adresseLivraisonId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<CartePaiement> cartes;
	
	@NotNull
	@Column(name = "carte_paiement_default", nullable = false)
	private Integer cartePaiementDefautId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<ArticlePanier> panier;

	public User() {
		// Tu instancies dans le constructeur les listes pour éviter de les avoir en null et retourner une exception
		adresses = new ArrayList<Adresse>();
		cartes = new ArrayList<CartePaiement>();
		commandes = new ArrayList<Commande>();
		panier = new ArrayList<ArticlePanier>();
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public List<CartePaiement> getCartes() {
		return cartes;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", cleCryptage=" + Arrays.toString(cleCryptage) + ", isActif=" + isActif
				+ ", profil=" + profil + ", dateNaissance=" + dateNaissance + ", telephone=" + telephone + ", adresses="
				+ adresses + ", adresseFacturationId=" + adresseFacturationId + ", adresseLivraisonId="
				+ adresseLivraisonId + ", cartes=" + cartes + ", cartePaiementDefautId=" + cartePaiementDefautId
				+ ", commandes=" + commandes + ", commentaires=" + commentaires + ", panier=" + panier + "]";
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getAdresseFacturationId() {
		return adresseFacturationId;
	}

	public void setAdresseFacturationId(Integer adresseFacturationId) {
		this.adresseFacturationId = adresseFacturationId;
	}

	public Integer getAdresseLivraisonId() {
		return adresseLivraisonId;
	}

	public void setAdresseLivraisonId(Integer adresseLivraisonId) {
		this.adresseLivraisonId = adresseLivraisonId;
	}

	public Integer getCartePaiementDefautId() {
		return cartePaiementDefautId;
	}

	public void setCartePaiementDefautId(Integer cartePaiementDefautId) {
		this.cartePaiementDefautId = cartePaiementDefautId;
	}
	
	
	
	
	
	
}
