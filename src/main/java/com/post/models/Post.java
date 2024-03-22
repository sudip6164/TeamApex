package com.post.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postid;
	
	
	private String category;
	private String Location;
	private String text;
	
	
	@Lob
	private byte[] postphoto;


	

	public long getPostid() {
		return postid;
	}


	public void setPostid(long postid) {
		this.postid = postid;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public byte[] getPostphoto() {
		return postphoto;
	}


	public void setPostphoto(byte[] postphoto) {
		this.postphoto = postphoto;
	}


	
	
	
	

}
