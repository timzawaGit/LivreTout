package fr.doranco.livretout.entity;

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

@Entity
@Table (name ="article")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	
	@Column(name = "intitule", length=45, nullable = false)
	private String intitule;
	
	@Column(name = "description", length=45, nullable = false)
	private String description;
	
	@NotNull
	@Column(name = "prix", length=5, nullable = false)
	private Integer prix;
	
	@NotNull
	@Column(name = "remise", length=5, nullable = false)
	private Integer remise;
	
	@NotNull
	@Column(name = "quantite", length=8, nullable = false)
	private Integer quantite;
	
	@Column(name = "commentaire", length=45, nullable = false)
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false )
	private Category category;
	
	public Article() {
		
	}

	// constructeur avec les champs
	public Article( String intitule, String description, @NotNull Integer prix, @NotNull Integer quantite, String commentaire) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.quantite = quantite;
		this.commentaire = commentaire;
		
	}
	
	// getter et setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}
	
	
	
	

	

}
