package com.springdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.model.User;
import com.springdemo.repository.UserRepository;

@RestController
public class RestControllerHandler {
	
	@Autowired
	private UserRepository uRepo;
	
	@GetMapping("/api/getData")
	public List<User> getData(){
		List <User> uList=uRepo.findAll();
		
		return uList;
}
	@PostMapping("/api/postData")
	public String saveData(@RequestBody User u) {
		uRepo.save(u);
		return "Successfully saved";
	}
	@PutMapping("/api/updateData")
	public String updateData(@RequestBody User u) {
		
		uRepo.save(null);
		return "Successfully updated";
	}
	
	@DeleteMapping("/api/deleteData")
	public String deleteData(@RequestParam int id) {
		
		uRepo.deleteById(id);
		return "Delete Successful";
	}

}
