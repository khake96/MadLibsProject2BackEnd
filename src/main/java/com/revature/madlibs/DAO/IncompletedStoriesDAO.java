package com.revature.madlibs.DAO;

import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;

//This DAO layer class implements an interface in order to enable Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

@Repository
@Transactional
public class IncompletedStoriesDAO implements IincompletedStoriesDAO{
	
	
	private SessionFactory sf;
	
	
	
	public IncompletedStoriesDAO() {
		super();
	}
	
	@Autowired
	public IncompletedStoriesDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(IncompleteStories incompleteStory) {
		try {
			Session session = sf.getCurrentSession();         
		    session.persist(incompleteStory);  
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert IncompletedStories error: "+ e.getMessage());
		}
  
	}
	
	public void update(IncompleteStories incompleteStory) {
		try {
			Session session = sf.getCurrentSession();           
		    session.merge(incompleteStory);    
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("update IncompletedStories error: "+ e.getMessage());
		}

	}
	
	@Override
	public IncompleteStories selectById(int id) {
		try {
			Session session = sf.getCurrentSession(); 
			IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);
			return incompleteStory;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("selectById IncompletedStories error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<IncompleteStories> findAll(){
		try {
			Session s = sf.getCurrentSession();
			CriteriaQuery<IncompleteStories> cq = s.getCriteriaBuilder().createQuery(IncompleteStories.class);
			cq.from(IncompleteStories.class);
			return s.createQuery(cq).getResultList();
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("findAll IncompletedStories error: "+ e.getMessage());
		}
		return null;
	}

	@Override
	public IncompleteStories selectByCategoryUserLevel(StoryCategory category, UserLevel level, int missingWordCount) {
		try {
			Session session = sf.getCurrentSession();
			Random random = new Random();
			@SuppressWarnings("unchecked")
			List<IncompleteStories> storyList = session.createNativeQuery("select * from incomplete_stories " +
					" where user_level = " + level.getLevel_id() + " and category = " + category.getCategoryId() +
					" and missing_word_count = "+ missingWordCount +";").getResultList();
			IncompleteStories selected = storyList.get(random.nextInt(storyList.size()));
			return selected;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("selectByCategoryEtc IncompletedStories error: "+ e.getMessage());
		}
		return null;
	}

}
