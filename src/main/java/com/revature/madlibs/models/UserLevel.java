package com.revature.madlibs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This Literary Madlibs model class enables Spring Framework tools and ORM 
//to abstract the Hibernate ORM from us. 

@Entity
@Table(name = "user_level")
public class UserLevel {
	
    @Id
    @Column(name = "LEVEL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int level_id;
    @Column(name = "level_desc")
	private String levelDesc;
	
	public UserLevel(int level_id, String levelDesc) {
		super();
		this.level_id = level_id;
		this.levelDesc = levelDesc;
	}
	
	

	public UserLevel(String levelDesc) {
		super();
		this.levelDesc = levelDesc;
	}



	public UserLevel() {
		super();
	}


	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public String getLevel_desc() {
		return levelDesc;
	}

	public void setLevel_desc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((levelDesc == null) ? 0 : levelDesc.hashCode());
		result = prime * result + level_id;
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
		UserLevel other = (UserLevel) obj;
		if (levelDesc == null) {
			if (other.levelDesc != null)
				return false;
		} else if (!levelDesc.equals(other.levelDesc))
			return false;
		if (level_id != other.level_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserLevel [level_id=" + level_id + ", level_desc=" + levelDesc + "]";
	}


}
