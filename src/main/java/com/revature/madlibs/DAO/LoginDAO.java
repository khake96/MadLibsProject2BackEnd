package com.revature.madlibs.DAO;

import org.hibernate.Session;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.utils.HibernateUtilities;

public class LoginDAO {
	
	public void insert(Login login) {
		Session ses = HibernateUtilities.getSession();
		
		ses.save(login);
		//HibernateUtility.closeSession();
	}

}
