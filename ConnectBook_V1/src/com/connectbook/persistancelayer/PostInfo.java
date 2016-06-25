package com.connectbook.persistancelayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PostInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int postId;
	private int senderUserId;
	private String postData;
	private String DateOfPost;
	
	public PostInfo() {
		// TODO Auto-generated constructor stub
	
	
	}

	public int getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(int senderUserId) {
		this.senderUserId = senderUserId;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public String getDateOfPost() {
		return DateOfPost;
	}

	public void setDateOfPost(String dateOfPost) {
		DateOfPost = dateOfPost;
	}

}
