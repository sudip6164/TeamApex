package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.model.Post;
import com.springdemo.model.User;
import com.springdemo.repository.PostRepository;
import com.springdemo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	@Autowired
    private PostRepository pRepo;
	@Autowired
    private UserRepository uRepo;

	@GetMapping("/postPicture")
	public String frontpage() {
		return "PostPicture.html";
	}
	@PostMapping("/postPictureForm")
	public String handlePostForm(
			 @RequestParam("category") String category,
		        @RequestParam("location") String location,
		        @RequestParam("description") String description,
		        @RequestParam("image") String image,
		        HttpSession session) {

				String activeUserPhoneNumber = (String) session.getAttribute("ActiveUser");
				User activeUser = uRepo.findByPhonenumber(activeUserPhoneNumber);
				 
	    // Create a new Post object
	    Post post = new Post();
	    post.setU(activeUser);
	    post.setCategory(category);
	    post.setLocation(location);
	    post.setDescription(description);
	    post.setImage(image);

	    // Save the Post object to the database
	    pRepo.save(post);

	    // Redirect to the dashboard page or any other appropriate page
	    return "dash.html";
	}
	
	
}
