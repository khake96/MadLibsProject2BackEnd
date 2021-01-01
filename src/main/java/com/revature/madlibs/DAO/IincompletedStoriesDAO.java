package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.IncompleteStories;

public interface IincompletedStoriesDAO {
	
	public void insert(IncompleteStories incompleteStory);
	
	public void update(IncompleteStories incompleteStory);

	public IncompleteStories selectById(int id);
	
	public List<IncompleteStories> findAll();

}
