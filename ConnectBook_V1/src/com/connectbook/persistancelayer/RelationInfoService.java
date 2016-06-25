package com.connectbook.persistancelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.connectbook.businesslayer.RelationInfoBean;

public class RelationInfoService {

	public RelationInfoService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<RelationInfoBean> casting(List<RelationInfo> relationInfoList){
		
		List<RelationInfoBean> relationInfoBeanList = new ArrayList<RelationInfoBean>();
		
		RelationInfoBean relationInfoBean = new RelationInfoBean();
		RelationInfo relationInfo = new RelationInfo();
		
		Iterator<RelationInfo> listIterator = relationInfoList.iterator();
		while(listIterator.hasNext()){
			relationInfo = (RelationInfo)listIterator.next();
			relationInfoBean = new RelationInfoBean();
			relationInfoBean.setReceiverUserId(relationInfo.getReceiverUserId());
			relationInfoBean.setSenderUserId(relationInfo.getSenderUserId());
			relationInfoBean.setRelationId(relationInfo.getRelationId());
			relationInfoBean.setRelationStatus(relationInfo.getRelationStatus());
			relationInfoBean.setDateOfLastAction(relationInfo.getDateOfLastAction());
			
			relationInfoBeanList.add(relationInfoBean);
		}
		
		return relationInfoBeanList;
		
	}
	
	public List<RelationInfoBean> getFriendList(int userId){
		
		List<RelationInfoBean> friendList = null;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		String queryString = "SELECT r FROM RelationInfo r WHERE "
							+ "(r.senderUserId = "+ userId 
							+" OR r.receiverUserId = "+userId
							+") and r.relationStatus = "+1;
		Query query = eManager.createQuery(queryString);
		List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();
		
		eManager.close();
		emFactory.close();
		
		RelationInfoService service = new RelationInfoService();
		friendList = service.casting(list1);
		
		return friendList;		
	}
	
	public List<RelationInfoBean> getFriendReqSentList(int userId){
		
		List<RelationInfoBean> friendReqSentList = null;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		RelationInfo relationInfo = new RelationInfo();
		
		String queryString = "SELECT r FROM RelationInfo r WHERE "
				+ "r.senderUserId = "+ userId 
				+" and r.relationStatus = "+0;
		
		Query query = eManager.createQuery(queryString);
		List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();
		
		eManager.close();
		emFactory.close();
		
		RelationInfoService service = new RelationInfoService();
		friendReqSentList = service.casting(list1);

		return friendReqSentList;
	}
	
	public List<RelationInfoBean> getFriendReqReceivedList(int userId){
		List<RelationInfoBean> friendReqReceivedList = null;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		String queryString = "SELECT r FROM RelationInfo r WHERE "
				+ "r.receiverUserId = "+ userId 
				+" and r.relationStatus = "+0;
		
		Query query = eManager.createQuery(queryString);
		List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();
		
		eManager.close();
		emFactory.close();
		
		
		
		RelationInfoService service = new RelationInfoService();
		friendReqReceivedList = service.casting(list1);
		
		return friendReqReceivedList;
	}
	
	public boolean checkRelation(RelationInfoBean relationInfoBean){
		boolean status = false;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		RelationInfo relationInfo = new RelationInfo();
		
		String queryString = "SELECT r FROM RelationInfo r WHERE ("
							+"r.senderUserId = "+ relationInfoBean.getSenderUserId() +" and r.receiverUserId = "+relationInfoBean.getReceiverUserId()
							+") OR ("
							+"r.senderUserId = "+ relationInfoBean.getReceiverUserId() +" and r.receiverUserId = "+relationInfoBean.getSenderUserId()+")";
		
		Query query = eManager.createQuery(queryString);
		List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();
		
		if(list1.isEmpty()){
			status = false;
		}else{
			status = true;
		}
		
		eManager.close();
		emFactory.close();
		
		return status;
	}
	
