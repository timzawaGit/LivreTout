package fr.doranco.livretout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class ArticleDao implements IArticleDao {
	

	public ArticleDao() {
		
	}

	@Override
	public Article addArticle(Article article) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(article);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
//		if(article==null) {
//			throw new NullPointerException ("L'article ne peut pas etre null");
//			
//		}
//		if(article.getIntitule()==null || article.getIntitule().isEmpty()
//		|| article.getPrix()==null || article.getPrix()<=0
//		// je pense que la quantite ne doit pas etre mise......
//		|| article.getQuantite()==null || article.getQuantite()<=0) {
//			throw new IllegalArgumentException("Tous les paramentres de l'article ne peuvent etre null... ");
//	}
//	//	LivreToutDataSource ds = new LivreToutDataSource();
//	//	Connection connexion = ds.getConnection();
//		
//		Connection connexion = LivreToutDataSource.getInstance().getConnection();
		
//		
//		String requete = "INSERT INTO article(intitule, prix, quantite)"
//				+ "VALUES(?,?,?)";
//		PreparedStatement ps =  connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
//		ps.setString(1,article.getIntitule());
//		ps.setInt(2,article.getPrix());
//		ps.setInt(3, article.getQuantite());
//		
//		ps.executeUpdate();
//		ResultSet rs = ps.getGeneratedKeys();
//		
//		if(rs.next()) {
//			int id = rs.getInt(1);
//			article.setId(id);
//			
//		}
//		if(connexion != null) {
//			connexion.close();
//		}
		return article;
	}

	@Override
	public Article getArticle(Integer id) throws Exception {
		
		// pas sur du tout de ce code
		//??????
		
//		LivreToutDataSource ds = new LivreToutDataSource();
//		Connection connexion = ds.getConnection();
		
		
		// approche ss hibernate les 14 lignes ci-dessous
		
//		Connection connexion = LivreToutDataSource.getInstance().getConnection();
//		
//		String requete = "SELECT FROM article WHERE id=?";
//			
//		PreparedStatement ps =  connexion.prepareStatement(requete);
//		ps.setInt(1,id);
//		ResultSet rs = ps.executeQuery();
//		Article article = null;
//		if(rs.next()) {
//		article = new Article();
//		article.setId(rs.getInt("id"));
//		article.setIntitule(rs.getString("intitule"));
//		article.setPrix(rs.getInt("prix"));
//		article.setQuantite(rs.getInt("quantite"));
//		}
//		
//		return article;
		
		
		Session session = HibernateConnector.getsession();
		Article article = session.get(Article.class, id);
		
		// les 3 lignes ci-dessous correspondent a la ligne de dessus
//		Query q2 = session.createQuery("FROM Category c WHERE c.id = :id", Category.class);
//		q2.setParameter("id", id);
//		Category c2 =(Category) q2.getSingleResult();
		
		if (session != null && session.isOpen())
			session.close();
		return article;
		
		
	}

	@Override
	public List<Article> getArticlesAll() throws Exception {
		
		Session session = HibernateConnector.getsession();
		Query<Article> query = session.createQuery("FROM Article u", Article.class);
		
		List<Article> articles = query.list();
		
		if (session != null && session.isOpen())
			session.close();
		return articles;
	}

	@Override
	public void updateArticle(Article article) throws Exception {

		Session session = null;
		Transaction tx = null;
		
		try {
		session = HibernateConnector.getsession();
		tx = session.beginTransaction();
		session.update(article);
		tx.commit();
		} catch (Exception ex){
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();	
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
	}

	@Override
	public void removeArticle(Article article) throws Exception {
		Session session =null;
		Transaction tx = null;
		
		try {
			session = HibernateConnector.getsession();
			tx = session.beginTransaction();
			session.remove(article);
			tx.commit();
		} catch(Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if(session!=null && session.isOpen());
			session.close();
				
		}
		
	}
		
		
		// Methode sans hibernate
		
//		Connection connexion = LivreToutDataSource.getInstance().getConnection();
//		
//		String requete = "SELECT * FROM article";
//		
//		PreparedStatement ps =  connexion.prepareStatement(requete);
//		ResultSet rs = ps.executeQuery();
//		List<Article> articles = new ArrayList<Article>();
//		while(rs.next()) {
//		Article article =new Article();
//		article.setId(rs.getInt("id"));
//		article.setIntitule(rs.getString("intitule"));
//		article.setPrix(rs.getInt("prix"));
//		article.setQuantite(rs.getInt("quantite"));
//		articles.add(article);
//		}
//		
//		
//		return articles;
	

	


	
	
	

}
