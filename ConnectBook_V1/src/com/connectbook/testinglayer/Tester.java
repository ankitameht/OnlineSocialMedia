package com.connectbook.testinglayer;

import java.util.List;

import com.connectbook.businesslayer.LoginInfoBean;
import com.connectbook.businesslayer.LoginInfoBeanService;
import com.connectbook.businesslayer.PostInfoBean;
import com.connectbook.businesslayer.PostInfoBeanService;
import com.connectbook.businesslayer.RelationInfoBean;
import com.connectbook.businesslayer.RelationInfoBeanService;
import com.connectbook.businesslayer.UserInfoBean;
import com.connectbook.businesslayer.UserInfoService;

public class Tester {

	public Tester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int userId = 101;
		 String firstName = "Himanshu";
		 String lastName = "Kheria";
		 String emailId = "kheria.himanshu1@gmail.com";
		 String userName = "kheria.himanshu1@gmail.com";
		 long phoneNumber = 7030500808L;
		 String password = "test1234";
		 char gender = 'M';
		 String dateOfBirth = "08-09-1989";
		 
		 String post = "This is a Post";
		 
		 /*UserInfoBean userInfoBean = new UserInfoBean();
		 userInfoBean.setUserId(userId);
		 userInfoBean.setFirstName(firstName);
		 userInfoBean.setLastName(lastName);
		 userInfoBean.setEmailId(emailId);
		 userInfoBean.setPhoneNumber(phoneNumber);
		 userInfoBean.setPassword(password);
		 userInfoBean.setGender(gender);
		 userInfoBean.setDateOfBirth(dateOfBirth);
		 
		 UserInfoService userService = new UserInfoService();
		 userService.createUser(userInfoBean);*/
		 
		 LoginInfoBean loginInfoBean = new LoginInfoBean();
		 loginInfoBean.setUserName(userName);
		 loginInfoBean.setPassword(password);
		 	
		 LoginInfoBeanService loginService = new LoginInfoBeanService();
		 loginService.loginService(loginInfoBean);
		 
		 RelationInfoBeanService relationService =new RelationInfoBeanService();
		 /*relationService.sendFriendRequest(101);
		 relationService.sendFriendRequest(102);
		 relationService.sendFriendRequest(105);
		 relationService.sendFriendRequest(107);*/
		 //relationService.acceptFriendRequest(103);
		 //relationService.rejectFriendRequest(102);
		 //relationService.cancelFriendRequest(102);
		 /*System.out.println("getFriendReqSentList");
		 List<RelationInfoBean> friendReqSentList = relationService.getFriendReqSentList(userId);		 
		 for(RelationInfoBean friendReqSent:friendReqSentList){
			 System.out.println("SenderUserID: "+friendReqSent.getSenderUserId());
			 System.out.println("ReceiverUserID: "+friendReqSent.getReceiverUserId());
			 System.out.println("RelationStatus:  "+friendReqSent.getRelationStatus());
			 System.out.println("DateOfLastAction: "+friendReqSent.getDateOfLastAction());
			 
		 }*/
		 /*System.out.println("getFriendReqReceivedList");
		 List<RelationInfoBean> friendReqreceivedList = relationService.getFriendReqReceivedList(userId);		 
		 for(RelationInfoBean friendReqSent:friendReqreceivedList){
			 System.out.println("SenderUserID: "+friendReqSent.getSenderUserId());
			 System.out.println("ReceiverUserID: "+friendReqSent.getReceiverUserId());
			 System.out.println("RelationStatus:  "+friendReqSent.getRelationStatus());
			 System.out.println("DateOfLastAction: "+friendReqSent.getDateOfLastAction());
			 
		 }*/
		 System.out.println("getFriendList");
		 List<RelationInfoBean> friendList = relationService.getFriendList(userId);		 
		 for(RelationInfoBean friendReqSent:friendList){
			 /*System.out.println("SenderUserID: "+friendReqSent.getSenderUserId());
			 System.out.println("ReceiverUserID: "+friendReqSent.getReceiverUserId());*/
			 int friendUserId = 0;
			 System.out.println(LoginInfoBeanService.getLoggedInUser());
			 if(friendReqSent.getSenderUserId() == LoginInfoBeanService.getLoggedInUser()){
				 friendUserId = friendReqSent.getReceiverUserId();
			 }else if(friendReqSent.getReceiverUserId() == LoginInfoBeanService.getLoggedInUser()){
				 friendUserId = friendReqSent.getSenderUserId();
			 }
			 System.out.println("FriendUserId: "+ friendUserId);
			 System.out.println("RelationStatus:  "+friendReqSent.getRelationStatus());
			 System.out.println("DateOfLastAction: "+friendReqSent.getDateOfLastAction());
			 
		 }
		 
		 /*PostInfoBean postInfoBean = new PostInfoBean();
		 postInfoBean.setPostData(post);
		 
		 PostInfoBeanService postService = new PostInfoBeanService();
		 postService.createPost(postInfoBean);*/
		 
		 
	}

}
