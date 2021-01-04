package com.revature.madlibs.DAO;

import java.util.List;
<<<<<<< HEAD

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
=======

import org.hibernate.Session;
import org.hibernate.Transaction;
>>>>>>> parent of cce3ef8... final version more or less

import com.revature.madlibs.models.CompletedStories;
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
<<<<<<< HEAD
	
	@Override
	public IncompleteStories selectByCategoryUserLevel(StoryCategory category, UserLevel level) {
		Session session = sf.getCurrentSession();
//		
//		CriteriaQuery<IncompleteStories> cq = session.getCriteriaBuilder().createQuery(IncompleteStories.class);	
//		cq.from(IncompleteStories.class);
//		System.out.println("inside DAO findAll  "+session.createQuery(cq).getResultList());
//		return session.createQuery(cq).getResultList();	
//		
		
//		IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);	
//		return incompleteStory;
		return null;
	}
	
	@Override
	public List<IncompleteStories> findAll(){
		Session session = sf.getCurrentSession();
		CriteriaQuery<IncompleteStories> cq = session.getCriteriaBuilder().createQuery(IncompleteStories.class);	
		Root<IncompleteStories> root = cq.from(IncompleteStories.class);
		
		System.out.println("inside DAO findAll  "+session.createQuery(cq).getResultList());
		return session.createQuery(cq).getResultList();		
		
			
		
=======

	public IncompleteStories selectById(int id) {
		Session session = HibernateUtilities.getSession();
		IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);
		
		return incompleteStory;
	}
	
	public List<IncompleteStories> findAll(){
		Session session = HibernateUtilities.getSession();
		
		List<IncompleteStories> list = session.createQuery("FROM IncompleteStories").list();
		
		return list;		
>>>>>>> parent of cce3ef8... final version more or less
	}

}
