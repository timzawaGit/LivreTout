package fr.doranco.livretout.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.entity.Article;

public class ArticleMetier implements IArticleMetier {
	
	private ArticleDao articleDao = new ArticleDao();

	@Override
	public Article addArticle(Article article) throws Exception {
		
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
	public Article getArticle(Integer id) throws Exception {
		
		return articleDao.getArticle(id);
	}

	@Override
	public List<Article> getArticlesAll() throws Exception {
		
		return articleDao.getArticlesAll();
	}

	// update avec le id ou article en parametre ??
	@Override
	public void updateArticle(Article article) throws Exception {
		articleDao.updateArticle(article);
		
	}

	@Override
	public void removeArticle(Article article) throws Exception {
		articleDao.removeArticle(article);
		
	}




}
