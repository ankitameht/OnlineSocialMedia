package com.connectbook.businesslayer;

import com.connectbook.persistancelayer.LoginInfoService;

public class LoginInfoBeanService {

	private static int loggedInUser;
	
	public static int getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(int loggedInUser) {
		LoginInfoBeanService.loggedInUser = loggedInUser;
	}

	public LoginInfoBeanService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean loginService(LoginInfoBean loginInfoBean){
		int loggedInUserId;
		
		if(loginInfoBean.getUserName() != null){
			if(loginInfoBean.getPassword() != null){
				LoginInfoService service = new LoginInfoService();
						
				loggedInUserId = service.searchUserIDByUserName(loginInfoBean);
				loginInfoBean.setUserId(loggedInUserId);
				
				if(loggedInUserId != 0){
					this.setLoggedInUser(loggedInUserId);
					System.out.println("Login Successfull!" + loggedInUserId);
					return true;
				}else{
					System.out.println("UserName or Password didnot Match");
				}
			}else{
				System.out.println("Password is Missing");
			}
		}else{
			System.out.println("UserName is missing");
		}
		return false;
	}

}
