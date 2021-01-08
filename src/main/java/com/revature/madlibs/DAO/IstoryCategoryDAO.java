package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.StoryCategory;

//This DAO layer interface enables Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

public interface IstoryCategoryDAO {

	public List<StoryCategory> findAll();

}
