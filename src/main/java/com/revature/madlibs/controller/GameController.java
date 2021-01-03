package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping(value="/read")
	public ResponseEntity<List<CompletedStories>> getCompletedStories() {
		List<CompletedStories> storiesList = service.getCompletedStories();
		if(storiesList == null || storiesList.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else return ResponseEntity.status(HttpStatus.ACCEPTED).body(storiesList);
	}
	
	@GetMapping(value="/story")
	public ResponseEntity<IncompleteStories> getInompletedStories(@RequestBody StoryCategory category, @RequestBody UserLevel level ) {
		IncompleteStories story = service.getOneIncompleteStory(category, level);
		if(story == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else return ResponseEntity.status(HttpStatus.ACCEPTED).body(story);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<CompletedStories> saveCompletedStories(@RequestBody CompletedStories story) {
			service.insertCompletedStory(story);
			return ResponseEntity.status(HttpStatus.OK).body(story);
		}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<CompletedStories> updateCompletedStories(@RequestBody CompletedStories story) {
		service.updateUpvoteCounts(story);
		return ResponseEntity.status(HttpStatus.OK).body(story);
	}

}
