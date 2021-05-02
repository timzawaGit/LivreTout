package fr.doranco.livretout.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.livretout.entity.CartePaiement;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class CartePaiementDao implements ICartePaiementDao {

	@Override
	public void add(CartePaiement cartePaiement) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(cartePaiement);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
		
		
	}

}
