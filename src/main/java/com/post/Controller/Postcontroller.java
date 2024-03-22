package com.post.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.post.models.Post;


@Controller
public class Postcontroller {
	
	@Autowired
	private  Userservice uService;
	
	
	
	
		
	 @PostMapping("/submitPost")
	    public String submitPost(
	            @RequestParam("category") String category,
	            @RequestParam("location") String location,
	            @RequestParam("text") String text,
	            @RequestParam("postphoto") MultipartFile postphoto,
	            Model model) {

	        try {
	            byte[] photoBytes = postphoto.getBytes();
	            Post post = new Post();
	            post.setCategory(category);
	            post.setLocation(location);
	            post.setText(text);
	            post.setPostphoto(photoBytes);
	            uService.addPost(post);
	            model.addAttribute("message", "Post submitted successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addAttribute("error", "Failed to submit post: " + e.getMessage());
	        }

	        return "create_post";
	    }
		
}
