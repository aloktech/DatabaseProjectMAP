/**
 * 
 */
package com.imos.dp.hibernate;

import lombok.extern.java.Log;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Pintu
 *
 */
@Log
public abstract class AbstractHibernateServices {

	protected HibernateConfiguration config;
	
	private Transaction transaction;
	
	protected Session session;
	
	public AbstractHibernateServices() {
		
		config = HibernateConfiguration.getInstance();
		session = getSession();
	}
	
	protected void beforeTransaction() {
		session = getSession();
		transaction = session.getTransaction();
		transaction.begin();
	}

	protected void afterTransaction() {
		try {
			transaction.commit();
			session.flush();
		} catch (Exception e) {
			transaction.rollback();
			log.warning(e.getMessage());
		} finally {
			close(session);
		}
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		if (session == null) {
			session = config.getHu().createSession();
		} else if (!session.isOpen()) {
			session = config.getHu().createSession();
		}
		log.info("Session Created");
		return session;
	}
	
	protected void close(Session session) {
		if (session.isOpen()) {
			config.getHu().close(session);
		}
		
		log.info("Session Closed");
	}
	
	protected void close() {
		config.getHu().close();
		
		log.info("SessionFactory Closed");
	}
	
}
