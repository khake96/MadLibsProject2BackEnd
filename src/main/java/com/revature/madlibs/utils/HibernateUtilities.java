package com.revature.madlibs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	
	/**Load the hibernate.cfg.xml from the classpath**/
	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	private static Session session;

	public static Session getSession() {
		//** Pull db url, password and username from environmental variables. **/
		
		if(session==null) {
			cfg.setProperty("hibernate.connection.url", System.getenv("madlibsPostgresPath"));
			cfg.setProperty("hibernate.connection.password", System.getenv("postgresPassword"));
			cfg.setProperty("hibernate.connection.username", System.getenv("postgresUserName"));
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		session = null;
	}

}
