package com.revature.madlibs.models;

import java.util.Date;

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

	@Id
    @Column(name = "COMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int completedStoryId;
	@Column(length=10000)
	private String completedStory;
    @OneToOne(targetEntity=IncompleteStories.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "INCOMPLETE_STORY_ID")
	private int completerId;	
	private int upvoteCount;
	private int incompleteStoryId;
	@Temporal(TemporalType.DATE)
	private Date completedDate;
	
	
	
	public CompletedStories(String completedStory, int completerId, int upvoteCount, int incompleteStoryId,
			Date completedDate) {
		super();
		this.completedStory = completedStory;
		this.completerId = completerId;
		this.upvoteCount = upvoteCount;
		this.incompleteStoryId = incompleteStoryId;
		this.completedDate = completedDate;
	}

	public CompletedStories(int completedStoryId, String completedStory, int completerId, int upvoteCount,
			int incompleteStoryId, Date completedDate) {
		super();
		this.completedStoryId = completedStoryId;
		this.completedStory = completedStory;
		this.completerId = completerId;
		this.upvoteCount = upvoteCount;
		this.incompleteStoryId = incompleteStoryId;
		this.completedDate = completedDate;
	}

	public CompletedStories(String completedStory, int incompleteStoryId, int upvoteCount) {
		super();
		this.completedStory = completedStory;
		this.incompleteStoryId = incompleteStoryId;
		this.upvoteCount = upvoteCount;
	}

	public CompletedStories(String completedStory, int incompleteStoryId) {
		super();
		this.completedStory = completedStory;
		this.incompleteStoryId = incompleteStoryId;
	}

	public CompletedStories() {
		super();
	}
	

	public int getIncompletStoryId() {
		return incompleteStoryId;
	}

	public void setIncompletStoryId(int incompletStoryId) {
		this.incompleteStoryId = incompletStoryId;
	}


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
	

	public int getCompleterId() {
 
		return completerId;
	}

	public void setCompleterId(int completerId) {
		this.completerId = completerId;
	}

	public int getUpvoteCount() {
		return upvoteCount;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
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
