package com.revature.madlibs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.models.User;
import com.revature.madlibs.service.ServiceImpl;

@RestController
@RequestMapping(value="/registration")
@CrossOrigin
public class RegistrationController {
	
	private ServiceImpl service;
	
	@Autowired
	public RegistrationController(ServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping(value="/create")
	public ResponseEntity<User> insert(User user) {
		User returnedUser = service.registerUser(user);
		if(returnedUser != null) {
			return ResponseEntity.status(HttpStatus.OK).body(returnedUser);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	@PostMapping("/update")
	public ResponseEntity<User> update(User user) {
		User returnedUser = service.updateUser(user);
		if(returnedUser != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

}
