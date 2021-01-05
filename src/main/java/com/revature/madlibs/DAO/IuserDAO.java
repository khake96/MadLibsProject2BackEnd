package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.User;

public interface IuserDAO {

	public User insert(User user);
	public User update(User user);
	public List<User> getAllUsers();
	public User getUserById(int id);

}
