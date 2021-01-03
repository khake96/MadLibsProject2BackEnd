package com.revature.madlibs.DAO;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;

public interface IincompletedStoriesDAO {
	
	public void insert(IncompleteStories incompleteStory);
	
	public void update(IncompleteStories incompleteStory);

	public IncompleteStories selectById(int id);

	public IncompleteStories findStory(StoryCategory sc, UserLevel lvl);

}
