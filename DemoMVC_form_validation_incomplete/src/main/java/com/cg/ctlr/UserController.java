package com.cg.ctlr;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope("session")
@Controller
@RequestMapping(value="user")
public class UserController {
	
	@RequestMapping(value="showLogin")
	public String prepareLogin(Model model)
	{
		System.out.println("In prepareLogin() method");
		model.addAttribute("login",new Login());
		return "login";
	}
	
	@RequestMapping(value="checkLogin")
	public String checkLogin(@ModelAttribute("login") Login login
			, Model model)
	{
		String msg = "Login Successful!";
		boolean isValid = true;
		if( ! login.getUserName().equalsIgnoreCase("mahendra")) {
			msg = "Invalid Username";
			isValid=false;
		}else if(! login.getPassword().equals("1234599")) {
			isValid=false;
			msg = "Incorrect Password!";
		}
		model.addAttribute("msg",msg);
		//Logic to validate userName and password against database
	  	return "loginSuccess";	
	}

	@RequestMapping(value="showRegister")
	public String prepareRegister(Model model)
	{
		model.addAttribute("user",new User());
	    return "register";	
	}
	
	@RequestMapping(value="checkRegister")
	public String checkRegister(@Valid @ModelAttribute User user,
			BindingResult result,	
			Model model)
	{
		if(result.hasErrors()) {
			return "register";
		}else {
          model.addAttribute("user",user);  		  
	  	  return "registerSuccess";
		}
	}
	 
	

}
