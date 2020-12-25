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

	@Id
    @Column(name = "COMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer completedStoryId;
	private String completedStory;
    @OneToOne(targetEntity=IncompleteStories.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "INCOMPLETE_STORY_ID")
	private Integer completerId;	
	private Integer upvoteCount;
	private Integer incompleteStoryId;
	private Timestamp completedDate;
	
	public CompletedStories(Integer completedStoryId, String completedStory, Integer completerId, Integer incompleteStoryId, Integer upvoteCount) {
		super();
		this.completedStoryId = completedStoryId;
		this.completedStory = completedStory;
		this.completerId = completerId;
		this.incompleteStoryId = incompleteStoryId;
		this.upvoteCount = upvoteCount;
	}

	public CompletedStories(String completedStory, Integer incompleteStoryId, Integer completerId) {
		super();
		this.completedStory = completedStory;
		this.incompleteStoryId = incompleteStoryId;
		this.completerId = completerId;
	}

	public CompletedStories() {
		super();
	}
	

    public Integer getIncompletStoryId() {
		return incompleteStoryId;
	}

	public void setIncompletStoryId(Integer incompletStoryId) {
		this.incompleteStoryId = incompletStoryId;
	}


	public Integer getCompletedStoryId() {
		return completedStoryId;
	}

	public void setCompletedStoryId(Integer completedStoryId) {
		this.completedStoryId = completedStoryId;
	}

	public String getCompletedStory() {
		return completedStory;
	}

	public void setCompletedStory(String completedStory) {
		this.completedStory = completedStory;
	}
	

	public Integer getCompleterId() {
 
		return completerId;
	}

	public void setCompleterId(Integer completerId) {
		this.completerId = completerId;
	}

	public Integer getUpvoteCount() {
		return upvoteCount;
	}

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

	public void setUpvoteCount(Integer upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	
	

}
