package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.springdemo.model.User;
import com.springdemo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class SignupController {
	@Autowired
	private UserRepository uRepo;
	
	@GetMapping("/")
	public String frontPage()
	{
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login.html";
	}
	
	@GetMapping("/signup")
	public String signup(){
		return "signup.html";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User u){
		uRepo.save(u);
		return "login.html";
	}
	
	@PostMapping("/postlogin")
	public String postLogin(@ModelAttribute User u,Model model, HttpSession session){
		if (uRepo.existsByUsernameAndPassword(u.getUsername(), u.getPassword())) {
			session.setAttribute("activeUser", u.getUsername());
			List<User> userList=uRepo.findAll();
			model.addAttribute("userList",userList);
			return "homepage.html";
		}
		return "login.html";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable int id,Model model, HttpSession session) {
		
		if(session.getAttribute("activeUser")==null) {
			return "login.html";
		}
		User u=uRepo.getById(id);
		model.addAttribute("userObject", u);
		
		return "editForm.html";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute User u,Model model){
		uRepo.save(u);
		model.addAttribute("userList",uRepo.findAll());
		
		return "homepage.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAData(@PathVariable int id,	Model model)
	{
		uRepo.deleteById(id);
		model.addAttribute("userList",uRepo.findAll());
		return "homepage.html";
	}
	
}

