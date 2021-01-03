package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.CompletedStories;

public interface IcompletedStoriesDAO {
	
	public CompletedStories insert(CompletedStories completedStory);
	
	public CompletedStories update(CompletedStories completedStory);

	public CompletedStories selectById(int id);
	
	public List<CompletedStories> findAll();
}
