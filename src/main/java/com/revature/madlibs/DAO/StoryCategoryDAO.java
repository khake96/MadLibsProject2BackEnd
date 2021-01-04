package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.utils.HibernateUtilities;

public class StoryCategoryDAO {
	
	public void insert(StoryCategory storyCategory) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(storyCategory);    
    t.commit();  
	}

	public StoryCategory selectById(int id) {
		Session session = HibernateUtilities.getSession();
		StoryCategory storyCategory = session.get(StoryCategory.class, id);
		
		return storyCategory;
	}
	
	public List<StoryCategory> findAll(){
		Session session = HibernateUtilities.getSession();
		
		 List<StoryCategory> list = session.createQuery("FROM StoryCategories").list();
		
		return list;		
	}

}
