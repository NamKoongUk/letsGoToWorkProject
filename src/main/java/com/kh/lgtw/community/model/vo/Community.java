package com.kh.lgtw.community.model.vo;

import java.sql.Date;

public class Community  implements java.io.Serializable  {

	private  int bno; //게시판 번호 
	private  String boardName; //게시판 이름
	private  int createUser;//게시판 작성자 번호
	private  Date createDate;//게시판 작성일자
	private  String boardAuthority;//게시판 권한
	private  String status;//게시판 상태
	private  String boardType;//게시판 유형
	private String createUserName;//게시판 작성자 이름
	
	
	
	public Community() {}



	public Community(int bno, String boardName, int createUser, Date createDate, String boardAuthority, String status,
			String boardType, String createUserName) {
		super();
		this.bno = bno;
		this.boardName = boardName;
		this.createUser = createUser;
		this.createDate = createDate;
		this.boardAuthority = boardAuthority;
		this.status = status;
		this.boardType = boardType;
		this.createUserName = createUserName;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getBoardName() {
		return boardName;
	}



	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}



	public int getCreateUser() {
		return createUser;
	}



	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getBoardAuthority() {
		return boardAuthority;
	}



	public void setBoardAuthority(String boardAuthority) {
		this.boardAuthority = boardAuthority;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getBoardType() {
		return boardType;
	}



	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}



	public String getCreateUserName() {
		return createUserName;
	}



	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}



	@Override
	public String toString() {
		return "Community [bno=" + bno + ", boardName=" + boardName + ", createUser=" + createUser + ", createDate="
				+ createDate + ", boardAuthority=" + boardAuthority + ", status=" + status + ", boardType=" + boardType
				+ ", createUserName=" + createUserName + "]";
	}




		



  
	
	
	
}
