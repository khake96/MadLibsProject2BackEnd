package com.revature.madlibs.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.utils.HibernateUtilities;

public class LoginDAO {
	
	public void insert(Login login) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(login);    
    t.commit();  
	}
	
	public void update(Login login) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(login);    
	    t.commit();  
	}

	public Login selectById(String username) {
		Session session = HibernateUtilities.getSession();
		Login login = session.get(Login.class, username);
		
		return login;
	}
	
	public boolean validate(String uName, String password) {

        Transaction transaction = null;
        Login user = null;
        try (Session session = HibernateUtilities.getSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = (Login) session.createQuery("FROM User U WHERE U.userName = :uName").setParameter("uName", uName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}
