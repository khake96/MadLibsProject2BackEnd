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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_table")
public class User {
	
    @Id
    @Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
    @Column(name="first_name", nullable=false)
	private String firstName;
    @Column(name="last_name", nullable=false)
	private String lastName;
    @Column(name="dob", nullable=false)
	private int dob;
    @ManyToOne(targetEntity=UserLevel.class, cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_level")
	@JsonBackReference
    private UserLevel userLevel;
    @Column(name="email", unique=true, nullable=false)
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name="enroll_date")
	private Date enrollDate;
	
	@OneToMany (targetEntity=CompletedStories.class, fetch=FetchType.EAGER)
	List<CompletedStories> myCompletedStories;
	
	public User() {
		super();
	}

	public User(int user_id, String firstName, String lastName, int dob, UserLevel userLevel,
			String email, Date enrollDate, List<CompletedStories> myCompletedStories) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.userLevel = userLevel;
		this.email = email;
		this.enrollDate = enrollDate;
		this.myCompletedStories = myCompletedStories;
	}
	
	public User(String firstName, String lastName, int dob, UserLevel userLevel, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.userLevel = userLevel;
		this.email = email;
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
		return enrollDate;
	}

	public void setEnroll_date(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	public List<CompletedStories> getMyCompletedStories() {
		return myCompletedStories;
	}

	public void setMyCompletedStories(List<CompletedStories> myCompletedStories) {
		this.myCompletedStories = myCompletedStories;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + firstName + ", last_name=" + lastName + ", dob=" + dob + ", userLevel=" + userLevel + ", email=" + email + ", enroll_date="
				+ enrollDate + "]";
	}
	

	
	
	
	
}
