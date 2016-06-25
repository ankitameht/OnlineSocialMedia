package com.connectbook.persistancelayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.connectbook.businesslayer.PostInfoBean;

public class PostInfoService {

	public PostInfoService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean createPost(PostInfoBean postInfoBean){
		boolean status = false;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		PostInfo postInfo = new PostInfo();
		
		postInfo.setDateOfPost(postInfoBean.getDateOfPost());
		postInfo.setPostData(postInfoBean.getPostData());
		postInfo.setSenderUserId(postInfoBean.getSenderUserId());
		
		eManager.persist(postInfo);
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
		
		return status;
		
	}

}
