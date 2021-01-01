package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.CompletedStories;

@Repository
@Transactional
public class CompletedStoriesDAO implements IcompletedStoriesDAO{

	private SessionFactory sf;
	
	@Autowired
	public CompletedStoriesDAO(SessionFactory sf) {
		super();
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
	public CompletedStories selectById(int id) {
		Session session = sf.getCurrentSession();
		CompletedStories story = session.get(CompletedStories.class, id);
		return story;
	}
	
	@Override
	public List<CompletedStories> findAll(){
		Session session = sf.getCurrentSession();

		CriteriaQuery<CompletedStories> cq = session.getCriteriaBuilder().createQuery(CompletedStories.class);
		cq.from(CompletedStories.class);
		return session.createQuery(cq).getResultList();	
	}
		
		
		
}
