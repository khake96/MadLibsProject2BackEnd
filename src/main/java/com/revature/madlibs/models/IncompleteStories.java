package com.revature.madlibs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IncompleteStories {
	
	@Id
    @Column(name = "INCOMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storyId;
    @OneToOne(targetEntity=UserLevel.class,cascade=CascadeType.ALL)
	private UserLevel storyLevel;
    @OneToOne(targetEntity=StoryCategory.class,cascade=CascadeType.ALL)
	private StoryCategory category;
    @Column(length=10000)
	private String incompleteStory;
    private String authorFirstName;
    private String authorLastName;
	private int missingWordCount;
	
	public IncompleteStories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IncompleteStories(int storyId, UserLevel storyLevel, StoryCategory category, String incompleteStory,
			String authorFirstName, String authorLastName, int missingWordCount) {
		super();
		this.storyId = storyId;
		this.storyLevel = storyLevel;
		this.category = category;
		this.incompleteStory = incompleteStory;
		this.authorFirstName =authorFirstName;
		this.authorLastName =authorLastName;
		this.missingWordCount = missingWordCount;
	}

	public IncompleteStories(UserLevel storyLevel, StoryCategory category, String incompleteStory,
			String authorFirstName, String authorLastName, int missingWordCount) {
		super();
		this.storyLevel = storyLevel;
		this.category = category;
		this.incompleteStory = incompleteStory;
		this.authorFirstName =authorFirstName;
		this.authorLastName =authorLastName;
		this.missingWordCount = missingWordCount;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public UserLevel getStoryLevel() {
		return storyLevel;
	}

	public void setStoryLevel(UserLevel storyLevel) {
		this.storyLevel = storyLevel;
	}

	public StoryCategory getCategory() {
		return category;
	}

	public void setCategory(StoryCategory category) {
		this.category = category;
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

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	
	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	@Override
	public String toString() {
		return "IncompleteStories [storyId=" + storyId + ", storyLevel=" + storyLevel + ", category=" + category
				+ ", incompleteStory=" + incompleteStory + " , authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", missingWordCount="
				+ missingWordCount + "]";
	}


	
}
