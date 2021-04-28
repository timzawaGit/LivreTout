package fr.doranco.livretout.main;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.dao.CategoryDao;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;

public class Main {
	
	private static final ArticleMetier articleMetier = new ArticleMetier();
	private static final ArticleDao articleDao = new ArticleDao();
	private static final CategoryDao categoryDao = new CategoryDao();

	public static void main(String[] args) {
		
		// c'est ce qu'il y aura sur le bean
		
		Category category = new Category();
		category.setNomCategory("fruits");
		//category.setArticle(article);
		
		Article article = new Article();
		article.setIntitule("mirtille");
		article.setPrix(2);
		article.setQuantite(1);
		article.setCategory(category);
		// il faut absolument call la DAO pour la base, ne pas faire comme ci-dessus
		//category.getArticles().add(article);
		
		
		try {
			categoryDao.addCategory(category);
			System.out.println("categorie ajoutee: " + category.getId());
			articleDao.addArticle(article);
			System.out.println("article ajoute: " + article.getId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		
//		try {
//			List<Article>articles = articleDao.getArticlesAll();
//			System.out.println("la liste des articles: " + articles);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
		
		
		
		

	}

}
