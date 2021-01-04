package com.revature.madlibs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private int loginId;
    @Column(name = "user_name", unique=true, nullable=false)
	private String userName;
    @Column(name="pword", nullable=false)
	private String pword;
    @OneToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn
	private User user;
    
	public Login() {
		super();
	}

	public Login(String userName, String pword, User user) {
		super();
		this.userName = userName;
		this.pword = pword;
		this.user = user;
	}

	public Login(String userName, String pword) {
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

	public String getPassword() {
		return pword;
	}

	public void setPassword(String pword) {
		this.pword = pword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password= *****" + ", user=" + user + "]";
	}
    
    
	
	
}
