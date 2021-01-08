package com.revature.madlibs.models;

public class NewUser {

	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private int yob;    //dob
	private int playerLevel;   //userLevel
	private String password1;   //pword
	private String password2;
//	public NewUser(String firstName, String lastName, String email, int yob, int playerLevel) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.yob = yob;
//		this.playerLevel = playerLevel;
//	}
	
	
	public NewUser() {
		super();
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	public int getPlayerLevel() {
		return playerLevel;
	}
	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public NewUser(String userName, String firstName, String lastName, String email, int yob, int playerLevel,
			String password1, String password2) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.yob = yob;
		this.playerLevel = playerLevel;
		this.password1 = password1;
		this.password2 = password2;
	}
	@Override
	public String toString() {
		return "NewUser [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", yob=" + yob + ", playerLevel=" + playerLevel + ", password1=" + password1 + ", password2="
				+ password2 + "]";
	} 
}
