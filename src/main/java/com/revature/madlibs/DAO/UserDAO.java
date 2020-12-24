package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.User;
import com.revature.madlibs.utils.HibernateUtilities;

public class UserDAO {
	
	public void insert(User user) {
		Session ses = HibernateUtilities.getSession();
		
		ses.save(user);
		//HibernateUtility.closeSession();
	}

	public void update(User user) {
		Session ses = HibernateUtilities.getSession();
		
		ses.merge(user);
	}

	public User selectById(int id) {
		Session ses = HibernateUtilities.getSession();
		
		User author = ses.get(User.class, id);
		
		return author;
	}

}
