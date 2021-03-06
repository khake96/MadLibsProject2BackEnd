package com.revature.madlibs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.madlibs.front.UpdateRegister;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.User;
import com.revature.madlibs.models.UserLevel;

//This Literary Madlibs interface allows for propert Spring Framework implementation

@Service
public interface Iservice {
	
	public User userLogin(Login login);
	public NewUser updateUser(NewUser nuser);
	public List<StoryCategory> getStoryCategories();
	public List<CompletedStories> getCompletedStories1();
	public List<Login> getAllLogins();
	public CompletedStories insertCompletedStory(CompletedStories completed);
	public CompletedStories updateUpvoteCounts(CompletedStories upVotedStory);
	public List<UserLevel> findAllUserLevels();
	public IncompleteStories getOneIncompleteStory(StoryCategory category, UserLevel userLevel, int missingWordCount);
	public CompletedStories getLastCompletedStory();
	public User registerUser(NewUser newUser);
	public User registerUser(User user, Login login);
	public User getUserById(int id);
	public IncompleteStories getOneIncompleteStoryById(int id);
	public User updateUser(UpdateRegister updat);
}
