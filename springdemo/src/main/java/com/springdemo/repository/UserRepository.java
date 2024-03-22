package com.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String username,String password);
	boolean existsByUsernameAndPassword(String username, String password);
}
