package fr.doranco.livretout.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name ="ligne_commande")
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "quantite", length=5, nullable = false)
	private Integer quantite;
	
//	@Column(name = "date_achat", length=45, nullable = false)
//	private String dateAchat;
	
	@NotNull
	@Column(name = "prix_unite", length=5, nullable = false)
	private Integer prixUnite;
	
	
	@NotNull
	@Column(name = "prix_total", length=5, nullable = false)
	private Integer prixTotal;
	
	// 
	
	@ManyToOne
	@JoinColumn(name="article_id",nullable = false )
	private Article article;
//	
//	@ManyToOne
//	@JoinColumn(name="commande_id",nullable = false )
//	private Commande commande;
//	
//	@Column(name ="user_ligne")
//	//j'ai hesite a mettre une liste ou juste comme ca ?
//	private User user;

	
	
	public LigneCommande() {
		
	}



	public LigneCommande(@NotNull Integer quantite, @NotNull Integer prixUnite, @NotNull Integer prixTotal,
			Article article) {
		super();
		this.quantite = quantite;
		this.prixUnite = prixUnite;
		this.prixTotal = prixTotal;
		this.article = article;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getQuantite() {
		return quantite;
	}



	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}



	public Integer getPrixUnite() {
		return prixUnite;
	}



	public void setPrixUnite(Integer prixUnite) {
		this.prixUnite = prixUnite;
	}



	public Integer getPrixTotal() {
		return prixTotal;
	}



	public void setPrixTotal(Integer prixTotal) {
		this.prixTotal = prixTotal;
	}



	public Article getArticle() {
		return article;
	}
//
//
//
	public void setArticle(Article article) {
		this.article = article;
	}
//
//
//
//	public Commande getCommande() {
//		return commande;
//	}
//
//
//
//	public void setCommande(Commande commande) {
//		this.commande = commande;
//	}
//
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
	

}


