package com.revature.madlibs.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CompletedStories {

	private int completedStoryId;
	private String completedStory;
	private int completerId;	
	private int upvoteCount;
	private int incompleteStoryId;
	private Timestamp completedDate;
	
	public CompletedStories(int completedStoryId, String completedStory, int completerId, int incompleteStoryId, int upvoteCount) {
		super();
		this.completedStoryId = completedStoryId;
		this.completedStory = completedStory;
		this.completerId = completerId;
		this.incompleteStoryId = incompleteStoryId;
		this.upvoteCount = upvoteCount;
	}

	public CompletedStories(String completedStory, int incompleteStoryId, int completerId) {
		super();
		this.completedStory = completedStory;
		this.incompleteStoryId = incompleteStoryId;
		this.completerId = completerId;
	}

	public CompletedStories() {
		super();
	}
	
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "INCOMPLETE_STORY_ID")
    public int getIncompletStoryId() {
		return incompleteStoryId;
	}

	public void setIncompletStoryId(int incompletStoryId) {
		this.incompleteStoryId = incompletStoryId;
	}

	@Id
    @Column(name = "COMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCompletedStoryId() {
		return completedStoryId;
	}

	public void setCompletedStoryId(int completedStoryId) {
		this.completedStoryId = completedStoryId;
	}

	public String getCompletedStory() {
		return completedStory;
	}

	public void setCompletedStory(String completedStory) {
		this.completedStory = completedStory;
	}
	
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
	public int getCompleterId() {
 
		return completerId;
	}

	public void setCompleterId(int completerId) {
		this.completerId = completerId;
	}

	public int getUpvoteCount() {
		return upvoteCount;
	}

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMPLETED")
	public Timestamp getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Timestamp completedDate) {
		this.completedDate = completedDate;
	}

	@Override
	public String toString() {
		return "CompletedStories [completedStoryId=" + completedStoryId + ", completedStory=" + completedStory
				+ ", completerId=" + completerId + ", upvoteCount=" + upvoteCount + "]";
	}

	public void setUpvoteCount(int upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	
	

}
