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
<<<<<<< HEAD
    @Column(name="pword", nullable=false)
	private String pword;
    @OneToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn
=======
	private String password;
    @OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
>>>>>>> parent of cce3ef8... final version more or less
	private User user;
    
	public Login() {
		super();
	}

<<<<<<< HEAD
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public Login(int loginId, String userName, String pword, User user) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.pword = pword;
		this.user = user;
	}

	public Login(String userName, String pword, User user) {
=======
	public Login(String userName, String password, User user) {
>>>>>>> parent of cce3ef8... final version more or less
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
<<<<<<< HEAD
		return "Login [loginId=" + loginId + ", userName=" + userName + ", pword=" + pword + ", user=" + user + "]";
=======
		return "Login [userName=" + userName + ", password=" + password + ", user=" + user + "]";
>>>>>>> parent of cce3ef8... final version more or less
	}

//	@Override
//	public String toString() {
//		return "Login [userName=" + userName + ", password= *****" + ", user=" + user + "]";
//	}
// 
}
