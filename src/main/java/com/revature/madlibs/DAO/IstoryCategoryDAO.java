package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.StoryCategory;

public interface IstoryCategoryDAO {
	
	public void insert(StoryCategory storyCategory);

	public StoryCategory selectById(int id);
	
	public List<StoryCategory> findAll();

}
