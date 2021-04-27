package fr.doranco.livretout.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.entity.Article;

public class ArticleMetier implements IArticleMetier {
	
	private ArticleDao articleDao = new ArticleDao();

	@Override
	public Article addArticle(Article article) throws SQLException {
		
		if(article==null) {
			throw new NullPointerException ("L'article ne peut pas etre null");
			
		}
		if(article.getIntitule()==null || article.getIntitule().isEmpty()
		|| article.getPrix()==null || article.getPrix()<=0
		// je pense que la quantite ne doit pas etre mise......
		|| article.getQuantite()==null || article.getQuantite()<=0) {
			throw new IllegalArgumentException("Tous les paramentres de l'article ne peuvent etre null... ");
	}
		
		return articleDao.addArticle(article);
	}

	@Override
	public Article getArticles(Integer id) throws SQLException {
		
		return articleDao.getArticles(id);
	}

	@Override
	public List<Article> getArticlesAll() throws SQLException {
		
		return articleDao.getArticlesAll();
	}

	// update avec le id ou article en parametre ??
	@Override
	public void updateArticle(Integer id) throws SQLException {
		articleDao.updateArticle(id);
		
	}

	@Override
	public void removeArticle(Integer id) throws SQLException {
		articleDao.removeArticle(id);
		
	}

}
