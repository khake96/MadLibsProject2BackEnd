package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
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
	
//	
//	List<IncompleteStories> storyList = session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)" +
//			" values( " + User.         + " and category = " + category.getCategoryId() +
//			" and missing_word_count = "+ missingWordCount +";").getResultList();
//	
//	insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)
//	values (1920, 'jonn.smith@email.com', NOW(), 'John', 'Smith', 4),
//

	@Override
	public User insert(User user, Login login) {
		Session session = sf.getCurrentSession();
		 User returnUser=null;
		try {
			//session.update(user);
			
			 session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)" +
					" values( "+user.getDob() +",'"+ user.getEmail()+"',NOW(), '"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserLevel().getLevel_id()+");").executeUpdate();

			 
			 returnUser = (User) session.createNativeQuery("select * from madlibs.user_table where first_name = '"+user.getFirstName()+"';").getSingleResult();

			 			 
			 //			  returnUser = (User) session.createNativeQuery("SELECT * FROM madlibs.user_table \r\n"
//						+ "WHERE user_id = (\r\n"
//						+ "   SELECT MAX (user_id)\r\n"
//						+ "   FROM madlibs.user_table \r\n"
//						+ ");").getSingleResult();		
			System.out.println("returneduser from userDAO"+returnUser);
			session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '"+login.getUserName()+"','"+login.getPword()+"',"+returnUser.getUser_id()+");").executeUpdate();

		//	session.update(login);
			

			System.out.println("login info from userDAO"+login);
			
			return returnUser;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert User error: "+ e.getMessage());
		}
		return returnUser;
	}
}
