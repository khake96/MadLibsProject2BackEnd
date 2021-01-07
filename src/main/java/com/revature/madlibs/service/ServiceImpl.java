package com.revature.madlibs.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.madlibs.DAO.IcompletedStoriesDAO;
import com.revature.madlibs.DAO.IincompletedStoriesDAO;
import com.revature.madlibs.DAO.IloginDAO;
import com.revature.madlibs.DAO.IstoryCategoryDAO;
import com.revature.madlibs.DAO.IuserDAO;
import com.revature.madlibs.DAO.IuserLevelDAO;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;

@Service
public class ServiceImpl implements Iservice {

	private IstoryCategoryDAO storyCategoryDAO;
	private IcompletedStoriesDAO completedStoriesDAO;
	private IincompletedStoriesDAO incompletedStoriesDAO;
	private IuserDAO userDAO;
	private IuserLevelDAO userLevelDAO;
	private IloginDAO loginDAO;
	private IserviceLogic serviceLogic;
	
	@Autowired
	public ServiceImpl(IstoryCategoryDAO storyCategoryDAO, IcompletedStoriesDAO completedStoriesDAO,
			IincompletedStoriesDAO incompletedStoriesDAO, IuserDAO userDAO, IuserLevelDAO userLevelDAO,
			IloginDAO loginDAO, IserviceLogic serviceLogic) {
		super();
		this.storyCategoryDAO = storyCategoryDAO;
		this.completedStoriesDAO = completedStoriesDAO;
		this.incompletedStoriesDAO = incompletedStoriesDAO;
		this.userDAO = userDAO;
		this.userLevelDAO = userLevelDAO;
		this.loginDAO = loginDAO;
		this.serviceLogic = serviceLogic;
	}

	@Override
	public com.revature.madlibs.models.User userLogin(Login login) {
		User user = null;
		String pword = "";
		if(serviceLogic.isValidLogin(login)) {
			pword = Utils.encrypt(login.getPword(), login.getUserName());
			login.setPword(pword);
			user = loginDAO.validate(login.getUserName(), login.getPword());
			return user;
		} else return user;
	}

	@Override
	public User registerUser(NewUser newUser) {
		User user = new User(newUser.getFirstName(), newUser.getLastName(), newUser.getYob(), new UserLevel(newUser.getPlayerLevel(), ""), newUser.getEmail());
		Login login = new Login(newUser.getUserName(), newUser.getPassword1());
		
//			login.setUserName(newUser.getUserName());
//			login.setPword(newUser.getPassword1());
//			
//			user.setFirstName(newUser.getFirstName());
//			user.setLastName(newUser.getLastName());
//			user.setEmail(newUser.getEmail());
//			user.setDob(newUser.getYob());
//			
//			user.setUserLevel(new UserLevel(newUser.getPlayerLevel(), ""));
//		
	//		user.setMyCompletedStories(null);
			

		if(serviceLogic.isValidUser(user)) {
			
			System.out.println("in ServiceImpl"+user);
			
			
			
			userDAO.insert(user, login);
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		if(serviceLogic.isValidUser(user)) {
			userDAO.update(user);
		}
		return user;
	}	@Override
	public List<UserLevel> findAllUserLevels() {
		List<UserLevel> ulList = userLevelDAO.findAll();
		return ulList;
	}

	@Override
	public List<StoryCategory> getStoryCategories() {
		List<StoryCategory> list = storyCategoryDAO.findAll();
		return list;
	}

	@Override
	public List<CompletedStories> getCompletedStories1() {
		 List<CompletedStories> list = completedStoriesDAO.findAll();
		return  list;
	}

	@Override
	public List<Login> getAllLogins() {
		List<Login> list = loginDAO.findAllLogins();
		return  list;
	}
	

	@Override
	public IncompleteStories getOneIncompleteStoryById(int id) {
		 IncompleteStories list = incompletedStoriesDAO.selectById(id);
		return  list;
	}

	@Override
	public CompletedStories insertCompletedStory(CompletedStories completed) {
		CompletedStories story = completedStoriesDAO.insert(completed);
		return story;
	}

	@Override
	public CompletedStories updateUpvoteCounts(CompletedStories upVotedStory) {
		completedStoriesDAO.update(upVotedStory);
		int voteCount =upVotedStory.getUpvoteCount();
		upVotedStory.setUpvoteCount(voteCount);
		return upVotedStory;
	}


	@Override
	public IncompleteStories getOneIncompleteStory(StoryCategory category, UserLevel userLevel, int missingWordCount) {
		 IncompleteStories list = incompletedStoriesDAO.selectByCategoryUserLevel(category, userLevel, missingWordCount);
			return  list;
	}

	@Override
	public CompletedStories getLastCompletedStory() {
		 CompletedStories lastIn = completedStoriesDAO.getLastIn();
		return lastIn;
	}

	@Override
	public User registerUser(User user, Login login) {
		if(serviceLogic.isValidUser(user)) {
			userDAO.insert(user, login);
		}
		return user;
	}
	
}
