package com.revature.madlibs.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

@Service
public class ServiceLogic implements IserviceLogic {

	@Override
	public boolean isValidUser(User user) {
		boolean isValid = false;
		String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String name = "^[a-zA-Z]+(\\s[a-zA-Z]+)?{1,30}";
		if(user.getEmail().matches(email)) {
			System.out.println("email");
			if(user.getFirstName().matches(name)) {
				System.out.println("first name");
				if(user.getLastName().matches(name)) {
					System.out.println("last name");
					if(user.getDob()>1900 && 2015>user.getDob()) {
						System.out.println("DOB");
						if(user.getUserLevel().getLevel_id()>0 && user.getUserLevel().getLevel_id()<5) {
							System.out.println("User Level");
							isValid=true;
						} else System.out.println ("user_level error: " + user.getUserLevel());
					} else System.out.println ("DOB error: " + user.getDob());
				} else System.out.println ("last name error: " + user.getLastName());
			} else System.out.println ("first name error: " + user.getFirstName());
		} else System.out.println ("e-mail error: " + user.getEmail());
		return isValid;
		}


	@Override
	public boolean isValidLogin(Login login) {
		boolean isValid = false;
        if(login.getUserName().length()>1 && login.getUserName().length()<50) {
    		if(login.getPword().length()>7 && login.getPword().length()<50) {
    			if(login.getUser().getFirstName().length()>1) {
    				isValid = true;
    			} else System.out.println ("login user error: " + login.getUser().toString());
    		} else System.out.println ("password error: ************");
        } else System.out.println ("UserName error: " + login.getUserName().toString());

		return isValid;
	}

	@Override
	public boolean isValidCompletedStory(CompletedStories complete) {
		boolean isValid = false;
		if(complete.getCompletedStory().length()>30 && complete.getCompletedStory().length()<410000) {
			if(this.isValidUser(complete.getCompleter())) {
				if(complete.getUpvoteCount()>=0) {
					if(complete.getParentStory().getAuthorBook().length()<1) {
						isValid = true;
					} System.out.println ("completed story error parent story: " + complete);	
				} System.out.println ("completed story error upvote count error: " + complete);						
			} System.out.println ("completed story error invalid user: " + complete);
		} System.out.println ("completed story error invalid length: " + complete);
		return isValid;
	}
}
