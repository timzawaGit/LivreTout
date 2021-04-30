package fr.doranco.livretout.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.control.IArticleMetier;
import fr.doranco.livretout.dto.ArticleDto;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;

@ManagedBean(name ="articleBean")
public class ArticleBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private final IArticleMetier articleMetier = new ArticleMetier();
	private final ArticleDto articleDto = new ArticleDto();
	
	
	@ManagedProperty(name="id", value="")
	private int id;
	
	
	@ManagedProperty(name="intitule", value="")
	private String intitule;
	
	
	@ManagedProperty(name="description", value="")
	private String description;
	
	@ManagedProperty(name="prix", value="")
	private String prix;
	
	
	@ManagedProperty(name="remise", value="")
	private String remise;
	
	
	@ManagedProperty(name="quantite", value="")
	private String quantite;
	
// category

	public ArticleBean() {
	}
	
	    public String save() {
	    articleDto.setIntitule(intitule.trim());
	    articleDto.setDescription(description.trim());
	    articleDto.setPrix(prix.trim());
	    articleDto.setRemise(remise.trim());
	    articleDto.setQuantite(quantite.trim());
	    System.out.println("on a passe les argument" +articleDto.getPrix());
	    
	    
	    try {
			articleMetier.add(articleDto);
			System.out.println("ajout d'article reussi");
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("Erreur :" +e.getMessage());
		}
	    return "";
	    }
		
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
