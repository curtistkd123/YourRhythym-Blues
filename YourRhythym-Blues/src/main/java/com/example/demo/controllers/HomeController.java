package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String index(HttpSession session,Model model) {
		if(session.getAttribute("userid")==null) {
			model.addAttribute("user",null);
			return"index.jsp";
		}
			User user = service.findUserById((Long)session.getAttribute("userid"));
			model.addAttribute("user",user);
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
		session.setAttribute("userid", user.getId());
		
		return"redirect:/";
	}
	
	@GetMapping("/login")
	public String ulogin(@ModelAttribute("user")User user) {
		
		return "userlogin.jsp";
		
	}
	
	//authenticate
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("user")User user,BindingResult result,Model model,
			HttpSession session,@RequestParam("email")String email,@RequestParam("password")String password) {
		
		boolean authenticate = service.authenticateUser(email, password);
		if(!authenticate) {
			model.addAttribute("error","Email and/or password do not match");
			return"userlogin.jsp";
		}
		
		user = service.findByEmail(email);
		session.setAttribute("userid", user.getId());
		return"redirect:/";
	}
	
	@GetMapping("/edit/user/{id}")
	public String editUser(@ModelAttribute("user")User user,@PathVariable("id")Long id,Model model) {
		user = service.findUserById(id);
		model.addAttribute("user",user);
		return"editUser.jsp";
	}
	
	@PostMapping("/edit/user/{id}")
	public String updateUser(@Valid @ModelAttribute("user")User user,BindingResult result,HttpSession session) {
		uValidate.validate(user, result);
		if(result.hasErrors()) {
			return"userRegister.jsp";
		}
		user.setId((Long) session.getAttribute("userId"));
		service.createUser(user);
		session.setAttribute("id", user.getId());
		
		return"/";
	}
}
