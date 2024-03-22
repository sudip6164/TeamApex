package com.post.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.post.models.Post;


@Controller
public class Postcontroller {
	
	@Autowired
	private  Userservice uService;
	
	
	
	
		
		@PostMapping("/submit_post")
	    public String addPost(@RequestBody Post post, 
	    		@RequestParam("category") String category,
	            @RequestParam("location") String location,
	            @RequestParam("text") String text,
	    		@RequestParam("postphoto") MultipartFile postphoto) {
	        try {
	        	post.setCategory(category);
	        	post.setLocation(location);
	        	post.setText(text);
	            post.setPostphoto(postphoto.getBytes());
	            uService.addPost(post);

	            return "Post submitted successfully!";
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Failed to submit post: " + e.getMessage();
	        }
	    }
		
}
