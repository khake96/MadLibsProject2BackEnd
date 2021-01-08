package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

//This DAO layer class implements an interface in order to enable Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

@Repository
@Transactional
public class LoginDAO implements IloginDAO{
	
	
	private SessionFactory sf;
	
	public LoginDAO() {
		super();
	}
	
	@Autowired
	public LoginDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public void insert(Login login) {
		try {
			Session session = sf.getCurrentSession();
			session.saveOrUpdate(login);
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert Login error: "+ e.getMessage());
		}
	}
	
	@Override
	public void update(Login login) {
		try {
			Session session = sf.getCurrentSession();      
		    session.merge(login); 
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("update Login error: "+ e.getMessage());
		}
   
	}

	@Override
	public Login selectByName(String username) {
		try {
			Session session = sf.getCurrentSession(); 
			Login login = session.get(Login.class, username);
			return login;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("selectByName Login error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public User validate(String uName, String password) {		
		Session session = sf.getCurrentSession();
        Login login = null;
        User user = null;
        try {
            login = (Login) session.createQuery("FROM Login U WHERE U.userName = :uName").setParameter("uName", uName)
                    .uniqueResult();
//                System.out.println("Inside LoginDAO - validate: "+login);
                if (login != null && login.getPword().equals(password)) {
                    user = session.get(User.class, login.getUser().getUser_id());
                	return user;
                    }
                return null;
    	} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("validate Login error: "+ e.getMessage());
		}
		return null;

    }

	@Override
	public Login get(Login login) {
		try {
			Session session = sf.getCurrentSession();
			Login userLogin = session.get(Login.class, login.getUserName());
			return userLogin;
    	} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("get Login error: "+ e.getMessage());
		}
		return null;

	}

	@Override
	public List<Login> findAllLogins() {
		Session session = sf.getCurrentSession();
		try {
			CriteriaQuery<Login> cq = session.getCriteriaBuilder().createQuery(Login.class);
			cq.from(Login.class);
		 	System.out.println("inside DAO findAllLogins  "+session.createQuery(cq).getResultList());
			return session.createQuery(cq).getResultList();	
    	} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("findAllLogins Login error: "+ e.getMessage());
		}
		return null;

	}
}
