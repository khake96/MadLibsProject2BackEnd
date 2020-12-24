package com.revature.madlibs.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	
//	/**Load the hibernate.cfg.xml from the classpath**/
//	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//	private static Session session;
//
//	public static Session getSession() {
//		//** Pull db url, password and username from environmental variables. **/
////		cfg.setProperty("hibernate.connection.url", "javafs201130.c7jaqnx6gsaq.us-east-1.rds.amazonaws.com/madlibs");
////		cfg.setProperty("hibernate.connection.password", System.getenv("postgresPassword"));
////		cfg.setProperty("hibernate.connection.username", System.getenv("postgresUserName"));
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		
//		if(session==null) {
//			session = sessionFactory.openSession();
//		}
//		return session;
//	}
//	
//	public static void closeSession() {
//		session.close();
//		session = null;
//	}
	
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static Session ses;

	public static Session getSession() {
		if(ses==null) {
			ses = sf.openSession();
		}
		return ses;
	}
	
	public static void closeSession() {
		ses.close();
		ses = null;
	}

}
