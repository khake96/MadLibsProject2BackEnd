package com.revature.madlibs.service;

import java.util.List;

import com.revature.madlibs.DAO.StoryCategoryDAO;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;

public class ServiceImpl implements Service {

	StoryCategoryDAO storyCategoryDao = new StoryCategoryDAO();
	
	@Override
	public User userLogin(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoryCategory> getStoryCategories() {
		List<StoryCategory> categoryList = storyCategoryDao.findAll();
		return categoryList;
	}

	@Override
	public List<CompletedStories> getCompletedStories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IncompleteStories getOneIncompleteStory(StoryCategory category) {
		// TODO Auto-generated method stub
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

}
