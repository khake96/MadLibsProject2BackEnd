package com.revature.madlibs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.UserLevel;

@Repository
@Transactional
public class UserLevelDAO implements IuserLevelDAO{

	private SessionFactory sf;    
	
	@Autowired
	public UserLevelDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public UserLevelDAO() {
		super();
	}

	public void update(UserLevel level) {
		try {
			Session session =  sf.getCurrentSession();      
		    session.merge(level);     
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("update UserLevel error: "+ e.getMessage());
		}

	}

	@Override
	public UserLevel selectById(int id) {
		try {
			Session session =  sf.getCurrentSession();
			UserLevel level = session.get(UserLevel.class, id);	
			return level;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("selectById UserLevel error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<UserLevel> findAll(){
		try {
			Session session =  sf.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<UserLevel> list = session.createQuery("FROM UserLevel").list();	
			return list;	
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("findAll UserLevel error: "+ e.getMessage());
		}
		return null;
	}
}

