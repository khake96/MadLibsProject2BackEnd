package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;

public interface IincompletedStoriesDAO {
	
	public void insert(IncompleteStories incompleteStory);
	
	public void update(IncompleteStories incompleteStory);

	//public IncompleteStories selectById(int id);
	
	public List<IncompleteStories> findAll();

	public IncompleteStories selectByCategoryUserLevel(StoryCategory category, UserLevel level);

}
