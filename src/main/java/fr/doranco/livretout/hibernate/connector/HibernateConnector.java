package fr.doranco.livretout.hibernate.connector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {
	
	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private HibernateConnector() throws Exception {
		if(sessionFactory==null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			}
		if(session==null || !session.isOpen() ) {
			session = sessionFactory.openSession();
			}
		}
	
	public static Session getsession() throws Exception {
		if (instance == null) 
			instance = new HibernateConnector();
		if (!session.isOpen())
			session = sessionFactory.openSession();
		return session;
		
	}
	
	public static void shutDown() throws Exception {
		if (session!= null && session.isOpen()) {
			session.close();
		}
		if (sessionFactory != null && sessionFactory.isOpen())
			sessionFactory.close();
	}

}
