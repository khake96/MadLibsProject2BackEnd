package com.revature.madlibs.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.Login;

@Repository
@Transactional
public class LoginDAO implements IloginDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void IloginDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Login login) {
	Session session = sf.getCurrentSession();         
    session.persist(login);    
	}
	
	@Override
	public void update(Login login) {
		Session session = sf.getCurrentSession();        
	    session.merge(login);    
	}

	@Override
	public Login selectById(String username) {
		Session session = sf.getCurrentSession();
		Login login = session.get(Login.class, username);
		return login;
	}
	
	@Override
	public boolean validate(String uName, String password) {		
		Session session = sf.getCurrentSession();
        Login user = null;
        System.out.println("inside LoginDAO validate: "+session);
        user = (Login) session.createQuery("FROM Login U WHERE U.userName = :uName").setParameter("uName", uName)
            .uniqueResult();           
        if (user != null && user.getPassword().equals(password)) {
            return true;
            }
        return false;
    }

	@Override
	public Login get(Login login) {
		Session session = sf.getCurrentSession();
		Login userLogin = session.get(Login.class, login.getUserName());
		return userLogin;
	}

}
