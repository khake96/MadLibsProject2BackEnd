package com.revature.madlibs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;

@Service
public class ServiceLogic implements IserviceLogic {
	
	
	@Autowired
	public ServiceLogic() {
		super();
	}

	@Override
	public boolean isLoginValid(Login login) {
		// TODO Auto-generated method stub
		// if(login.getUserName().length() > 7, etc.
		return true;
	}

	@Override
	public boolean isUserValid(User user) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isStoryCategoryValid(StoryCategory storyCategory) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isIncompleteStoryValid(IncompleteStories incompleteStory) {
		// TODO Auto-generated method stub
		return true;
	}

}
