package com.connectbook.businesslayer;

public class PostInfoBean {

	private int postId;
	private int senderUserId;
	private String postData;
	private String DateOfPost;
	
	public PostInfoBean() {
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
