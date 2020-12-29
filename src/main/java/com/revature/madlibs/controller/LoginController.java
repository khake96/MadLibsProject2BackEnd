package com.revature.madlibs.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.madlibs.DAO.LoginDAO;
import com.revature.madlibs.models.Login;


public class LoginController {
	
	private ObjectMapper om = new ObjectMapper();
	private LoginDAO ld = new LoginDAO();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, Exception {
		
		HttpSession ses = req.getSession();
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);

		Login login = om.readValue(body, Login.class);
		
		if (ld.validate(login.getUserName(), login.getPassword())) {
			ses.setAttribute("loggedin", true);
			ses.setAttribute("result", "success");
			res.setHeader("status", "success!");
			res.setStatus(200);
		}
		
		
	}

}
