package com.mahendra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mahendra.models.User;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

	@RequestMapping(method=RequestMethod.GET)
	public String showForm(Model model){
		User user = new User();
		model.addAttribute("user",user);
		System.out.println("Rendering a form");
		return "form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doSubmit(@ModelAttribute("user") User user, Model model){
		System.out.println("Submitting Form");
		System.out.println("User :"+user.getName()+" "+user.getEmail());
		return "success";
	}
}
