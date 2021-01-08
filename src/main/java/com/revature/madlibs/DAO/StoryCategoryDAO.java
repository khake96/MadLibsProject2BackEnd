package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.StoryCategory;

//This DAO layer class implements an interface in order to enable Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

@Repository
@Transactional
public class StoryCategoryDAO implements IstoryCategoryDAO{

	private SessionFactory sf;    
	
	@Autowired
	public StoryCategoryDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public StoryCategoryDAO() {
		super();
	}

	public StoryCategory selectById(int id) {
		try {
			Session session = sf.getCurrentSession();
			StoryCategory storyCategory = session.get(StoryCategory.class, id);
			return storyCategory;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("select StoryCategory error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<StoryCategory> findAll(){
		Session session = sf.getCurrentSession();
		try {
			CriteriaQuery<StoryCategory> cq = session.getCriteriaBuilder().createQuery(StoryCategory.class);
			cq.from(StoryCategory.class);
			return session.createQuery(cq).getResultList();	
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("findAll StoryCategory error: "+ e.getMessage());
		}
		return null;
	}
}
