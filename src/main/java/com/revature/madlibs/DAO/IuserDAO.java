package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.User;

public interface IuserDAO {
	
	public void insert(User user);
	
	public void update(User user);

	public User selectById(int id);
	
	public List<User> findAll();

}
