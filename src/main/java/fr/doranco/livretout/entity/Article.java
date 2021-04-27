package fr.doranco.livretout.entity;

public class Article {

	private Integer id;
	private String intitule;
	private Integer prix;
	private Integer quantite;
	
	public Article() {
		
	}

	// constructeur avec les champs
	public Article(String intitule, Integer prix, Integer quantite) {
		super();
		this.intitule = intitule;
		this.prix = prix;
		this.quantite = quantite;
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
	
	
	

	

}
