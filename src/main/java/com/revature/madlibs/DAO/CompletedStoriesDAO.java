package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.CompletedStories;

// This DAO layer class implements an interface in order to enable Spring Framework tools and ORM 
// to abstract the Hibernate ORM from us. 

@Repository
@Transactional
public class CompletedStoriesDAO implements IcompletedStoriesDAO {

	private SessionFactory sf;
	
	@Autowired
	public CompletedStoriesDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public CompletedStoriesDAO() {
		super();
	}

	// This method utilizes a native query in order to access an object with multiple conditions checked in the DB.
	
	@Override
	public CompletedStories insert(CompletedStories completedStory) {
		Session session = sf.getCurrentSession();  
		try {
			session.save(completedStory); 
			CompletedStories latestStory = (CompletedStories) session.createNativeQuery("SELECT * FROM completed_stories cs \r\n"
					+ "WHERE complete_story_id = (\r\n"
					+ "   SELECT MAX (complete_story_id)\r\n"
					+ "   FROM completed_stories cs2 \r\n"
					+ ");").getSingleResult();
			return latestStory; 
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert CompletedStories error: "+ e.getMessage());
		}
		return null;
		 
	}
	
	// This method utilizes a native query in order to access an object with multiple conditions checked in the DB.
		
	@Override
	public CompletedStories update(CompletedStories completedStory) {
		Session session = sf.getCurrentSession(); 
		try {
		    session.merge(completedStory);    
			CompletedStories latestStory = (CompletedStories) session.createNativeQuery("SELECT * FROM completed_stories cs \r\n"
					+ "WHERE complete_story_id = (\r\n"
					+ "   SELECT MAX (complete_story_id)\r\n"
					+ "   FROM completed_stories cs2 \r\n"
					+ ");").getSingleResult();
			return latestStory;  
		} catch (Exception e) {	
			com.revature.madlibs.Logger.log.debug("update CompletedStories error: "+ e.getMessage());
		}
		return null;
 
	}

	@Override
	public CompletedStories selectCompletedById(int id) {
		try {
			Session session = sf.getCurrentSession();
			CompletedStories story = session.get(CompletedStories.class, id);
			return story;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("select by ID CompletedStories error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<CompletedStories> findAll(){
		try {
			Session session = sf.getCurrentSession();
			CriteriaQuery<CompletedStories> cq = session.getCriteriaBuilder().createQuery(CompletedStories.class);
			cq.from(CompletedStories.class);
			return session.createQuery(cq).getResultList();	
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("findAll CompletedStories error: "+ e.getMessage());
		}
		return null;
	}

	@Override
	public CompletedStories selectById(int id) {
		try {
			Session session =  sf.getCurrentSession();
			CompletedStories completedStory = session.get(CompletedStories.class, id);
			return completedStory;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("select by ID CompletedStories error: "+ e.getMessage());
		}
		return null;
	}
	
	// This method utilizes a native query in order to access an object with multiple conditions checked in the DB.
	
	@Override
	public CompletedStories getLastIn() {
		try {
			Session session = sf.getCurrentSession();
			CompletedStories latestStory = (CompletedStories) session.createNativeQuery("SELECT * FROM completed_stories cs \r\n"
					+ "WHERE complete_story_id = (\r\n"
					+ "   SELECT MAX (complete_story_id)\r\n"
					+ "   FROM completed_stories cs2 \r\n"
					+ ");").getSingleResult();
			return latestStory;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("getLastIn CompletedStories error: "+ e.getMessage());
		}
		return null;
	}

}
