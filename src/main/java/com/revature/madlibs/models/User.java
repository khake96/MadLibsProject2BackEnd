package com.revature.madlibs.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	
    @Id
    @Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_id;
	private String first_name;
	private String last_name;
	private Integer dob;
    @OneToOne(targetEntity=UserLevel.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "LEVEL_ID")
	private Integer level_id;
	private String email;
	private Timestamp enroll_date;
	
	
	public User(String first_name, String last_name, Integer dob, Integer level_id, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.level_id = level_id;
		this.email = email;
	}


	public User() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}

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

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}
	

	public Integer getLevel_id() {
		return level_id;
	}

	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Timestamp getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Timestamp enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		int result = 1;
		result = prime * result + dob;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enroll_date == null) ? 0 : enroll_date.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + level_id;
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
		if (level_id != other.level_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", dob=" + dob
				+ ", level_id=" + level_id + ", email=" + email + ", enroll_date=" + enroll_date + "]";
	} 
	
	
	
	
	
	
}
