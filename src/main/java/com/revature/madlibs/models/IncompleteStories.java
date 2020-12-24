package com.revature.madlibs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IncompleteStories {
	
	private int storyId;
	private int storyLevel;
	private int categoryId;
	private String incompleteStory;
	private int missingWordCount;
	
	public IncompleteStories(int storyId, int storyLevel, int categoryId, String incompleteStory,
			int missingWordCount) {
		super();
		this.storyId = storyId;
		this.storyLevel = storyLevel;
		this.categoryId = categoryId;
		this.incompleteStory = incompleteStory;
		this.missingWordCount = missingWordCount;
	}

	public IncompleteStories() {
		super();
	}

	@Override
	public String toString() {
		return "IncompleteStories [storyId=" + storyId + ", storyLevel=" + storyLevel + ", categoryId=" + categoryId
				+ ", incompleteStory=" + incompleteStory + ", missingWordCount=" + missingWordCount + "]";
	}

	@Id
	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getStoryLevel() {
		return storyLevel;
	}

	public void setStoryLevel(int storyLevel) {
		this.storyLevel = storyLevel;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getIncompleteStory() {
		return incompleteStory;
	}

	public void setIncompleteStory(String incompleteStory) {
		this.incompleteStory = incompleteStory;
	}

	public int getMissingWordCount() {
		return missingWordCount;
	}

	public void setMissingWordCount(int missingWordCount) {
		this.missingWordCount = missingWordCount;
	}
	
	
	
	
	
	
	
}
