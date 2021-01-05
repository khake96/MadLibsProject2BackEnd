package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
import com.revature.madlibs.models.StoryCategory;
import com.revature.madlibs.models.UserLevel;
import com.revature.madlibs.service.ServiceImpl;

@RestController
@RequestMapping(value="/game")
@CrossOrigin // No security concern so this is left open
public class GameController {
	
	private ServiceImpl service;
	
	@Autowired
	public GameController(ServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value= "/read")
	public ResponseEntity<List<CompletedStories>> getCompletedStories() {
		List<CompletedStories> list = service.getCompletedStories1();
				return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping //  Not a RESTful way to accomplish this task....
	public ResponseEntity<IncompleteStories> getIncompletedStory(@RequestBody StoryCategory category, @RequestBody UserLevel level, @RequestBody int missingWordCount) {
		IncompleteStories list = service.getOneIncompleteStory(category, level, missingWordCount);	
		if (list != null) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<CompletedStories> saveCompletedStories(@RequestBody CompletedStories story) {
		CompletedStories returnStory;
		service.insertCompletedStory(story);
		returnStory = service.getLastCompletedStory();
		if(returnStory != null) {
			return ResponseEntity.status(HttpStatus.OK).body(returnStory);		
		} else return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<CompletedStories> updateCompletedStories(@RequestBody CompletedStories story) {
		CompletedStories returnStory;
		service.updateUpvoteCounts(story);
		returnStory = service.getLastCompletedStory();
		if(returnStory != null) {
			return ResponseEntity.status(HttpStatus.OK).body(returnStory);		
		} else return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
	}	

}
