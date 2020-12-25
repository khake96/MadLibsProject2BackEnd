package com.revature.madlibs.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//    @OneToOne(targetEntity=UserLevel.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "LEVEL_ID")
	private int story_level_id;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date enroll_date;
	
	
	public User(String first_name, String last_name, int dob, int level_id, String email, Date enroll_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.story_level_id = level_id;
		this.email = email;
		this.enroll_date=enroll_date;
	}
	
	


	public User() {
		super();
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
	

	public int getLevel_id() {
		return story_level_id;
	}

	public void setLevel_id(int level_id) {
		this.story_level_id = level_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dob;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enroll_date == null) ? 0 : enroll_date.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + story_level_id;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dob != other.dob)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enroll_date == null) {
			if (other.enroll_date != null)
				return false;
		} else if (!enroll_date.equals(other.enroll_date))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (story_level_id != other.story_level_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob
				+ ", level_id=" + story_level_id + ", email=" + email + ", enroll_date=" + enroll_date + "]";
	} 
	
	
	
	
	
	
}