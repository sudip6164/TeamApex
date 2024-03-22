package com.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.models.User;

@Repository
public interface urepo extends JpaRepository<User, Integer> {

	
//	boolean existsByPhonenumberAndPassword(String phonenumber, String password);
	boolean existsByPhonenumberAndPassword(String phonenumber, String password);
}
