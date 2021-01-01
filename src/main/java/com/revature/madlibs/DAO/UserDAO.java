package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.User;

@Repository
@Transactional
public class UserDAO implements IuserDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public UserDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override	
	public void insert(User user) {
	Session session = sf.getCurrentSession();
    Transaction t=session.beginTransaction();        
    session.persist(user);    
    t.commit();  
	}
	
	@Override	
	public void update(User user) {
		Session session = sf.getCurrentSession();
	    Transaction t=session.beginTransaction();            
	    session.merge(user);    
	    t.commit();  
	}

	@Override	
	public User selectById(int id) {
		Session session = sf.getCurrentSession();
		User user = session.get(User.class, id);	
		return user;
	}
	
	@Override	
	public List<User> findAll(){
		Session session = sf.getCurrentSession();
		CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);	
		cq.from(User.class);
		return session.createQuery(cq).getResultList();			
	}

}
