package com.revature.madlibs.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IncompleteStories {
	
	@Id
	private Integer storyId;
    @OneToOne(targetEntity=UserLevel.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "LEVEL_ID")
	private Integer storyLevel;
    @OneToOne(targetEntity=StoryCategory.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "STORY_CATEGORY_ID")
	private Integer categoryId;
	private String incompleteStory;
	private Integer missingWordCount;
	
	public IncompleteStories(Integer storyId, Integer storyLevel, Integer categoryId, String incompleteStory,
			Integer missingWordCount) {
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

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	public Integer getStoryLevel() {
		return storyLevel;
	}

	public void setStoryLevel(Integer storyLevel) {
		this.storyLevel = storyLevel;
	}

	public Integer rgetCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getIncompleteStory() {
		return incompleteStory;
	}

	public void setIncompleteStory(String incompleteStory) {
		this.incompleteStory = incompleteStory;
	}

	public Integer getMissingWordCount() {
		return missingWordCount;
	}

	public void setMissingWordCount(Integer missingWordCount) {
		this.missingWordCount = missingWordCount;
	}
	
	
	
	
	
	
	
}
