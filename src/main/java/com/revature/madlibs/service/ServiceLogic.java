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
		String name = "^[a-zA-Z]+(\\s[a-zA-Z]+)?$";
		if(user.getEmail().matches(email)) {
			if(user.getFirstName().matches(name)) {
				if(user.getLastName().matches(name)) {
					if(user.getDob()>1900 && 2015>user.getDob()) {
						if(user.getUserLevel().getLevel_id()>0 || user.getUserLevel().getLevel_id()<5) {
							isValid=true;
						} else com.revature.madlibs.Logger.log.debug("user_level error: " + user.getUserLevel());
					} else com.revature.madlibs.Logger.log.debug("DOB error: " + user.getDob());
				} else com.revature.madlibs.Logger.log.debug("last name error: " + user.getLastName());
			} else com.revature.madlibs.Logger.log.debug("first name error: " + user.getFirstName());
		} else com.revature.madlibs.Logger.log.debug("e-mail error: " + user.getEmail());
		return isValid;
		}


	@Override
	public boolean isValidLogin(Login login) {
		boolean isValid = false;
        Pattern patt = Pattern.compile("[\\s]"); 
		if(login.getPword().length()>7 || login.getPword().length()<50) {
			if(patt.matcher(login.getUserName()) == null) {
				isValid = true;
			} else com.revature.madlibs.Logger.log.debug("login error: " + login.getUserName());
		} else com.revature.madlibs.Logger.log.debug("e-mail error: ************");
		return isValid;
	}

	@Override
	public boolean isValidCompletedStory(CompletedStories complete) {
		boolean isValid = false;
		if(complete.getCompletedStory().length()<40 || complete.getCompletedStory().length()>410000) {
			if(this.isValidUser(complete.getCompleter())) {
				if(complete.getUpvoteCount()<0) {
						isValid = true;
				} com.revature.madlibs.Logger.log.debug("completed story error: " + complete);
			} com.revature.madlibs.Logger.log.debug("completed story error: " + complete);
		}
		return isValid;
	}
	
	

}
