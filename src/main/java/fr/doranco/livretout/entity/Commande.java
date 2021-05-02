package fr.doranco.livretout.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@Entity
//@Table (name ="commande")
public class Commande {
	
//		@Id
//		@GeneratedValue(strategy=GenerationType.IDENTITY)
//		@Column(name = "id", nullable = false)
		private Integer id;
		
		
//		@Column(name = "date_achat", length=45, nullable = false)
		private String dateAchat;
		
//		@NotNull
//		@Column(name = "prix_total", length=5, nullable = false)
		private Integer prixTotal;
		
//		@NotNull
//		@Column(name = "remise", length=5, nullable = false)
		private Integer remise;
		
		
//		@NotNull
//		@Column(name = "frais_expedition", length=5, nullable = false)
		private Integer fraisExpedition;
		

//		@Column(name = "date_livraison", length=45, nullable = false)
		private String dateLivraison;
//
//		@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
//		private List<LigneCommande> ligneCommandes;
//	
//		@ManyToOne
//		@JoinColumn(name="user_id",nullable = false )
//		private User user;

		///

		public Commande() {
//			ligneCommandes = new ArrayList<LigneCommande>();
		}


	


//		public Commande(String dateAchat, @NotNull Integer prixTotal, @NotNull Integer remise,
//				@NotNull Integer fraisExpedition, String dateLivraison, List<LigneCommande> ligneCommandes, User user) {
//			super();
//			this.dateAchat = dateAchat;
//			this.prixTotal = prixTotal;
//			this.remise = remise;
//			this.fraisExpedition = fraisExpedition;
//			this.dateLivraison = dateLivraison;
////			this.ligneCommandes = ligneCommandes;
////			this.user = user;
//		}





		public Integer getId() {
			return id;
		}





		public void setId(Integer id) {
			this.id = id;
		}





		public String getDateAchat() {
			return dateAchat;
		}





		public void setDateAchat(String dateAchat) {
			this.dateAchat = dateAchat;
		}





		public Integer getPrixTotal() {
			return prixTotal;
		}





		public void setPrixTotal(Integer prixTotal) {
			this.prixTotal = prixTotal;
		}





		public Integer getRemise() {
			return remise;
		}





		public void setRemise(Integer remise) {
			this.remise = remise;
		}





		public Integer getFraisExpedition() {
			return fraisExpedition;
		}





		public void setFraisExpedition(Integer fraisExpedition) {
			this.fraisExpedition = fraisExpedition;
		}





		public String getDateLivraison() {
			return dateLivraison;
		}





		public void setDateLivraison(String dateLivraison) {
			this.dateLivraison = dateLivraison;
		}





//		public List<LigneCommande> getLigneCommandes() {
//			return ligneCommandes;
//		}
//
//
//
//
//
//		public User getUser() {
//			return user;
//		}

}	




		