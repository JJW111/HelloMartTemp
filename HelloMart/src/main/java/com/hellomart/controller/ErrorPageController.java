package com.hellomart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ErrorPageController.class);
	
	@RequestMapping("/error/404")
	public String _404() {
		return "error/404";
	}
	
}
