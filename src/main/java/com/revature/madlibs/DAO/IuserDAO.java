package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.front.UpdateRegister;
import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

//This DAO layer interface enables Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

public interface IuserDAO {

	public List<User> getAllUsers();
	public User getUserById(int id);
	public User insert(User user, Login login);
	public User update(UpdateRegister updat);

}
