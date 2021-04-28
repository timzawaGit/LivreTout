package fr.doranco.livretout.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.livretout.entity.Adresse;

public class AdresseDao implements IAdresseDao {
	
	

	public AdresseDao() {
	}

	@Override
	public void add(Adresse adresse) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			//session = HibernateConnector.getSession();
			tx = session.beginTransaction();
			session.save(adresse);
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
	public List<Adresse> getAll() throws Exception {
		//Session session = HibernateConnector.getSession();
//		Query<Adresse> query = session.createQuery("FROM Adresse a", Adresse.class);
//		
//		List<Adresse> adresses = query.list();
//		
//		if (session != null && session.isOpen())
//			session.close();
//		return adresses;
		return null;
	}

}
