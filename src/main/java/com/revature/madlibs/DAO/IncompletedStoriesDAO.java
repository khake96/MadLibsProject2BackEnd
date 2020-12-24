package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.utils.HibernateUtilities;

public class IncompletedStoriesDAO {
	
	public void insert(IncompleteStories cs) {
	Session ses = HibernateUtilities.getSession();
	
	ses.save(cs);
	//HibernateUtility.closeSession();
	}

}
