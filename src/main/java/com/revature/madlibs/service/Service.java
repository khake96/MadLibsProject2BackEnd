package com.revature.madlibs.service;

import java.util.List;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;

public interface Service {
	
	public User userLogin(Login login);
	public User registerUser(User user);
	public User updateUser(User user);
	public List<StoryCategory> getStoryCategories();
	public List<CompletedStories> getCompletedStories();
	public IncompleteStories getOneIncompleteStory(StoryCategory category);
	public boolean insertCompletedStory(CompletedStories completed);
	public void updateUpvoteCounts(CompletedStories upVotedStory);

}
