package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.front.UpdateRegister;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.User;

public interface IuserDAO {

	//public User update(NewUser nuser);
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User insert(User user, Login login);
	//public User update(User user);
	public User update(UpdateRegister updat);

}
