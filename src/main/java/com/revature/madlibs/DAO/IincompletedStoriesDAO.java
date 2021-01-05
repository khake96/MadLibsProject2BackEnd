package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;

public interface IincompletedStoriesDAO {
	
	public IncompleteStories selectById(int id);
	public List<IncompleteStories> findAll();
	public IncompleteStories selectByCategoryUserLevel(StoryCategory category, UserLevel level, int missingWordCount);

}
