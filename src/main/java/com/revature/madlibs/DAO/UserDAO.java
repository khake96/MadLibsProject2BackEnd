package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.madlibs.front.UpdateRegister;
//import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;
import com.revature.madlibs.service.Utils;

//This DAO layer class implements an interface in order to enable Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

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
	public User update(UpdateRegister upreg) {
		User singleUser = null;
		try {
			Session session = sf.getCurrentSession();
			
			
			String updateSQL = "update madlibs.user_table set first_name = '"+upreg.getFirstName()+"',  last_name = '"+upreg.getLastName()+
			"', dob = "+upreg.getYob()+", email = '"+upreg.getEmail()+"', user_level = "+upreg.getPlayerLevel()+" where user_id = 1;"; 
				//	+ ""+upreg.getUser_id()+");";
			
			    System.out.println("updated SQL query :  "+updateSQL);
			
			 session.createNativeQuery(updateSQL).executeUpdate();
			return singleUser;
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
	public User insert(User user, Login login) {
		Session session = sf.getCurrentSession();
		User singleUser = null;

		try {	 
			session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)" +
					" values( "+user.getDob() +",'"+ user.getEmail()+"',NOW(), '"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserLevel().getLevel_id()+");").executeUpdate();
			 String SQLgetUser = "SELECT max(user_id) FROM madlibs.user_table;"; 
			 int maxUserId =  (int) session.createNativeQuery(SQLgetUser).getSingleResult();
			 singleUser = new User(maxUserId, user.getFirstName(), user.getLastName(),
					                          user.getDob(), user.getUserLevel(), user.getEmail() ); 
			 String encrypPword = Utils.encrypt(login.getPword(), login.getUserName());
			session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '" 
			                          + login.getUserName() +"','" + encrypPword +"'," + maxUserId+");").executeUpdate();
			return singleUser;
		} catch (Exception e) {
			com.revature.madlibs.Logger.log.debug("insert User error: "+ e.getMessage());
		}
		return singleUser;
	}

	
}