package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.utils.HibernateUtilities;

public class CompletedStoriesDAO {
	
		public void insert(CompletedStories completedStory) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
	        
	    session.persist(completedStory);    
	    t.commit();  
		}
		
		public void update(CompletedStories completedStory) {
			Session session = HibernateUtilities.getSession();
		    Transaction t=session.beginTransaction();      
	        
		    session.merge(completedStory);    
		    t.commit();  
		}

		public CompletedStories selectById(int id) {
			Session session = HibernateUtilities.getSession();
			CompletedStories completedStory = session.get(CompletedStories.class, id);
			
			return completedStory;
		}
		
		public List<CompletedStories> findAll(){
			Session session = HibernateUtilities.getSession();
			
			List<CompletedStories> list = session.createQuery("FROM CompletedStories").list();
			
			return list;		
		}
		
		
		
}
