package fr.doranco.livretout.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.control.IArticleMetier;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;

@ManagedBean(name ="articleBean")
public class ArticleBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private final IArticleMetier articleMetier = new ArticleMetier();
	
	
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
	
	
	@ManagedProperty(name="category_id", value="")
	private Category category;
	
	
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private static String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private static String messageError;
	
	static {
		messageSuccess = "";
		messageError = "";
	}
	

	public ArticleBean() {
	}
	
//	public String save() {
//		UserDto user = new UserDto();
//		AdresseDto adresse = new AdresseDto();
//		
//		user.setNom(nom.trim());
//		user.setPrenom(prenom.trim());
//		user.setEmail(email.trim());
//		user.setPassword(password.trim());
//		adresse.setNumero(numero);
//		adresse.setRue(rue.trim());
//		adresse.setVille(ville.trim());
//		adresse.setCodePostal(codePostal.trim());
//		user.getAdresses().add(adresse);
//		
//		try {
//			userMetier.add(user);
//			return "success?faces-redirect=true";
//			
//		} catch (Exception e) {
//			messageError = "Erreur lors de l'inscription de l'utilisateur !\n" + e.getMessage();
//		}
//		
//		return "";
//	}
//	
	public String addArticle() {
		Article article = new Article();
		Category category = new Category();
		article.setIntitule(intitule);
		article.setPrix(prix);
		article.setDescription(description);
		article.setRemise(remise);
		article.setQuantite(quantite);
		article.setCategory(category);
		
		try {
			articleMetier.addArticle(article);
			messageSuccess = "Ajout d'article reussi";
		} catch (Exception e) {
			System.out.println(e);
			messageError ="Erreur lors de l'ajout de votre article \n" + e.getMessage();
		}
		return "";
	}
	
	public List<Article>getArticlesAll(){
		try {
			List<Article> articles = articleMetier.getArticlesAll();
		if (articles!=null)
		return articles;
	} catch (Exception e) {
		messageError ="Erreur lors de la recup des articles"; 
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

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
	
