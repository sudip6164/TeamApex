package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdemo.repository.UserRepository;
import com.springdemo.model.User;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	public UserRepository uRepo;
	
	@GetMapping("/")
	public String frontpage() {
		return "login.html";
	}
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User u, Model model, HttpSession session) {
	    if (uRepo.existsByPhonenumberAndPassword(u.getPhonenumber(), u.getPassword())) 
	    {
	    	
	    	session.setAttribute("ActiveUser", u.getPhonenumber());
	    	session.setMaxInactiveInterval(60);
	        List<User> userList = uRepo.findAll();
	        model.addAttribute("uList", userList); // Adding the 'uList' attribute to the model
	        return "home.html"; // Redirecting to home page or any other appropriate page after successful login
	    }
	    return "login.html"; // Returning to the login page if login is unsuccessful
	}
}
