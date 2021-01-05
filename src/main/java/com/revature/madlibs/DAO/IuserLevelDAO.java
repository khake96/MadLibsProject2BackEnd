package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.UserLevel;

public interface IuserLevelDAO {

	public List<UserLevel> findAll();
	public UserLevel selectById(int id);

}
