package com.revature.madlibs.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	
    @Id
    @Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	private String first_name;
	private String last_name;
	private int dob;
    @OneToOne(targetEntity=UserLevel.class, cascade = CascadeType.ALL)
	private UserLevel userLevel;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date enroll_date;
	
	@OneToMany (targetEntity=CompletedStories.class, fetch=FetchType.LAZY)
	List<CompletedStories> myCompletedStories;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String first_name, String last_name, int dob, UserLevel userLevel,
			String email, Date enroll_date, List<CompletedStories> myCompletedStories) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.userLevel = userLevel;
		this.email = email;
		this.enroll_date = enroll_date;
		this.myCompletedStories = myCompletedStories;
	}
	

	public User(String first_name, String last_name, int dob, UserLevel userLevel, String email, Date enroll_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.userLevel = userLevel;
		this.email = email;
		this.enroll_date = enroll_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	public List<CompletedStories> getMyCompletedStories() {
		return myCompletedStories;
	}

	public void setMyCompletedStories(List<CompletedStories> myCompletedStories) {
		this.myCompletedStories = myCompletedStories;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob + ", userLevel=" + userLevel + ", email=" + email + ", enroll_date="
				+ enroll_date + "]";
	}
	

	
	
	
	
}
