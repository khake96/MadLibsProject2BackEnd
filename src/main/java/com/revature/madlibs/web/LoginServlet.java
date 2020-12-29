package com.revature.madlibs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.madlibs.controller.LoginController;

public class LoginServlet extends HttpServlet {

	private LoginController lc = new LoginController();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		res.setStatus(403); // We override it, if everything is okay

		final String URI = req.getRequestURI().replace("/madlibs/", "");

		switch (URI) {
		case "login":	
			try {
				lc.login(req, res);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}

	}
}

