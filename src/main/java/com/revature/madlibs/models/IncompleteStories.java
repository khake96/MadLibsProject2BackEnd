package com.revature.madlibs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "incomplete_stories")
public class IncompleteStories {
	
	@Id
    @Column(name = "INCOMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storyId;
    @ManyToOne(targetEntity=UserLevel.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="user_level")
    private UserLevel storyLevel;
    @ManyToOne(targetEntity=StoryCategory.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="category")
    private StoryCategory category;
    @Column(length=10000, name="original_story")
	private String originalStory;
    @Column(name="author_book")
    private String authorBook;
    @Column(length=10000, name="incomplete_story")
	private String incompleteStory;
    @Column(name="author_first_name")
    private String authorFirstName;
    @Column(name="author_last_name")
    private String authorLastName;
    @Column(name="missing_word_count")
	private int missingWordCount;
	
	public IncompleteStories() {
		super();
	}


	public IncompleteStories(int storyId, UserLevel storyLevel, StoryCategory category, String originalStory,
			String authorBook, String incompleteStory, String authorFirstName, String authorLastName,
			int missingWordCount) {
		super();
		this.storyId = storyId;
		this.storyLevel = storyLevel;
		this.category = category;
		this.originalStory = originalStory;
		this.authorBook = authorBook;
		this.incompleteStory = incompleteStory;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.missingWordCount = missingWordCount;
	}


	public IncompleteStories(UserLevel storyLevel, StoryCategory category, String originalStory, String authorBook,
			String incompleteStory, String authorFirstName, String authorLastName, int missingWordCount) {
		super();
		this.storyLevel = storyLevel;
		this.category = category;
		this.originalStory = originalStory;
		this.authorBook = authorBook;
		this.incompleteStory = incompleteStory;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
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
	
	

	public String getOriginalStory() {
		return originalStory;
	}


	public void setOriginalStory(String originalStory) {
		this.originalStory = originalStory;
	}


	public String getAuthorBook() {
		return authorBook;
	}


	public void setAuthorBook(String authorBook) {
		this.authorBook = authorBook;
	}


	@Override
	public String toString() {
		return "IncompleteStories [storyId=" + storyId + ", storyLevel=" + storyLevel + ", category=" + category
				+ ", originalStory=" + originalStory + ", authorBook=" + authorBook + ", incompleteStory="
				+ incompleteStory + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName
				+ ", missingWordCount=" + missingWordCount + "]";
	}
}
	