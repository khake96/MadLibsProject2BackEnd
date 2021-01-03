package com.revature.madlibs.service;

import java.util.List;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;

public interface Iservice {
	
	public User userLogin(Login login);
	public User registerUser(User user, Login login);
	public User updateUser(User user, Login login);
	public List<StoryCategory> getStoryCategories();
	public List<CompletedStories> getCompletedStories();
	public IncompleteStories getOneIncompleteStory(StoryCategory category, UserLevel userLevel);
	public Boolean insertCompletedStory(CompletedStories completed);
	public CompletedStories updateUpvoteCounts(CompletedStories upVotedStory);

}
