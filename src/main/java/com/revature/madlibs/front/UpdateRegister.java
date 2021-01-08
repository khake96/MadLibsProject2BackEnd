package com.revature.madlibs.front;

public class UpdateRegister {
	
	
	private int user_id;
	private String firstName;
	private String lastName;
	private String email;
	private int yob;    
	private int playerLevel;
	
	
	public UpdateRegister(int user_id, String firstName, String lastName, String email, int yob, int playerLevel) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.yob = yob;
		this.playerLevel = playerLevel;
	}
	public UpdateRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	@Override
	public String toString() {
		return "UpdateRegister [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", yob=" + yob + ", playerLevel=" + playerLevel + "]";
	}  
	
	
	
}
