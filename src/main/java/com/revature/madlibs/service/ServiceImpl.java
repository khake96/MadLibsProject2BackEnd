package com.revature.madlibs.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.madlibs.DAO.IcompletedStoriesDAO;
import com.revature.madlibs.DAO.IincompletedStoriesDAO;
import com.revature.madlibs.DAO.IloginDAO;
import com.revature.madlibs.DAO.IstoryCategoryDAO;
import com.revature.madlibs.DAO.IuserDAO;
import com.revature.madlibs.DAO.IuserLevelDAO;
import com.revature.madlibs.DAO.LoginDAO;
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
	private IuserLevelDAO userLevelDAO;
	private IloginDAO loginDAO;
	private IserviceLogic serviceLogic;
	
	@Autowired
	public ServiceImpl(IstoryCategoryDAO storyCategoryDao, IcompletedStoriesDAO completedStoriesDAO,
			IincompletedStoriesDAO incompletedStoriesDAO, IuserDAO userDAO, IuserLevelDAO userLevelDAO,
			IloginDAO loginDAO, IserviceLogic serviceLogic) {
		super();
		this.storyCategoryDao = storyCategoryDao;
		this.completedStoriesDAO = completedStoriesDAO;
		this.incompletedStoriesDAO = incompletedStoriesDAO;
		this.userDAO = userDAO;
		this.userLevelDAO = userLevelDAO;
		this.loginDAO = loginDAO;
		this.serviceLogic = serviceLogic;
	}

	@Override
	public User userLogin(Login login) {
		User user = null;
		if(serviceLogic.isLoginValid(login)) {
			loginDAO.validate(login.getUserName(), login.getPassword());
			user = loginDAO.get(login).getUser();
			return user;
		} else return user;
	}

	@Override
	public User registerUser(User user) {
		if(serviceLogic.isUserValid(user)) {
			userDAO.insert(user);
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoryCategory> getStoryCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompletedStories> getCompletedStories1() {
		 List<CompletedStories> list = completedStoriesDAO.findAll();
		return  list;
	}

	@Override
	public IncompleteStories getOneIncompleteStory(StoryCategory category, UserLevel userLevel) {
//		 <IncompleteStories> list = incompletedStoriesDAO.selectByCategoryUserLevel(category, userLevel);
//			return  list;
		return null;
	}

	@Override
	public boolean insertCompletedStory(CompletedStories completed) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateUpvoteCounts(CompletedStories upVotedStory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Login> getAllLogins() {
		List<Login> list = loginDAO.findAllLogins();
		return  list;
	}

	@Override
	public Login findLoginById(int id) {
		System.out.println("Inside Service - findLoginById");
		Login login = loginDAO.findLoginById(id);
		System.out.println("login = " + login);
		
		return login;
	}

}
