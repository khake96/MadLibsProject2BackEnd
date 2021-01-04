package com.revature.madlibs.models;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="completed_stories")
public class CompletedStories {

	@Id
    @Column(name = "COMPLETE_STORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int completedStoryId;
	@Column(length=10000, name="completed_story")
	private String completedStory;
    @ManyToOne(targetEntity=User.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)	
    @JoinColumn(name = "completer")
    @JsonBackReference
    private User completer;	
    @Column(name="upvote_count")
    private int upvoteCount;
	@ManyToOne(targetEntity=IncompleteStories.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name="incomplete_story_id")
	@JsonManagedReference
	private IncompleteStories parentStory;
	@Column(name="completed_date")
	@Temporal(TemporalType.DATE)
	private Date completedDate;
	
	public CompletedStories() {
		super();
	}

	public CompletedStories(int completedStoryId, String completedStory, User completer, int upvoteCount,
			IncompleteStories parentStory, Date completedDate) {
		super();
		this.completedStoryId = completedStoryId;
		this.completedStory = completedStory;
		this.completer = completer;
		this.upvoteCount = upvoteCount;
		this.parentStory = parentStory;
		this.completedDate = completedDate;
	}

	public CompletedStories(String completedStory, User completer, int upvoteCount, IncompleteStories parentStory,
			Date completedDate) {
		super();
		this.completedStory = completedStory;
		this.completer = completer;
		this.upvoteCount = upvoteCount;
		this.parentStory = parentStory;
		this.completedDate = completedDate;
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

	public User getCompleter() {
		return completer;
	}

	public void setCompleter(User completer) {
		this.completer = completer;
	}

	public int getUpvoteCount() {
		return upvoteCount;
	}

	public void setUpvoteCount(int upvoteCount) {
		this.upvoteCount = upvoteCount;
	}

	public IncompleteStories getParentStory() {
		return parentStory;
	}

	public void setParentStory(IncompleteStories parentStory) {
		this.parentStory = parentStory;
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
				+ ", completer=" + completer + ", upvoteCount=" + upvoteCount + ", parentStory=" + parentStory
				+ ", completedDate=" + completedDate + "]";
	}
	
	


}
