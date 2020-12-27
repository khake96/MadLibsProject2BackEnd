package com.revature.madlibs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("I'm in doPost");
		res.setContentType("application/json");

		res.setStatus(403); // We override it, if everything is okay

		final String URI = req.getRequestURI().replace("/madlibs/", "");
		System.out.println(URI);
		switch (URI) {
		case "login":
			System.out.println(req.getAttributeNames());
			System.out.println(req.getAttribute("password"));
			System.out.println(req.getAttribute("userName"));	
			res.setStatus(200);
			break;
		}

	}
}

