package fr.doranco.livretout.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.entity.Article;

public interface IArticleMetier {
	
	//CRUD
	
			Article addArticle(Article article) throws Exception;
			Article getArticles (Integer id) throws Exception;
			// ou bien afficher la liste des article
			List<Article> getArticlesAll() throws Exception;
			void updateArticle (Integer id)throws Exception;
			void removeArticle(Integer id)throws Exception;

}
