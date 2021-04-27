package fr.doranco.livretout.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.entity.Article;

public interface IArticleMetier {
	
	//CRUD
	
			Article addArticle(Article article) throws SQLException;
			Article getArticles (Integer id) throws SQLException;
			// ou bien afficher la liste des article
			List<Article> getArticlesAll() throws SQLException;
			void updateArticle (Integer id)throws SQLException;
			void removeArticle(Integer id)throws SQLException;

}
