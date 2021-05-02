package fr.doranco.livretout.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name = "article_panier")
public class ArticlePanier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id", nullable = false)
	private Integer id;
	
//	@NotNull
//	@Column(name = "quantite", nullable = false)
	private Integer quantite;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	public ArticlePanier() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", quantite=" + quantite + ", user=" + user + ", article=" + article + "]";
	}
	
	

	
	
	
	
	
	
}
