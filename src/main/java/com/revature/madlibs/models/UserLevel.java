package com.revature.madlibs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLevel {
	
	private int level_id;
	private String level_desc;
	
	public UserLevel(int level_id, String level_desc) {
		super();
		this.level_id = level_id;
		this.level_desc = level_desc;
	}

	public UserLevel() {
		super();
	}

    @Id
    @Column(name = "LEVEL_ID")
	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}

	public String getLevel_desc() {
		return level_desc;
	}

	public void setLevel_desc(String level_desc) {
		this.level_desc = level_desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level_desc == null) ? 0 : level_desc.hashCode());
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
		if (level_desc == null) {
			if (other.level_desc != null)
				return false;
		} else if (!level_desc.equals(other.level_desc))
			return false;
		if (level_id != other.level_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserLevel [level_id=" + level_id + ", level_desc=" + level_desc + "]";
	}


}
