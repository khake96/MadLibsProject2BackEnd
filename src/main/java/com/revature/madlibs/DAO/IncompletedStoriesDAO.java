package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.User;
import com.revature.madlibs.utils.HibernateUtilities;

public class IncompletedStoriesDAO {
	
	public void insert(IncompleteStories incompleteStory) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(incompleteStory);    
    t.commit();  
	}
	
	public void update(IncompleteStories incompleteStory) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(incompleteStory);    
	    t.commit();  
	}

	public IncompleteStories selectById(int id) {
		Session session = HibernateUtilities.getSession();
		IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);
		
		return incompleteStory;
	}
	
	public List<IncompleteStories> findAll(){
		Session session = HibernateUtilities.getSession();
		
		List<IncompleteStories> list = session.createQuery("FROM IncompleteStories").list();
		
		return list;		
	}

}
