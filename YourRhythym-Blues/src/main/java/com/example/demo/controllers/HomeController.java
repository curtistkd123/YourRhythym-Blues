package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.User;
import com.example.demo.services.HomeService;
import com.example.demo.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserValidator uValidate;
	
	@Autowired
	private HomeService service;
	
	@GetMapping("/")
	public String index() {
		return"index.jsp";
	}
	
	@GetMapping("/register")
	public String signup(@ModelAttribute("user")User user) {
		
		return"userRegister.jsp";
	}
	
	@PostMapping("/register")
	public String createUser(@Valid @ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		uValidate.validate(user, result);
		if(result.hasErrors()) {
			return"userRegister.jsp";
		}
		service.createUser(user);
		session.setAttribute("id", user.getId());
		
		return"index.jsp";
	}
	

}
