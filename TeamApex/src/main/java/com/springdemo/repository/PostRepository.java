package com.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.model.Post;
import com.springdemo.model.User;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
