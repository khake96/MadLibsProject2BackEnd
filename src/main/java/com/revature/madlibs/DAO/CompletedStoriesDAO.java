package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.utils.HibernateUtilities;

public class CompletedStoriesDAO {
	
<<<<<<< HEAD
	@Autowired
	public void IcompletedStoriesDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(CompletedStories completedStory) {
		Session session = sf.getCurrentSession();
		Transaction t=session.beginTransaction();             
		session.persist(completedStory);    
		t.commit();  
	}
		
	@Override
	public void update(CompletedStories completedStory) {
		Session session = sf.getCurrentSession();
	    Transaction t=session.beginTransaction();      	        
	    session.merge(completedStory);    
	    t.commit();  
	}

	@Override
	public CompletedStories selectCompletedById(int id) {
		Session session = sf.getCurrentSession();
		CompletedStories story = session.get(CompletedStories.class, id);
		return story;
	}
	
	@Override
	public List<CompletedStories> findAll(){
		Session session = sf.getCurrentSession();
		CriteriaQuery<CompletedStories> cq = session.getCriteriaBuilder().createQuery(CompletedStories.class);
		cq.from(CompletedStories.class);
	//	System.out.println("inside DAO findAll  "+session.createQuery(cq).getResultList());
		return session.createQuery(cq).getResultList();	
	}
=======
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
>>>>>>> parent of cce3ef8... final version more or less
		
		
		
}
