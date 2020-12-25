package com.revature.madlibs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {
	
    @Id
    @Column(name = "LOGIN_ID")
	private String userName;
	private String password;
    @OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	private User user;
    
	public Login() {
		super();
	}

	public Login(String userName, String password, User user) {
		super();
		this.userName = userName;
		this.password = password;
		this.user = user;
	}

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", user=" + user + "]";
	}
    
    
	
	
}
