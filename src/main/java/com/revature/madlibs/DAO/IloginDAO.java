package com.revature.madlibs.DAO;

import java.util.List;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;

public interface IloginDAO {
		
	public void insert(Login login);		
	public void update(Login login);
	public Login selectByName(String username);		
	public User validate(String uName, String password);	
	public Login get(Login login);
	public List<Login> findAllLogins();

}
