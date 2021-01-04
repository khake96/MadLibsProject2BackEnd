package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping(value= "/write")
	public ResponseEntity<IncompleteStories> getIncompletedStories(@RequestBody StoryCategory category, @RequestBody UserLevel level) {
		
//		<IncompleteStories> list1 = service.getOneInCompleteStory(category, level);
//		
//		if (list1 != null) {
//			return ResponseEntity.status(HttpStatus.OK).body(list1);
//		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	return null;
	}
	
//	@PostMapping("/game")
//	public ResponseEntity saveCompletedStories(@RequestBody CompletedStories story) {
//		return null;
//		
//	}
//	
//	@PostMapping("/game")
//	public ResponseEntity<CompletedStories> updateCompletedStories(@RequestBody CompletedStories story) {
//		return null;
//		
//	}	

}
