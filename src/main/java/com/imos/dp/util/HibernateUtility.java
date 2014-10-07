/**
 * 
 */
package com.imos.dp.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import lombok.Data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author Pintu
 *
 */
@Data
public class HibernateUtility {

	private static HibernateUtility instance = new HibernateUtility();

	private Configuration cfg = new Configuration();

	private Session session;
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private boolean createDatabase;

	private String filePath, databaseName, url = "hibernate.connection.url";

	private String sqlPath = "protocol:subprotocol://host:port/database";

	private HibernateUtility() {
	}

	public static HibernateUtility getInstance() {
		if (instance == null) {
			instance = new HibernateUtility();
		}

		return instance;
	}

	public void configure() {

		for (String path : CommonUtility.extractPackageNameFromFilePath(
				filePath, "src/main/java/", "java")) {
			try {
				System.out.println(path);
				cfg.addAnnotatedClass(Class.forName(path));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		ResourceBundleUtility utility = new ResourceBundleUtility();
		MysqlInfo mysqlInfo = new MysqlInfo();
		mysqlInfo = utility.populateMysqlResources(mysqlInfo);
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/main/resources/hibernate.properties"));
			cfg.setProperties(prop);
			sqlPath = sqlPath.replace("subprotocol", mysqlInfo.getSubprotocol());
			sqlPath = sqlPath.replace("protocol", mysqlInfo.getProtocol());
			sqlPath = sqlPath.replace("host", mysqlInfo.getHost());
			sqlPath = sqlPath.replace("port", mysqlInfo.getPort().toString());
			sqlPath = sqlPath.replace("database", mysqlInfo.getDatabase());
			
			cfg.setProperty("hibernate.connection.url", sqlPath);
			cfg.setProperty("hibernate.connection.username", mysqlInfo.getUsername());
			cfg.setProperty("hibernate.connection.password", mysqlInfo.getPassword());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (createDatabase) {
			new SchemaExport(cfg).create(true, true);
		}
	}

	public Session createSession() {
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		boolean createSession = false;
		if (session == null) {
			createSession = true;
		} else if (!session.isOpen()) {
			createSession = true;
		}
		if (createSession) {
			if (sessionFactory == null) {
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			} else if (sessionFactory.isClosed()) {
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
			}
			session = sessionFactory.openSession();
		}

		return session;
	}

	public void close() {
		if (session.isOpen()) {
			session.clear();
			session.close();
		}

		sessionFactory.close();

		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}

	public void close(Session session) {
		if (session.isOpen()) {
			session.clear();
			session.close();
		}

		sessionFactory.close();

		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
}
