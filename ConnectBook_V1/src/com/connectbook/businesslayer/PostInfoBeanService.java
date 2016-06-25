package com.connectbook.businesslayer;

import java.util.Date;

import com.connectbook.persistancelayer.PostInfoService;

public class PostInfoBeanService {

	public PostInfoBeanService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean createPost(PostInfoBean postInfoBean){
		boolean status = false;
		Date currentDate = new Date();
		
		if(postInfoBean.getPostData()!=null){
			
			postInfoBean.setSenderUserId(LoginInfoBeanService.getLoggedInUser());
			postInfoBean.setDateOfPost(currentDate.toString());
			
			PostInfoService service = new PostInfoService();
			service.createPost(postInfoBean);
			
			
		}else{
			System.out.println("Post cannot be blank");
			
		}
		
		return status;
	}

}
