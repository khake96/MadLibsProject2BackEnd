package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.utils.HibernateUtilities;

public class StoryCategoryDAO {
	
	public void insert(StoryCategory cs) {
	Session ses = HibernateUtilities.getSession();
	
	ses.save(cs);
	//HibernateUtility.closeSession();
	}

}
