package fr.doranco.livretout.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class CategoryDao implements ICategoryDao {
	
	
	

	public CategoryDao() {
		
	}
	

	@Override
	public Category addCategory(Category category) throws SQLException {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(category);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
		
		return category;
	}
	
	

	@Override
	public Category getArticles(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCategory(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	


}
