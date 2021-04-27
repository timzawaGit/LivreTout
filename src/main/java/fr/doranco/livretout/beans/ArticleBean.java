package fr.doranco.livretout.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.control.IArticleMetier;
import fr.doranco.livretout.entity.Article;

@ManagedBean(name ="articleBean")


public class ArticleBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private final IArticleMetier articleMetier = new ArticleMetier();
	
@ManagedProperty
	public ArticleBean() {
	}
	
	public String addArticle() {
		Article article = new Article();
		article.setIntitule(intitule);
		article.setPrix(prix);
		article.setQuantite(quantite);
		
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
		return new ArrayList();
	
	

}
