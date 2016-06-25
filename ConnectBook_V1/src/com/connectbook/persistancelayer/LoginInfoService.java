package com.connectbook.persistancelayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.connectbook.businesslayer.LoginInfoBean;

public class LoginInfoService {

	public LoginInfoService() {
		// TODO Auto-generated constructor stub
	}
	
	public int searchUserIDByUserName(LoginInfoBean loginInfoBean){
		
		int userId = 0;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		Query query = eManager.createQuery("SELECT l FROM LoginInfo l WHERE l.userName LIKE '"+loginInfoBean.getUserName() +"' AND l.password LIKE '" +loginInfoBean.getPassword() +"'");
		
		List<LoginInfo> list1=(List<LoginInfo>)query.getResultList();
		
		for(LoginInfo loginInfo: list1){
			
			userId = loginInfo.getUserId();
						
		}
		
		return userId;
	}

}
