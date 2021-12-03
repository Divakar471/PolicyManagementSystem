package com.order.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.order.model.Products;
import com.order.model.User;
import com.order.repo.UserRepository;
import com.order.service.Productimplementation;

@Controller
public class UserController 
{
	@Autowired
	UserRepository urepo;
	
	@Autowired
	private Productimplementation productImplementation;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/signup")
	public String getSignup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	@RequestMapping("/agent_login")
	public String getAgentLogin()
	{
		return "agent_login";
	}
	
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@RequestParam("user_email") String user_email, User user)
	{
		ModelAndView mv=new ModelAndView("success");
		List<User> list=urepo.findByEMAIL(user_email);
		
		if(list.size()!=0)
		{
		mv.addObject("message", "Oops!  There is already a user registered with the email provided.");
		
		}
		else
		{
		urepo.save(user);
		mv.addObject("message","User has been successfully registered. Your Token ID is:");
		}
		
		return mv;
	}
	@GetMapping("/dummy")
	public String dummy()
	{
		return "dummy";
	}
	
	@PostMapping("/login")
	public String login_user(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpSession session,ModelMap modelMap)
	{
		
	User auser=urepo.findByUsernamePassword(username, password);
	
	if(auser!=null)
	{
		String uname=auser.getUser_email();
		String upass=auser.getUser_pass();
	
		if(username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
		{
			session.setAttribute("username",username);
			return "dummy";
		}
		else 
		{
			modelMap.put("error", "Invalid Account");
			return "login";
		}
	}
	else
	{
		modelMap.put("error", "Invalid Account");
		return "login";
	}
	
	}
	
	@PostMapping("/agent_login")
	public String login_agent(@RequestParam("tokenid") Integer user_id,
			HttpSession session,ModelMap modelMap)
	{
		
	User auser=urepo.findByToken(user_id);
	
	if(auser!=null)
	{
		
			session.setAttribute("username",user_id.toString());
			return "dummy";
		
	}
	else
	{
		modelMap.put("error", "Invalid Account");
		return "agent_login";
	}
	
	}
	
	
	
	
	
	
	
	@GetMapping(value = "/logout")
	public String logout_user(HttpSession session)
	{
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/login";
	}
	
	
	
}
