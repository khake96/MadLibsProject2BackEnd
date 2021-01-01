package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.IncompleteStories;

@Repository
@Transactional
public class IncompletedStoriesDAO implements IincompletedStoriesDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public IncompletedStoriesDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public void insert(IncompleteStories incompleteStory) {
	Session session = sf.getCurrentSession();
    Transaction t=session.beginTransaction();            
    session.persist(incompleteStory);    
    t.commit();  
	}
	
	@Override
	public void update(IncompleteStories incompleteStory) {
		Session session = sf.getCurrentSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(incompleteStory);    
	    t.commit();  
	}
	
	@Override
	public IncompleteStories selectById(int id) {
		Session session =sf.getCurrentSession();
		IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);
		
		return incompleteStory;
	}
	
	@Override
	public List<IncompleteStories> findAll(){
		Session session = sf.getCurrentSession();
		CriteriaQuery<IncompleteStories> cq = session.getCriteriaBuilder().createQuery(IncompleteStories.class);	
		cq.from(IncompleteStories.class);
		return session.createQuery(cq).getResultList();		
	}

}
