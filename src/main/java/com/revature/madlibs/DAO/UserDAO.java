package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.User;

@Repository
@Transactional
public class UserDAO implements IuserDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void IuserDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override	
	public void insert(User user) {
	Session session = sf.getCurrentSession();      
    session.persist(user);    
	}
	
	@Override	
	public void update(User user) {
		Session session = sf.getCurrentSession();          
	    session.merge(user);    
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
