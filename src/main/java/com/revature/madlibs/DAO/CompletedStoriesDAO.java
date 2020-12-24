package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.utils.HibernateUtilities;

public class CompletedStoriesDAO {
	
		public void insert(CompletedStories cs) {
		Session ses = HibernateUtilities.getSession();
		
		ses.save(cs);
		//HibernateUtility.closeSession();
		}
}
