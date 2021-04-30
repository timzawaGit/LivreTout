package fr.doranco.livretout.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.livretout.entity.Commentaire;
import fr.doranco.livretout.hibernate.connector.HibernateConnector;

public class CommentaireDao implements ICommentaireDao {
	
	

	public CommentaireDao() {
		
	}


	@Override
	public Commentaire addCommentaire(Commentaire commentaire) throws Exception {
		
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateConnector.getsession();
			tx= session.beginTransaction();
			session.save(commentaire);
			tx.commit();
		} catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if(session!=null&& session.isOpen())
				session.close();
		}
		
		return commentaire;
	}
	

	@Override
	public Commentaire getCommentaire(Integer id) throws Exception {

		Session session = HibernateConnector.getsession();
		Commentaire commentaire = session.get(Commentaire.class, id);
		
	
		if (session != null && session.isOpen())
			session.close();
		return commentaire;
	}

	@Override
	public List<Commentaire> getCommentaireAll() throws Exception {
		Session session = HibernateConnector.getsession();
		Query<Commentaire> query = session.createQuery("From Commentaire cm", Commentaire.class );
		List<Commentaire> commentaires = query.list();
		
		if (session != null && session.isOpen())
			session.close();
		return commentaires;
	}


	@Override
	public void updateCommentaire(Commentaire commentaire) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateConnector.getsession();
			tx = session.beginTransaction();
			session.update(commentaire);
			tx.commit();
		} catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if(session!=null && session.isOpen())
				session.close();
		}
		
	}


	@Override
	public void removeCommentaire(Commentaire commentaire) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateConnector.getsession();
			tx = session.beginTransaction();
			session.remove(commentaire);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			if(session != null && session.isOpen())
				session.close();
		}
		
	}

	

}
