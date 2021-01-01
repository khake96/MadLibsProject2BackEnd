package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.UserLevel;

@Repository
@Transactional
public class UserLevelDAO implements IuserLevelDAO {

	private SessionFactory sf;
	
	@Autowired
	public UserLevelDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public void insert(UserLevel level) {
	Session session = sf.getCurrentSession();
    Transaction t=session.beginTransaction();      
        
    session.persist(level);    
    t.commit();  
	}

	@Override
	public void update(UserLevel level) {
		Session session = sf.getCurrentSession();
	    Transaction t=session.beginTransaction();      
        
	    session.merge(level);    
	    t.commit();  
	}

	@Override
	public UserLevel selectById(int id) {
		Session session = sf.getCurrentSession();
		UserLevel level = session.get(UserLevel.class, id);
		
		return level;
	}
	
	@Override
	public List<UserLevel> findAll(){
		Session session = sf.getCurrentSession();
		CriteriaQuery<UserLevel> cq = session.getCriteriaBuilder().createQuery(UserLevel.class);	
		cq.from(UserLevel.class);
		return session.createQuery(cq).getResultList();				
	}

}
