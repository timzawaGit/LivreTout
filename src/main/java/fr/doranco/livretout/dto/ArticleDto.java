package fr.doranco.livretout.dto;

public class ArticleDto {
	
	private Integer id;
	private String intitule;
	private String description;
	private String prix;
	private String remise;
	private String quantite;
	
	
	public ArticleDto() {
	
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getRemise() {
		return remise;
	}


	public void setRemise(String remise) {
		this.remise = remise;
	}


	public String getQuantite() {
		return quantite;
	}


	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	
	
	

}
