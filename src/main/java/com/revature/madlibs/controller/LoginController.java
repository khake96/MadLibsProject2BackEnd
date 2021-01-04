package com.revature.madlibs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.madlibs.models.Login;
import com.revature.madlibs.models.User;
import com.revature.madlibs.service.ServiceImpl;

@RestController
@RequestMapping(value="/login")
@CrossOrigin // left open for now as no security concerns in dev/ops
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
	//	System.out.println("Inside LoginController - getLogins()");
				return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Login> getLoginById(@PathVariable("id") int id) {
//		Login login = service.findLoginById(id);
		System.out.println("inside: LoginController - getLoginById");
		return ResponseEntity.status(HttpStatus.OK).body(service.findLoginById(id));
	}

	@PostMapping
	public ResponseEntity<User> userLogin(@RequestBody Login login) {
		User user = service.userLogin(login);
		if(user.getFirst_name()!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
}