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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@NotEmpty
	@Column(name = "texte", nullable = false)
	@Size(min = 5, max = 300, message = "Le texte doit être compris entre 5 et 300 caractères")
	private String texte;
	
	@NotNull
	@Column(name = "note", nullable = false)
	private Float note;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;

	public Commentaire() {
	}

	

	public Commentaire(
			@NotEmpty @Size(min = 5, max = 300, message = "Le texte doit être compris entre 5 et 300 caractères") String texte,
			@NotNull Float note, User user, Article article) {
		super();
		this.texte = texte;
		this.note = note;
		this.user = user;
		this.article = article;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
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

	
	
	
	

	
}
