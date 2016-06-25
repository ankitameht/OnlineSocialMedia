package com.connectbook.businesslayer;

public class RelationInfoBean {

	private int relationId;
	private int senderUserId;
	private int receiverUserId;
	private int relationStatus;
	private String DateOfLastAction;
	
	public RelationInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public int getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(int senderUserId) {
		this.senderUserId = senderUserId;
	}

	public int getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(int receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public int getRelationStatus() {
		return relationStatus;
	}

	public void setRelationStatus(int relationStatus) {
		this.relationStatus = relationStatus;
	}

	public String getDateOfLastAction() {
		return DateOfLastAction;
	}

	public void setDateOfLastAction(String dateOfLastAction) {
		DateOfLastAction = dateOfLastAction;
	}


}
