package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.UserLevel;
import com.revature.madlibs.utils.HibernateUtilities;

public class UserLevelDAO {
	
	public void insert(UserLevel cs) {
	Session ses = HibernateUtilities.getSession();
	
	ses.save(cs);
	//HibernateUtilities.closeSession();
	}

}
