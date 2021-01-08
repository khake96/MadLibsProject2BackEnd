package com.revature.madlibs.service;

//import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;

import com.revature.madlibs.front.UpdateRegister;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.Login;
//import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.User;

// This Literary Madlibs Service-level logic class is used to test the validity of the objects passing through
// the service layer.

@Service
public class ServiceLogic implements IserviceLogic {

	// Checks user objects for: 
	// valid email, in the proper format
	// first and last name with only letters and spaces and no longer than 30 characters
	// a valid DOB
	// a valid user level object
	@Override
	public boolean isValidUser(User user) {
		boolean isValid = false;
		String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String name = "^[a-zA-Z]+(\\s[a-zA-Z]+)?{1,30}";
		if(user.getEmail().matches(email)) {
			if(user.getFirstName().matches(name)) {
				if(user.getLastName().matches(name)) {
					if(user.getDob()>1900 && 2015>user.getDob()) {
						if(user.getUserLevel().getLevel_id()>0 && user.getUserLevel().getLevel_id()<5) {
							isValid=true;
						} else System.out.println ("user_level error: " + user.getUserLevel());
					} else System.out.println ("DOB error: " + user.getDob());
				} else System.out.println ("last name error: " + user.getLastName());
			} else System.out.println ("first name error: " + user.getFirstName());
		} else System.out.println ("e-mail error: " + user.getEmail());
		return isValid;
		}

	// Checks login objects for: 
	// username between 1 and 50 characters
	// password length between 3 and 50 characters
	@Override
	public boolean isValidLogin(Login login) {
		boolean isValid = false;
		try {
	        if(login.getUserName().length()>1 && login.getUserName().length()<50) {
	    		if(login.getPword().length()>3 && login.getPword().length()<50) {
	    				isValid = true;
	    		} else com.revature.madlibs.Logger.log.debug("Password error in Business Logic: ");
	        } else com.revature.madlibs.Logger.log.debug ("UserName error: " + login.getUserName().toString());
		} catch (NullPointerException e) {
			com.revature.madlibs.Logger.log.debug("Login error in Business Logic: "+ e.getMessage());
		}
		return isValid;
	}

	// Checks CompletedStory objects for: 
	// story length between 30 and 10000 characters
	// valid upVote count
	// That the author element is not empty
	@Override
	public boolean isValidCompletedStory(CompletedStories complete) {
		boolean isValid = false;
		if(complete.getCompletedStory().length()>30 && complete.getCompletedStory().length()<410000) {
				if(complete.getUpvoteCount()>=0) {
					if(complete.getParentStory().getAuthorBook().length()<1) {
						isValid = true;
					} System.out.println ("completed story error parent story: " + complete);	
				} System.out.println ("completed story error upvote count error: " + complete);						
			} System.out.println ("completed story error invalid user: " + complete);
		System.out.println("completed story error invalid length: " +complete);
		return isValid;
	}

	@Override
	public boolean isValidUser1(UpdateRegister update) {
		return false;
	}}

