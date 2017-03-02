/**
 * 
 */
package br.com.cco2anpi.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author wotan Class used like the base of all repositories
 */
public class BaseRepository {
	protected static SessionFactory sessionFactory;
	protected String context;

	/**
	 * Constructor of the class BaseRepository
	 * 
	 * @param context
	 */
	public BaseRepository(String context) {
		this.context = context;
		sessionFactory = new Configuration().configure(context).buildSessionFactory();
	}

	/**
	 * Method used to return session factory
	 * 
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		if (sessionFactory.isClosed()) {
			sessionFactory = new Configuration().configure(context).buildSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * Method used to close factory connection
	 */
	public static void close() {
		sessionFactory.close();
	}
}
