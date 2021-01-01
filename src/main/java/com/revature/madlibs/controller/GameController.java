package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.models.CompletedStories;
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
	
	public ResponseEntity<List<CompletedStories>> getCompletedStories() {
		service.getCompletedStories()
	}
	
	public ResponseEntity<IncompletedStories> getInompletedStories(@ResponseBody StoryCategory category, @ResponseBody UserLevel level ) {
		
	}
	
	@PostMapping("/game")
	public ResponseEntity<boolean> saveCompletedStories(@ResponseBody CompletedStory story) {
		
	}
	
	@PostMapping("/game")
	public ResponseEntity<CompletedStories> updateCompletedStories(@ResponseBody CompletedStory story) {
		
	}	

}
