package fr.doranco.livretout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.doranco.livretout.entity.Article;

public class ArticleDao implements IArticleDao {

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
	//	LivreToutDataSource ds = new LivreToutDataSource();
	//	Connection connexion = ds.getConnection();
		
		Connection connexion = LivreToutDataSource.getInstance().getConnection();
		
		
		String requete = "INSERT INTO article(intitule, prix, quantite)"
				+ "VALUES(?,?,?)";
		PreparedStatement ps =  connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,article.getIntitule());
		ps.setInt(2,article.getPrix());
		ps.setInt(3, article.getQuantite());
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		
		if(rs.next()) {
			int id = rs.getInt(1);
			article.setId(id);
			
		}
		if(connexion != null) {
			connexion.close();
		}
		return article;
	}

	@Override
	public Article getArticles(Integer id) throws SQLException {
		
		// pas sur du tout de ce code
		//??????
		
//		LivreToutDataSource ds = new LivreToutDataSource();
//		Connection connexion = ds.getConnection();
		
		Connection connexion = LivreToutDataSource.getInstance().getConnection();
		
		String requete = "SELECT FROM article WHERE id=?";
			
		PreparedStatement ps =  connexion.prepareStatement(requete);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		Article article = null;
		if(rs.next()) {
		article = new Article();
		article.setId(rs.getInt("id"));
		article.setIntitule(rs.getString("intitule"));
		article.setPrix(rs.getInt("prix"));
		article.setQuantite(rs.getInt("quantite"));
		}
		
		return article;
	}

	@Override
	public List<Article> getArticlesAll() throws SQLException {
		
		Connection connexion = LivreToutDataSource.getInstance().getConnection();
		
		String requete = "SELECT * FROM article";
		
		PreparedStatement ps =  connexion.prepareStatement(requete);
		ResultSet rs = ps.executeQuery();
		List<Article> articles = new ArrayList<Article>();
		while(rs.next()) {
		Article article =new Article();
		article.setId(rs.getInt("id"));
		article.setIntitule(rs.getString("intitule"));
		article.setPrix(rs.getInt("prix"));
		article.setQuantite(rs.getInt("quantite"));
		articles.add(article);
		}
		
		
		return articles;
	}

	@Override
	public void updateArticle(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArticle(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
