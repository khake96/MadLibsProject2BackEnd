package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.UserLevel;

//This DAO layer interface enables Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

public interface IuserLevelDAO {

	public List<UserLevel> findAll();
	public UserLevel selectById(int id);

}
