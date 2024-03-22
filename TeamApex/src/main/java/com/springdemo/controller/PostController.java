package com.springdemo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.model.Post;
import com.springdemo.model.User;
import com.springdemo.repository.PostRepository;
import com.springdemo.repository.UserRepository;


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

    @PostMapping("/postPictureForm") // Add this annotation to map to POST requests
    public String handlePostForm(
            @RequestParam("category") String category,
            @RequestParam("location") String location,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile,
            jakarta.servlet.http.HttpSession session) {

        // Retrieve active user from session
        String activeUserPhoneNumber = (String) session.getAttribute("ActiveUser");
        User activeUser = uRepo.findByPhonenumber(activeUserPhoneNumber);

        // Create a new Post object
        Post post = new Post();
        post.setU(activeUser);
        post.setCategory(category);
        post.setLocation(location);
        post.setDescription(description);

        try {
            // Check if imageFile is not null and is not empty
            if (imageFile != null && !imageFile.isEmpty()) {
                // Set the image bytes directly to the Post object
                post.setImage(imageFile.getBytes());
            }

            // Save the Post object to the database
            pRepo.save(post);

            // Redirect to the dashboard page or any other appropriate page
            return "dash.html";
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return "error.html"; // Return error page if an exception occurs
    }
}
