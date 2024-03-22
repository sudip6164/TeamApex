package com.post.prepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.models.Post;

public interface Prepo extends JpaRepository<Post, Integer>{
	

}
