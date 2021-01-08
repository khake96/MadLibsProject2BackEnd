package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.front.CompletedStoryFront;
import com.revature.madlibs.models.CompletedStories;
import com.revature.madlibs.models.IncompleteStories;
//import com.revature.madlibs.models.StoryCategory;
//import com.revature.madlibs.models.UserLevel;
import com.revature.madlibs.service.ServiceImpl;

@RestController
@RequestMapping(value="/game")
@CrossOrigin 
public class GameController {
	
	private ServiceImpl service;
	
	@Autowired
	public GameController(ServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value= "/read")
	public ResponseEntity<List<CompletedStories>> getCompletedStories(@CookieValue(value = "userName",
            defaultValue = "unknown") String firstName) {
		if(firstName!=null) {
			List<CompletedStories> list = service.getCompletedStories1();
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

	}
	
//	@PostMapping(path = "/write", consumes = "application/json", produces = "application/json")
	@GetMapping(value= "/write/{id}")
	public ResponseEntity<IncompleteStories> getIncompletedStory(@PathVariable("id") int id) {
		IncompleteStories story = service.getOneIncompleteStoryById(id);
		if (story != null) {
			return ResponseEntity.status(HttpStatus.OK).body(story);
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
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value="/savestory")
	public ResponseEntity<CompletedStories> saveCompletedStory(@RequestBody CompletedStoryFront storyFront) {
		System.out.println(storyFront);
		CompletedStories returnStory;
		CompletedStories story = new CompletedStories(storyFront.getCompletedStory(), service.getUserById(storyFront.getUserId()), service.getOneIncompleteStoryById(storyFront.getParentStory()));
		System.out.println(story);
		
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
