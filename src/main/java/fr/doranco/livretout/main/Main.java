package fr.doranco.livretout.main;

import java.sql.SQLException;

import fr.doranco.livretout.control.ArticleMetier;
import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.entity.Article;

public class Main {
	
	private static final ArticleMetier articleMetier = new ArticleMetier();
	private static final ArticleDao articleDao = new ArticleDao();

	public static void main(String[] args) {
		
		// c'est ce qu'il y aura sur le bean
		
		Article article = new Article();
		article.setIntitule("pomme");
		article.setPrix(2);
		article.setQuantite(5);
		
		try {
			articleMetier.addArticle(article);
			System.out.println("article ajoute: " + article.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
