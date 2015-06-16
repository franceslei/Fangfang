package com.fanglei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	
	@RequestMapping("/signin")
	public String showSignIn(){
		
		return "signIn";
	}
	
	@RequestMapping("/signup")
	public String showSignUp(){
		
		return "signUp";
	}
}
