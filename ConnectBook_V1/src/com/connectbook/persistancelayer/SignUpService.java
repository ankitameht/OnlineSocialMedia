package com.connectbook.persistancelayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.connectbook.businesslayer.UserInfoBean;


public class SignUpService {

	public SignUpService() {
		// TODO Auto-generated constructor stub
	}
		
	public boolean createUser(UserInfoBean userInfoBean){
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		LoginInfo loginInfo = new LoginInfo();
		
		loginInfo.setUserId(userInfoBean.getUserId());
		loginInfo.setUserName(userInfoBean.getEmailId());
		loginInfo.setPassword(userInfoBean.getPassword());
		
		eManager.persist(loginInfo);
		eManager.getTransaction().commit();
		
		eManager.getTransaction().begin();
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserId(userInfoBean.getUserId());
		userInfo.setFirstName(userInfoBean.getFirstName());
		userInfo.setLastName(userInfoBean.getLastName());
		userInfo.setEmailId(userInfoBean.getEmailId());
		userInfo.setPhoneNumber(userInfoBean.getPhoneNumber());
		userInfo.setGender(userInfoBean.getGender());
		userInfo.setDateOfBirth(userInfoBean.getDateOfBirth());
		
		eManager.persist(userInfo);
		eManager.getTransaction().commit();
			
		eManager.close();
		emFactory.close();
		
		return true;
	}

	public boolean checkEmailId(UserInfoBean userInfoBean){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		Query query = eManager.createQuery("SELECT u FROM UserInfo u WHERE u.emailId LIKE '"+userInfoBean.getEmailId()+"'");
		
		List<UserInfo> list1=(List<UserInfo>)query.getResultList( );
		
		eManager.close();
		emFactory.close();
		
		if(list1.isEmpty()){
			return false;
		}else{
			return true;
		}
		
	}
}
