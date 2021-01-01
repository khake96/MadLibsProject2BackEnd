package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.StoryCategory;

@Repository
@Transactional
public class StoryCategoryDAO implements IstoryCategoryDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public StoryCategoryDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public void insert(StoryCategory storyCategory) {
	Session session =  sf.getCurrentSession();
    Transaction t=session.beginTransaction();            
    session.persist(storyCategory);    
    t.commit();  
	}

	@Override
	public StoryCategory selectById(int id) {
		Session session =  sf.getCurrentSession();
		StoryCategory storyCategory = session.get(StoryCategory.class, id);
		
		return storyCategory;
	}

	@Override
	public List<StoryCategory> findAll(){
		Session session =  sf.getCurrentSession();	
		CriteriaQuery<StoryCategory> cq = session.getCriteriaBuilder().createQuery(StoryCategory.class);	
		cq.from(StoryCategory.class);
		return session.createQuery(cq).getResultList();		
	}

}
