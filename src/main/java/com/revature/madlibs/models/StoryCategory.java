package com.revature.madlibs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StoryCategory {
	
    @Id
    @Column(name = "STORY_CATEGORY_ID")
	private Integer categoryId;
	private String categoryDesc;
	
	public StoryCategory(Integer categoryId, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryDesc = categoryDesc;
	}

	public StoryCategory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
	

}
