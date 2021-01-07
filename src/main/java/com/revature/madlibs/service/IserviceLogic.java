package com.revature.madlibs.service;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.User;

public interface IserviceLogic {
	
	//public boolean isValidUser(User user);
	public boolean isValidLogin(Login login);
	public boolean isValidCompletedStory(CompletedStories complete);
	public boolean isValidUser(User user);

}
