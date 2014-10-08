/**
 * 
 */
package com.imos.dp.hibernate;

import lombok.Getter;
import lombok.extern.java.Log;

import org.hibernate.Session;

import com.imos.dp.util.HibernateUtility;

/**
 * @author Pintu
 *
 */
@Log
public class HibernateConfiguration {

	@Getter
	private Session session;
	
	@Getter
	private final HibernateUtility hu = HibernateUtility.getInstance();
	
	private static HibernateConfiguration instance;
	
	/**
	 * 
	 */
	public HibernateConfiguration() {
		
		hu.setFilePath("src/main/java/com/imos/dp/model");
		hu.setDatabaseName("learningdb");
		hu.configure();
		session = hu.createSession();
	}
	
	public static HibernateConfiguration getInstance() {
		if (instance == null) {
			try {
				instance = new HibernateConfiguration();
			} catch (Exception e) {
				log.warning(e.getMessage());
			}
		}
		return instance;
	}
}
