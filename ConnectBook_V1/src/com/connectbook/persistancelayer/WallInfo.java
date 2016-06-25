package com.connectbook.persistancelayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WallInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int wallId;
	private List<PostInfo> wallPostList = new ArrayList<PostInfo>();
	
	
	public WallInfo() {
		// TODO Auto-generated constructor stub
	}


	public List<PostInfo> getWallPostList() {
		return wallPostList;
	}


	public void setWallPostList(List<PostInfo> wallPostList) {
		this.wallPostList = wallPostList;
	}
	
	

}
