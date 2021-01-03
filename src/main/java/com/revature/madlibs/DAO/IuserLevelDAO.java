package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.UserLevel;

public interface IuserLevelDAO {
	
	public void insert(UserLevel level);
		
		public void update(UserLevel level);

		public UserLevel selectById(int id);
		
		public List<UserLevel> findAll();

}
