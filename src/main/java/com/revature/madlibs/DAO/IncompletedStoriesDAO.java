package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.utils.HibernateUtilities;

public class IncompletedStoriesDAO {
	
	public void insert(IncompleteStories is) {
	Session ses = HibernateUtilities.getSession();
	
	ses.save(is);
	//HibernateUtility.closeSession();
	}

}
