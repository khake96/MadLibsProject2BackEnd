package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

public interface IuserDAO {

	public User update(User user);
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User insert(User user, Login login);

}
