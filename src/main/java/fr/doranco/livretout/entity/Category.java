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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name ="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	
	@Column(name = "nomCategory", length=45, nullable = false)
	private String nomCategory;
	
	@NotNull
	@Column(name = "remise", length=5, nullable = false)
	private Integer remise;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
	private List<Article> articles;


	public Category() {
		articles = new ArrayList<Article>();
	}


	public Category( String nomCategory, @NotNull Integer remise) {
		
		this.nomCategory = nomCategory;
		this.remise = remise;
		articles = new ArrayList<Article>();
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomCategory() {
		return nomCategory;
	}


	public void setNomCategory(String nomCategory) {
		this.nomCategory = nomCategory;
	}
	
	


	public Integer getRemise() {
		return remise;
	}


	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	// pour liste Article, on ne met que le getter

	public List<Article> getArticles() {
		return articles;
	}


	

	
	
	
	

}
