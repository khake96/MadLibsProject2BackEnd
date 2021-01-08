package com.revature.madlibs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//This class allows MVC to initialize certain parameters for the ubilization of this Spring 
//Servlet replacement application

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.revature"})
public class WebConfig {

}