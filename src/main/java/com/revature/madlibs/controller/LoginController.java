package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.LoginCheck;
import com.revature.madlibs.models.User;
import com.revature.madlibs.service.ServiceImpl;

//This controller class for the Literary Madlibs application is responsible for
//handling HTTP requests from the front end of the application. It utilizes
//Spring MVC to abstract the Servlet handling.

@RestController
@RequestMapping(value="/login")
@CrossOrigin 
public class LoginController {
	
	private ServiceImpl service;
	
	@Autowired
	public LoginController(ServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value="/lread")
	public ResponseEntity<List<Login>> getLogins() {
		List<Login> list = service.getAllLogins();
				return ResponseEntity.status(HttpStatus.OK).body(list);
	}



	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping 
	public ResponseEntity<User> userLogin(@RequestBody LoginCheck loginObject) {				

		User user = service.userLogin(new Login(loginObject.getUserName(), loginObject.getPword() ));
		System.out.println("login controller"+user);
		if(user != null) {
	        String userFirstName = user.getFirstName();
	        ResponseCookie cookie = ResponseCookie.from("userName", userFirstName).build();
			return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.SET_COOKIE, cookie.toString()).body(user);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	

	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(value="/done")
	public ResponseEntity<Object> userLogout() {				
	    ResponseCookie cookie = ResponseCookie.from("userName", null).build();
	    return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
	}
	
	
}
