package fr.doranco.livretout.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.livretout.entity.LigneCommande;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class LigneCommandeDao implements ILigneCommandeDao {

	@Override
	public LigneCommande add(LigneCommande ligneCommande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(ligneCommande);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
		
		return ligneCommande;
	}

}
