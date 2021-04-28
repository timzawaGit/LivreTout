package fr.doranco.livretout.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.livretout.entity.User;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class UserDao implements IUserDao {

	@Override
	public void add(User user) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
	}

	@Override
	public List<User> getAll() throws Exception {
		Session session = HibernateConnector.getsession();
		Query<User> query = session.createQuery("FROM user u", User.class);
		
		List<User> users = query.list();
		
		if (session != null && session.isOpen())
			session.close();
		return users;
	}

}
