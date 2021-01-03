package com.revature.madlibs.DAO;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public IncompleteStories selectById(int id) {
		Session session =sf.getCurrentSession();
		IncompleteStories incompleteStory = session.get(IncompleteStories.class, id);	
		return incompleteStory;
	}
	
	@Override
	public IncompleteStories findStory(StoryCategory sc, UserLevel lvl) { 
		Session session = sf.getCurrentSession();
//		Random r = new Random();
//		Query q = session.createNativeQuery("select * from incomplete_stories "
//				+ "where category = ? and user_level = ?;");
//		q.setParameter(1, sc);
//		q.setParameter(2, lvl);
//		@SuppressWarnings("unchecked")
//		List<IncompleteStories> storyList = (List<IncompleteStories>) q.getResultList();
//		int max = storyList.size();
//		IncompleteStories story = storyList.get(r.nextInt(max));
		return null;
	}


}


