package fr.doranco.livretout.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.livretout.entity.Commande;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class CommandeDao implements ICommandeDao {

	@Override
	public Commande add(Commande commande) throws Exception {
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(commande);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
		
		return commande;
	}
	
	
	

}
