package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.User;
import com.revature.madlibs.utils.HibernateUtilities;

public class UserDAO {
	
	public void insert(User user) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(user);    
    t.commit();  
	}
	
	public void update(User user) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(user);    
	    t.commit();  
	}

	public User selectById(int id) {
		Session session = HibernateUtilities.getSession();
		User user = session.get(User.class, id);
		
		return user;
	}
	
	public List<User> findAll(){
		Session session = HibernateUtilities.getSession();
		
		List<User> list = session.createQuery("FROM User").list();
		
		return list;		
	}

}
