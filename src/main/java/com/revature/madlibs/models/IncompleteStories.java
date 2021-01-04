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
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> parent of cce3ef8... final version more or less
    @OneToOne(targetEntity=UserLevel.class,cascade=CascadeType.ALL)
	private UserLevel storyLevel;
    @OneToOne(targetEntity=StoryCategory.class,cascade=CascadeType.ALL)
	private StoryCategory category;
    @Column(length=10000)
	private String incompleteStory;
<<<<<<< HEAD
>>>>>>> parent of cce3ef8... final version more or less
    private String authorFirstName;
    private String authorLastName;
<<<<<<< HEAD
    @Column(name="missing_word_count")
=======
>>>>>>> parent of cce3ef8... final version more or less
=======
    private String authorFirstName;
    private String authorLastName;
>>>>>>> parent of cce3ef8... final version more or less
	private int missingWordCount;
	
	public IncompleteStories() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
<<<<<<< HEAD

	public IncompleteStories(int storyId, UserLevel storyLevel, StoryCategory category, String originalStory,
			String authorBook, String incompleteStory, String authorFirstName, String authorLastName,
			int missingWordCount) {
=======
	public IncompleteStories(int storyId, UserLevel storyLevel, StoryCategory category, String incompleteStory,
			String authorFirstName, String authorLastName, int missingWordCount) {
>>>>>>> parent of cce3ef8... final version more or less
=======
	public IncompleteStories(int storyId, UserLevel storyLevel, StoryCategory category, String incompleteStory,
			String authorFirstName, String authorLastName, int missingWordCount) {
>>>>>>> parent of cce3ef8... final version more or less
		super();
		this.storyId = storyId;
		this.storyLevel = storyLevel;
		this.category = category;
<<<<<<< HEAD
<<<<<<< HEAD
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


=======
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

>>>>>>> parent of cce3ef8... final version more or less
=======
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

>>>>>>> parent of cce3ef8... final version more or less
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
	
	

<<<<<<< HEAD
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
<<<<<<< HEAD
				+ ", originalStory=" + originalStory + ", authorBook=" + authorBook + ", incompleteStory="
				+ incompleteStory + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName
				+ ", missingWordCount=" + missingWordCount + "]";
	}
=======
	@Override
	public String toString() {
		return "IncompleteStories [storyId=" + storyId + ", storyLevel=" + storyLevel + ", category=" + category
				+ ", incompleteStory=" + incompleteStory + " , authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", missingWordCount="
				+ missingWordCount + "]";
	}
=======
				+ ", incompleteStory=" + incompleteStory + " , authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + ", missingWordCount="
				+ missingWordCount + "]";
	}
>>>>>>> parent of cce3ef8... final version more or less


	
>>>>>>> parent of cce3ef8... final version more or less
}
	