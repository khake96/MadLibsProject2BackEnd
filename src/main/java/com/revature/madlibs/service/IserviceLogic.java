package com.revature.madlibs.service;


import org.springframework.stereotype.Service;
import com.revature.madlibs.front.UpdateRegister;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

//This Literary Madlibs interface allows for propert Spring Framework implementation

@Service
public interface IserviceLogic {
	
	public boolean isValidLogin(Login login);
	public boolean isValidCompletedStory(CompletedStories complete);
	public boolean isValidUser(User user);
	public boolean isValidUser1(UpdateRegister updat);

}
