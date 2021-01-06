package com.revature.madlibs.models;

public class LoginCheck {
	
	private String userName;
	private String pword;
	
	public LoginCheck() {
		super();
	}

	public LoginCheck(String userName, String pword) {
		super();
		this.userName = userName;
		this.pword = pword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public String toString() {
		return "LoginCheck [userName=" + userName + ", pword=" + pword + "]";
	}
	
	
}
