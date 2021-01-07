package com.revature.madlibs.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;
import com.revature.madlibs.service.Utils;


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

//	@SuppressWarnings("unchecked")
	@Override
	public User insert(User user, Login login) {
		Session session = sf.getCurrentSession();
//		System.out.println("In UserDAO - insert");
		User singleUser = null;

		try {

			session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)" +
					" values( "+user.getDob() +",'"+ user.getEmail()+"',NOW(), '"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserLevel().getLevel_id()+");").executeUpdate();
			 
			 System.out.println("In UserDAO - insert: Back from User Write");
			 System.out.println("In UserDAO - insert: Attempting User Read");
			 
			 // String SQLgetUser =  // "select * from madlibs.madlibs.user_table where first_name = '"+user.getFirstName()+"';";
			 String SQLgetUser = "SELECT max(user_id) FROM madlibs.user_table;";
			 System.out.println("DB query = " + SQLgetUser);
			 
			 int maxUserId =  (int) session.createNativeQuery(SQLgetUser).getSingleResult();
			 System.out.println("Max = " + maxUserId);
			 
		 singleUser = (User) session.createNativeQuery(
					   "select * from madlibs.user_table where user_id=" + maxUserId +";").getSingleResult();
			 
			 System.out.println("returned user from userDAO" + singleUser);

			 			 
			 //			  returnUser = (User) session.createNativeQuery("SELECT * FROM madlibs.user_table \r\n"
//						+ "WHERE user_id = (\r\n"
//						+ "   SELECT MAX (user_id)\r\n"
//						+ "   FROM madlibs.user_table \r\n"
//						+ ");").getSingleResult();
			 
		//	session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '"+login.getUserName()+"','"+login.getPword()+"');").executeUpdate();

		//	session.update(login);
			

			//session.update(user);
//			 System.out.println("In UserDAO - insert: Attempting User Write");
			 
			 session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level)" +
					" values( "+user.getDob() +",'"+ user.getEmail()+"',NOW(), '"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserLevel().getLevel_id()+");").executeUpdate();
			 
//			 System.out.println("In UserDAO - insert: Back from User Write");
//			 System.out.println("In UserDAO - insert: Attempting User Read");
			 

	//		 String SQLgetUser = "SELECT max(user_id) FROM madlibs.user_table;";
//			 System.out.println("DB query = " + SQLgetUser);
			 
			 int maxUserId =  (int) session.createNativeQuery(SQLgetUser).getSingleResult();
//			 System.out.println("Max = " + maxUserId);
			 
//
//			 singleUser = new User(maxUserId, user.getFirstName(), user.getLastName(),
//					                          user.getDob(), user.getUserLevel(), user.getEmail() ); 
//			 
//					 System.out.println("returned user from userDAO" + singleUser);

//			 returnUser = (User) session.createNativeQuery("select * from madlibs.madlibs.user_table ut where first_name = '"+user.getFirstName()+"';").getSingleResult();


		 session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '"+login.getUserName()+"','"+login.getPword()+"',"+singleUser.getUser_id()+");").executeUpdate();
				 
		 			 

			 			 
		//	String encrypPword = Utils.encrypt(login.getPword(), login.getUserName());
//			session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '" 
//			                          + login.getUserName() +"','" + encrypPword +"'," + maxUserId+");").executeUpdate();

			System.out.println("login info from userDAO"+login);
			

			return singleUser;
			
			
			
			//session.update(user);
			
//			 session.createNativeQuery("insert into madlibs.user_table (dob, email, enroll_date, first_name, last_name, user_level, user_id)" +
//					" values( "+user.getDob() +",'"+ user.getEmail()+"',NOW(), '"+user.getFirstName()+"','"+user.getLastName()+"',"+user.getUserLevel().getLevel_id()+","select MAX(user.getUser_id())+1 from madlibs.user_table);".executeUpdate();
//
//			 session.createNativeQuery("SELECT * FROM madlibs.user_table \r\n"
//						+ "WHERE user_id = (\r\n"
//						+ "   SELECT MAX (user_id)\r\n"
//						+ "   FROM madlibs.user_table \r\n"
//						+ ");").getSingleResult();
			// returnUser = (User) session.createNativeQuery("select * from madlibs.user_table where first_name = '"+user.getFirstName()+"';").getSingleResult();
		//	 session.createNativeQuery("select * from madlibs.user_table where first_name = '"+user.getFirstName()+"';").getSingleResult();
			 			 
			 //			  returnUser = (User) session.createNativeQuery("SELECT * FROM madlibs.user_table \r\n"
//						+ "WHERE user_id = (\r\n"
//						+ "   SELECT MAX (user_id)\r\n"
//						+ "   FROM madlibs.user_table \r\n"
//						+ ");").getSingleResult();		
	//		System.out.println("returneduser from userDAO"+returnUser);
			//session.createNativeQuery("insert into madlibs.login(user_name, pword, user_user_id) values( '"+login.getUserName()+"','"+login.getPword()+"',"+returnUser.getUser_id()+");").executeUpdate();
	//		session.createNativeQuery("insert into madlibs.login(user_name, pword) values( '"+login.getUserName()+"','"+login.getPword()+"');").executeUpdate();

		//	session.update(login);
			

	//		System.out.println("login info from userDAO"+login);
			
	//		return returnUser;
		}  catch (Exception e) {
//			System.out.println("Bad User read back in insert");

			com.revature.madlibs.Logger.log.debug("insert User error: "+ e.getMessage());
		}
		
	}

	private Object select(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private int MAX(int user_id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
