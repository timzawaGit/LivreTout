package fr.doranco.livretout.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.livretout.dao.ArticleDao;
import fr.doranco.livretout.dao.CategoryDao;
import fr.doranco.livretout.dto.ArticleDto;
import fr.doranco.livretout.dto.CategoryDto;
import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;

public class ArticleMetier implements IArticleMetier {
	
	private ArticleDao articleDao = new ArticleDao();
	private final CategoryDao categoryDao = new CategoryDao();

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

	@Override
	public void add(ArticleDto articleDto) throws Exception {
		
		if(articleDto==null) {
			throw new NullPointerException("L'article à ajouter est NULL !");
		}
		
		if(articleDto.getIntitule()==null || articleDto.getIntitule().trim().isEmpty()
		|| articleDto.getDescription()==null || articleDto.getDescription().trim().isEmpty()
		|| articleDto.getPrix()==null || articleDto.getPrix().trim().isEmpty()
		|| articleDto.getQuantite()==null || articleDto.getQuantite().trim().isEmpty()) {
			
			throw new IllegalArgumentException("Des paramètres de type string manquent dans l'article à ajouter !");
		}
		
		Article article = new Article();
		article.setIntitule(articleDto.getIntitule());
		article.setDescription(articleDto.getDescription());
		article.setPrix(Integer.parseInt(articleDto.getPrix()));
		article.setQuantite(Integer.parseInt(articleDto.getQuantite()));
		
		// on donne une categorie pour l'article pour tester
		Category category = new Category("fruit", 0);
		categoryDao.addCategory(category);
		article.setCategory(category);
		
		if(articleDto.getRemise()==null || articleDto.getRemise().trim().isEmpty()) {
			article.setRemise(0);
		} else {
			article.setRemise(Integer.parseInt(articleDto.getRemise()));
		}
		
		articleDao.addArticle(article);
			
		
	}

	




}
