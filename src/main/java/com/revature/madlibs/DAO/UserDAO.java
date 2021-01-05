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
	public UserDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public UserDAO() {
		super();
	}

	@Override
	public User update(User user) {
		try {
			Session session = sf.getCurrentSession();
			session.update(user);
			return user;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("update User error: "+ e.getMessage());
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		try {
			Session session = sf.getCurrentSession();
			return session.get(User.class, id);
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("getUserById User error: "+ e.getMessage());
		}
		return null;
	}
	
	@Override
	public List<User> getAllUsers(){
		Session session = sf.getCurrentSession();
		try {
			CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
			cq.from(User.class);
			return session.createQuery(cq).getResultList();
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("getAllUsers User error: "+ e.getMessage());
		}
		return null;

	}

	@Override
	public User insert(User user) {
		Session session = sf.getCurrentSession();
		try {
			session.update(user);
			User returnUser = (User) session.createNativeQuery("SELECT * FROM user_table \r\n"
					+ "WHERE user_id = (\r\n"
					+ "   SELECT MAX (user_id)\r\n"
					+ "   FROM user_table \r\n"
					+ ");").getSingleResult();
			return returnUser;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert User error: "+ e.getMessage());
		}
		return null;
	}
}
