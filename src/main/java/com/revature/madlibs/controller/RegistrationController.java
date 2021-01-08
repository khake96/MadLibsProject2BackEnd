package com.revature.madlibs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.front.UpdateRegister;
//import com.revature.madlibs.models.Login;
//import com.revature.madlibs.models.LoginCheck;
import com.revature.madlibs.models.NewUser;
import com.revature.madlibs.models.User;
import com.revature.madlibs.service.ServiceImpl;

//This controller class for the Literary Madlibs application is responsible for
//handling HTTP requests from the front end of the application. It utilizes
//Spring MVC to abstract the Servlet handling.

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
	public ResponseEntity<User> insert(@RequestBody NewUser newUser) {
		User returnedUser = service.registerUser(newUser);
		if(returnedUser != null) {
			return ResponseEntity.status(HttpStatus.OK).body(returnedUser);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	@PostMapping(value="/update")
	public ResponseEntity<User> update(@RequestBody UpdateRegister updat) {
		System.out.println("in update registration"+updat);
		User returnedUser = service.updateUser(updat);
		if(returnedUser != null) {
			return ResponseEntity.status(HttpStatus.OK).body(returnedUser);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
}
