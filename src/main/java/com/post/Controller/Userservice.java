package com.post.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.models.Post;
import com.post.prepository.Prepo;

@Service
public class Userservice {
	
	@Autowired
	private Prepo prepo;
	
	
	public  void addPost(Post post)
	{
		prepo.save(post);
	}
	
	
	

}
