package com.connectbook.businesslayer;

import java.util.Date;
import java.util.List;

import com.connectbook.persistancelayer.RelationInfoService;

public class RelationInfoBeanService {

	public RelationInfoBeanService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean sendFriendRequest(int receiverUserId){
		
		boolean status = false;
		RelationInfoBean relationInfoBean = new RelationInfoBean();
		Date currentDate = new Date();
		
		if(receiverUserId!=0){
			//relationInfoBean.setRelationId(1);
			relationInfoBean.setSenderUserId(LoginInfoBeanService.getLoggedInUser());
			relationInfoBean.setReceiverUserId(receiverUserId);
			relationInfoBean.setRelationStatus(0);
			relationInfoBean.setDateOfLastAction(currentDate.toString());
			
			RelationInfoService service = new RelationInfoService();
			status = service.checkRelation(relationInfoBean);
			if(!status ){
				service.sendFriendReq(relationInfoBean);
				
			}else{
				System.out.println("Relation already exist");
			}
			
		}
		
		return status;
		
	}

	public boolean acceptFriendRequest(int senderUserId){
		boolean status = false;
		
		RelationInfoBean relationInfoBean = new RelationInfoBean();
		Date currentDate = new Date();
		
		if(senderUserId!=0){
			//relationInfoBean.setRelationId(1);
			relationInfoBean.setSenderUserId(senderUserId);
			relationInfoBean.setReceiverUserId(LoginInfoBeanService.getLoggedInUser());
			//relationInfoBean.setRelationStatus(1);
			relationInfoBean.setDateOfLastAction(currentDate.toString());
			
			RelationInfoService service = new RelationInfoService();
			status = service.checkRelation(relationInfoBean);
			if(status ){
				service.acceptFriendReq(relationInfoBean);
				
			}else{
				System.out.println("Relation doesnot exist");
			}
			
		}
		
		
		return status;
	}
	
	public boolean rejectFriendRequest(int senderUserId){
		boolean status = false;
		
		RelationInfoBean relationInfoBean = new RelationInfoBean();
		Date currentDate = new Date();
		
		if(senderUserId!=0){
			//relationInfoBean.setRelationId(1);
			relationInfoBean.setSenderUserId(senderUserId);
			relationInfoBean.setReceiverUserId(LoginInfoBeanService.getLoggedInUser());
			//relationInfoBean.setRelationStatus(1);
			relationInfoBean.setDateOfLastAction(currentDate.toString());
			
			RelationInfoService service = new RelationInfoService();
			status = service.checkRelation(relationInfoBean);
			if(status ){
				service.rejectFriendReq(relationInfoBean);
				
			}else{
				System.out.println("Relation doesnot exist");
			}
			
		}
		
		
		return status;
	}
	
	public boolean cancelFriendRequest(int receiverUserId){
		boolean status = false;
		
		RelationInfoBean relationInfoBean = new RelationInfoBean();
		Date currentDate = new Date();
		
		if(receiverUserId!=0){
			//relationInfoBean.setRelationId(1);
			relationInfoBean.setSenderUserId(LoginInfoBeanService.getLoggedInUser());
			relationInfoBean.setReceiverUserId(receiverUserId);
			//relationInfoBean.setRelationStatus(1);
			relationInfoBean.setDateOfLastAction(currentDate.toString());
			
			RelationInfoService service = new RelationInfoService();
			status = service.checkRelation(relationInfoBean);
			if(status ){
				service.cancelFriendReq(relationInfoBean);
				
			}else{
				System.out.println("Relation doesnot exist");
			}
			
		}
		
		
		return status;
	}

	public List<RelationInfoBean> getFriendReqSentList(int userId){
		List<RelationInfoBean> relationInfoBeanList = null;
		RelationInfoService service = new RelationInfoService();
		relationInfoBeanList = service.getFriendReqSentList(userId);
		return relationInfoBeanList;
	}
	
	public List<RelationInfoBean> getFriendReqReceivedList(int userId){
		List<RelationInfoBean> relationInfoBeanList = null;
		RelationInfoService service = new RelationInfoService();
		relationInfoBeanList = service.getFriendReqReceivedList(userId);
		return relationInfoBeanList;
	}
	
	public List<RelationInfoBean> getFriendList(int userId){
		List<RelationInfoBean> relationInfoBeanList = null;
		RelationInfoService service = new RelationInfoService();
		relationInfoBeanList = service.getFriendList(userId);
		return relationInfoBeanList;
	}
}
