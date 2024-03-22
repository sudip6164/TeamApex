package com.test.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.models.User;
import com.test.repo.urepo;

import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {
	
	@Autowired
	  urepo Urepo;
	
	
	
	
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User u, Model model, HttpSession session) {
	    if (Urepo.existsByPhonenumberAndPassword(u.getPhonenumber(), u.getPassword())) 
	    {
	    	
	    	session.setAttribute("ActiveUser", u.getPhonenumber());
	    	session.setMaxInactiveInterval(60);
	        List<User> userList = Urepo.findAll();
	        model.addAttribute("uList", userList); // Adding the 'uList' attribute to the model
	        return "home.html"; // Redirecting to home page or any other appropriate page after successful login
	    }
	    return "index.html"; // Returning to the login page if login is unsuccessful
	}
	

}
