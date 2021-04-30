package fr.doranco.livretout.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.livretout.entity.Article;
import fr.doranco.livretout.entity.Category;
import fr.doranco.livretout.entity.User;
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
	public Category getCategory(Integer id) throws Exception {
		Session session = HibernateConnector.getsession();
		Category category = session.get(Category.class, id);
		
		// les 3 lignes ci-dessous correspondent a la ligne de dessus
//		Query q2 = session.createQuery("FROM Category c WHERE c.id = :id", Category.class);
//		q2.setParameter("id", id);
//		Category c2 =(Category) q2.getSingleResult();
		
		if (session != null && session.isOpen())
			session.close();
		return category;
	}


	@Override
	public List<Category> getCategoryAll() throws Exception {
		Session session = HibernateConnector.getsession();
		Query<Category> query = session.createQuery("FROM Category ct", Category.class);
		List<Category> categories = query.list();
		
		if (session != null && session.isOpen())
			session.close();
		return categories;
	}


	@Override
	public void updateCategory(Category category) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
		session = HibernateConnector.getsession();
		tx = session.beginTransaction();
		session.update(category);
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
	public void removeCategory(Category category) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx = session.beginTransaction();
			session.remove(category);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	
		
	}






		
}
	
	


