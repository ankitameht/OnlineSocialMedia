package com.connectbook.businesslayer;

import com.connectbook.persistancelayer.SignUpService;

public class UserInfoService {

	public UserInfoService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean createUser(UserInfoBean userInfoBean){
		SignUpService service = new SignUpService();
		boolean emailExists = service.checkEmailId(userInfoBean);
		if(!emailExists){
			service.createUser(userInfoBean);
		}else{
			System.out.println("Email Exists");
			return false;
		}
		
		
		return true;
	}

}
