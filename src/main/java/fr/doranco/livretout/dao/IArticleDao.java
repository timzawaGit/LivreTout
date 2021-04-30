package fr.doranco.livretout.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.entity.Article;

public interface IArticleDao {
	
	
		//CRUD
	
		Article addArticle(Article article) throws Exception;
		Article getArticle (Integer id) throws Exception;
		// ou bien afficher la liste des article
		List<Article> getArticlesAll() throws Exception;
		void updateArticle (Article article)throws Exception;
		void removeArticle(Article article)throws Exception;

}