 	public boolean sendFriendReq(RelationInfoBean relationInfoBean){
		
		boolean status = false;
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		RelationInfo relationInfo = new RelationInfo();
		
		relationInfo.setSenderUserId(relationInfoBean.getSenderUserId());
		relationInfo.setReceiverUserId(relationInfoBean.getReceiverUserId());
		relationInfo.setRelationStatus(relationInfoBean.getRelationStatus());
		relationInfo.setDateOfLastAction(relationInfoBean.getDateOfLastAction());
		
		eManager.persist(relationInfo);
		eManager.getTransaction().commit();
						
		eManager.close();
		emFactory.close();
		
		return true;
		
	}
	
	public boolean acceptFriendReq(RelationInfoBean relationInfoBean){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		String queryString = "SELECT r FROM RelationInfo r WHERE "
							+ "r.senderUserId = "+ relationInfoBean.getSenderUserId() 
							+" and r.receiverUserId = "+relationInfoBean.getReceiverUserId()
							+" and r.relationStatus = "+0;
		Query query = eManager.createQuery(queryString);
		List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();
		
		for(RelationInfo relationInfo: list1){
			
			relationInfo.setRelationStatus(1);
			relationInfo.setDateOfLastAction(relationInfoBean.getDateOfLastAction());
			eManager.persist(relationInfo);
			eManager.getTransaction().commit();			
			
		}
				
		eManager.close();
		emFactory.close();
			
		return true;
	}
	
	public boolean rejectFriendReq(RelationInfoBean relationInfoBean){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		String queryString = "DELETE FROM RelationInfo r WHERE "
							+ "r.senderUserId = "+ relationInfoBean.getSenderUserId() 
							+" and r.receiverUserId = "+relationInfoBean.getReceiverUserId()
							+" and r.relationStatus = "+0;
		Query query = eManager.createQuery(queryString);
		query.executeUpdate();
		
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
			
		return true;
	}
	
	public boolean cancelFriendReq(RelationInfoBean relationInfoBean){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		String queryString = "DELETE FROM RelationInfo r WHERE "
							+ "r.senderUserId = "+ relationInfoBean.getSenderUserId() 
							+" and r.receiverUserId = "+relationInfoBean.getReceiverUserId()
							+" and r.relationStatus = "+0;
		Query query = eManager.createQuery(queryString);
		query.executeUpdate();
		
		eManager.getTransaction().commit();
		
		eManager.close();
		emFactory.close();
			
		return true;
	}

	public boolean blockUser(RelationInfoBean relationInfoBean){
		boolean status = false;
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ConnectBook_V1");
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		
		RelationInfoService service = new RelationInfoService();
		
		boolean relationExists = service.checkRelation(relationInfoBean);
		
		if(relationExists){
			String queryString = "SELECT r FROM RelationInfo r WHERE "
					+ "r.senderUserId = "+ relationInfoBean.getSenderUserId() 
					+" and r.receiverUserId = "+relationInfoBean.getReceiverUserId()
					+" and r.relationStatus = ";
			Query query = eManager.createQuery(queryString);
			List<RelationInfo> list1=(List<RelationInfo>)query.getResultList();

			for(RelationInfo relationInfo: list1){
	
				relationInfo.setRelationStatus(2);
				relationInfo.setDateOfLastAction(relationInfoBean.getDateOfLastAction());
				eManager.persist(relationInfo);
				eManager.getTransaction().commit();			
	
			}
		}else{
			RelationInfo relationInfo = new RelationInfo();
			
			relationInfo.setSenderUserId(relationInfoBean.getSenderUserId());
			relationInfo.setReceiverUserId(relationInfoBean.getReceiverUserId());
			relationInfo.setRelationStatus(2);
			relationInfo.setDateOfLastAction(relationInfoBean.getDateOfLastAction());
			
			eManager.persist(relationInfo);
			eManager.getTransaction().commit();
		}
				
		eManager.close();
		emFactory.close();
		
		return status;
	}

}

