package com.revature.madlibs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.utils.HibernateUtilities;

@Repository
@Transactional
public class LoginDAO implements IloginDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public LoginDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public void insert(Login login) {
	Session session = sf.getCurrentSession();
    Transaction t=session.beginTransaction();          
    session.persist(login);    
    t.commit();  
	}
	
	@Override
	public void update(Login login) {
		Session session = sf.getCurrentSession();
	    Transaction t=session.beginTransaction();        
	    session.merge(login);    
	    t.commit();  
	}

	@Override
	public Login selectById(String username) {
		Session session = sf.getCurrentSession();
		Login login = session.get(Login.class, username);
		return login;
	}
	
	@Override
	public boolean validate(String uName, String password) {
		
		Session session = sf.getCurrentSession();
        Transaction transaction = null;
        Login user = null;
        try {
        	System.out.println("inside LoginDAO validate: "+session);
            transaction = session.beginTransaction();
            user = (Login) session.createQuery("FROM Login U WHERE U.userName = :uName").setParameter("uName", uName)
                .uniqueResult();
            
            if (user != null && user.getPassword().equals(password)) {

        		HibernateUtilities.closeSession();
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
        session.close();
        return false;
    }

}
