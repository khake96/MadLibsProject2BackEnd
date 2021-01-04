package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;

@Repository
@Transactional
public class IncompletedStoriesDAO implements IincompletedStoriesDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void IincompletedStoriesDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(IncompleteStories incompleteStory) {
	Session session = sf.getCurrentSession();           
    session.persist(incompleteStory);    
	}
	
	@Override
	public void update(IncompleteStories incompleteStory) {
		Session session = sf.getCurrentSession();       
	    session.merge(incompleteStory);    
	}
	
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
		
			
		
	}

}
