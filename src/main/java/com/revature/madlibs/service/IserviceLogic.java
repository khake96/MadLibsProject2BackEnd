package com.revature.madlibs.service;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;

public interface IserviceLogic {
	
	public boolean isLoginValid(Login login);
	public boolean isUserValid(User user);
	public boolean isStoryCategoryValid(StoryCategory storyCategory);
	public boolean isIncompleteStoryValid(IncompleteStories incompleteStory);

}
