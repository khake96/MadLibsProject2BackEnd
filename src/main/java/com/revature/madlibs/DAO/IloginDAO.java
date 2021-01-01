package com.revature.madlibs.DAO;

import com.revature.madlibs.models.Login;

public interface IloginDAO {
		
	public void insert(Login login);
		
	public void update(Login login);

	public Login selectById(String username);
		
	public boolean validate(String uName, String password);
	
	public Login get(Login login);

}
