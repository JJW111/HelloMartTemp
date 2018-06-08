package com.hellomart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public String admin() {
		return "admin/page";
	}
	
}
