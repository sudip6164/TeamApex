package com.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@ManyToOne
	private User u;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String category;
	private String location;
	private String description;
	@Lob // Indicates that the image data will be stored as a large object
    private byte[] image;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
