package com.revature.madlibs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IncompleteStories {
	
	@Id
    @Column(name = "INCOMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storyId;
//    @OneToOne(targetEntity=UserLevel.class,cascade=CascadeType.ALL)
//    @JoinColumn(name = "LEVEL_ID")
	private int storyLevel;
//    @OneToOne(targetEntity=StoryCategory.class,cascade=CascadeType.ALL)
//    @JoinColumn(name = "STORY_CATEGORY_ID")
	private int categoryId;
    @Column(length=10000)
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
	
	public IncompleteStories(int storyLevel, int categoryId, String incompleteStory, int missingWordCount) {
		super();
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

	public int rgetCategoryId() {
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
