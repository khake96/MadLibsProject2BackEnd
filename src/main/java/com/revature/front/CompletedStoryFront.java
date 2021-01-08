package com.revature.front;

import com.revature.madlibs.models.IncompleteStories;

public class CompletedStoryFront {

	private int id;
	private int userId;
	private String completedStory;
	private int parentStory;
	
	public CompletedStoryFront() {
		super();
	}
	public CompletedStoryFront(int id, int userId, String completedStory, int parentStory) {
		super();
		this.id = id;
		this.userId = userId;
		this.completedStory = completedStory;
		this.parentStory = parentStory;
	}
	public CompletedStoryFront(int userId, String completedStory, int parentStory) {
		super();
		this.userId = userId;
		this.completedStory = completedStory;
		this.parentStory = parentStory;
	}
	@Override
	public String toString() {
		return "CompletedStoryFront [id=" + id + ", userId=" + userId + ", completedStory=" + completedStory
				+ ", parentStory=" + parentStory + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompletedStory() {
		return completedStory;
	}
	public void setCompletedStory(String completedStory) {
		this.completedStory = completedStory;
	}
	public int getParentStory() {
		return parentStory;
	}
	public void setParentStory(int parentStory) {
		this.parentStory = parentStory;
	}

}
