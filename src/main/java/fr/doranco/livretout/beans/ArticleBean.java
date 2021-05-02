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
	
	@ManagedProperty(name = "category", value="")
	private String category;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;
	
	public ArticleBean() {
	}
	
    public String save() {
	    articleDto.setIntitule(intitule.trim());
	    articleDto.setDescription(description.trim());
	    articleDto.setPrix(prix.trim());
	    articleDto.setRemise(remise.trim());
	    articleDto.setQuantite(quantite.trim());
	    articleDto.setCategory(category.trim());
	    System.out.println("on a passe les argument" +articleDto.getPrix());
	    
	    
	    try {
			articleMetier.add(articleDto);
			System.err.println("ajout d'article reussi");
			return "success-article?faces-redirect=true";
		} catch (Exception e) {
			System.err.println("Erreur :" +e.getMessage());
			messageError = "Erreur lors de l'ajout de l'article ! --> " + e.getMessage();
		}
	    return "";
    }
    
    public List<Article> getAll() {
    	try {
			List<Article> articles = articleMetier.getArticlesAll();
			if (articles != null) {
				return articles;
			}
		} catch (Exception e) {
			System.err.println("Erreur dans articleBean - getAll --> " +e.getMessage());
			messageError = "Erreur dans articleBean - getAll --> " + e.getMessage();
		}
    	return new ArrayList<Article>();
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	
	
}
	
