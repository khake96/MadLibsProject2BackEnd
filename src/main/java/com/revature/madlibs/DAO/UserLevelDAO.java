package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.UserLevel;
import com.revature.madlibs.utils.HibernateUtilities;

public class UserLevelDAO {
	
	public void insert(UserLevel level) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(level);    
    t.commit();  
	}
	
	public void update(UserLevel level) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(level);    
	    t.commit();  
	}

	public UserLevel selectById(int id) {
		Session session = HibernateUtilities.getSession();
		UserLevel level = session.get(UserLevel.class, id);
		
		return level;
	}
	
	public List<UserLevel> findAll(){
		Session session = HibernateUtilities.getSession();
		
		List<UserLevel> list = session.createQuery("FROM UserLevel").list();
		
		return list;		
	}

}
