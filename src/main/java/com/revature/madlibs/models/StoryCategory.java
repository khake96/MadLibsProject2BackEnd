package com.revature.madlibs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoryCategory {
	
    @Id
    @Column(name = "STORY_CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	private String categoryDesc;
	
	public StoryCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoryCategory(int categoryId, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryDesc = categoryDesc;
	}

	public StoryCategory(String categoryDesc) {
		super();
		this.categoryDesc = categoryDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Override
	public String toString() {
		return "StoryCategory [categoryId=" + categoryId + ", categoryDesc=" + categoryDesc
				+ ", getCategoryId()=" + getCategoryId() + ", getCategoryDesc()=" + getCategoryDesc() + 
				", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}
