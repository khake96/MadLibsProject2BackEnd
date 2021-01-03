package com.revature.madlibs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.madlibs.utils.Utils;
import com.revature.madlibs.DAO.IcompletedStoriesDAO;
import com.revature.madlibs.DAO.IincompletedStoriesDAO;
import com.revature.madlibs.DAO.IloginDAO;
import com.revature.madlibs.DAO.IstoryCategoryDAO;
import com.revature.madlibs.DAO.IuserDAO;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;

@Service
public class ServiceImpl implements Iservice {

	private IstoryCategoryDAO storyCategoryDao;
	private IcompletedStoriesDAO completedStoriesDAO;
	private IincompletedStoriesDAO incompletedStoriesDAO;
	private IuserDAO userDAO;
//	private IuserLevelDAO userLevelDAO;
	private IloginDAO loginDAO;
	private IserviceLogic serviceLogic;
	
	@Autowired
	public ServiceImpl(IstoryCategoryDAO storyCategoryDao, IcompletedStoriesDAO completedStoriesDAO,
			IincompletedStoriesDAO incompletedStoriesDAO, IuserDAO userDAO, 
			IloginDAO loginDAO, IserviceLogic serviceLogic) {
		super();
		this.storyCategoryDao = storyCategoryDao;
		this.completedStoriesDAO = completedStoriesDAO;
		this.incompletedStoriesDAO = incompletedStoriesDAO;
		this.userDAO = userDAO;
//		this.userLevelDAO = userLevelDAO;
		this.loginDAO = loginDAO;
		this.serviceLogic = serviceLogic;
	}

	@Override
	public User userLogin(Login login) {
		User user = null;
		String password = login.getPassword();
		String userName = login.getUserName();
		if(serviceLogic.isLoginValid(login)) {
			String encrypted = Utils.encrypt(password, userName);
			login.setPassword(encrypted);
			loginDAO.validate(login.getUserName(), login.getPassword());
			user = loginDAO.get(login).getUser();
			return user;
		} else return user;
	}

	@Override
	public User registerUser(User user, Login login) {
		String password = login.getPassword();
		String userName = login.getUserName();
		if(serviceLogic.isUserValid(user)) {
			String encrypted = Utils.encrypt(password, userName);
			login.setPassword(encrypted);
			userDAO.insert(user);
			loginDAO.insert(login);
		}
		return user;
	}

	@Override
	public User updateUser(User user, Login login) {
		String password = login.getPassword();
		String userName = login.getUserName();
		if(serviceLogic.isUserValid(user)) {
			String encrypted = Utils.encrypt(password, userName);
			login.setPassword(encrypted);
			userDAO.update(user);
			loginDAO.insert(login);
		}
		return user;
	}

	@Override
	public List<StoryCategory> getStoryCategories() {
		List<StoryCategory> storyList = storyCategoryDao.findAll();
		return storyList;
	}

	@Override
	public List<CompletedStories> getCompletedStories() {
		List<CompletedStories> storyList = completedStoriesDAO.findAll();
		return storyList;
	}

	@Override
	public IncompleteStories getOneIncompleteStory(StoryCategory category, UserLevel userLevel) {
		IncompleteStories story = incompletedStoriesDAO.findStory(category, userLevel);
		return story;
	}

	@Override
	public Boolean insertCompletedStory(CompletedStories completed) {
		Boolean result = false; 
		try {
			completedStoriesDAO.insert(completed);
			result = true;
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	@Override
	public CompletedStories updateUpvoteCounts(CompletedStories upVotedStory) {
		CompletedStories readBack = completedStoriesDAO.update(upVotedStory);
		return readBack;
	}


	
	
}
