package com.revature.madlibs.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.utils.HibernateUtilities;

public class LoginDAO {
	
	public void insert(Login login) {
	Session session = HibernateUtilities.getSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(login);    
    t.commit();  
	}
	
	public void update(Login login) {
		Session session = HibernateUtilities.getSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(login);    
	    t.commit();  
	}

	public Login selectById(String username) {
		Session session = HibernateUtilities.getSession();
<<<<<<< HEAD
		Login login = session.get(Login.class, username);
		
		return login;
	}
<<<<<<< HEAD
	
	@Override
	public Login selectByName(String username) {
		Session session = sf.getCurrentSession();
=======
>>>>>>> parent of cce3ef8... final version more or less
		Login login = session.get(Login.class, username);
		
		return login;
	}
<<<<<<< HEAD
	
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

	@Override
	public List<Login> findAllLogins() {
		Session session = sf.getCurrentSession();
		CriteriaQuery<Login> cq = session.getCriteriaBuilder().createQuery(Login.class);
		cq.from(Login.class);
	 	System.out.println("inside DAO findAllLogins  "+session.createQuery(cq).getResultList());
		return session.createQuery(cq).getResultList();	
	}
	
	@Override
	public Login findLoginById(int id) {
		System.out.println("Inside: LoginDAO - findLoginById");
		Session s = sf.getCurrentSession();
		return s.get(Login.class, id);
	}
=======
>>>>>>> parent of cce3ef8... final version more or less
=======
>>>>>>> parent of cce3ef8... final version more or less

}
