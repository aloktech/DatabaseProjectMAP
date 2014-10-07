package com.imos.dp;

import org.hibernate.Session;

import com.imos.dp.model.Level;
import com.imos.dp.model.User;
import com.imos.dp.util.HibernateUtility;

/**
 * @author Pintu
 *
 */
public class DatabaseMainFile {

	public DatabaseMainFile() {
		
		HibernateUtility hu = HibernateUtility.getInstance();
		
		hu.setFilePath("src/main/java/com/imos/dp/model");
		hu.setDatabaseName("learningdb");
		hu.configure();
		hu.createSession();
		
		Session session = hu.getSession();
		
		User user = new User();
		user.setId(16L);
		user.setFirstName("Alok2");
		user.setLastName("Meher233");
		
		session.getTransaction().begin();
		//session.persist(user);
		session.merge(user);
		//session.getTransaction().commit();
		
		//session.getTransaction().begin();
		//session.save(user);
		//session.saveOrUpdate(user);
		//session.update(user);
		session.getTransaction().commit();
		session.flush();
		session.clear();
		hu.close(session);
		
	}

	public static void main(String[] args) {

		new DatabaseMainFile();
		
	}
}
