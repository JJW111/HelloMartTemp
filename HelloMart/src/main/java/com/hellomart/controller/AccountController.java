package com.hellomart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hellomart.dto.Account;
import com.hellomart.service.AccountService;

@Controller
public class AccountController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService service;
	
	@RequestMapping("/public")
	public String index() {
		return "public";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public ModelAndView join() {
		return new ModelAndView("account/join", "account", new Account());
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String joinProcess(@ModelAttribute("account") Account account) {
		service.insertAccount(account);
		return "redirect:/";
	}
	
}
