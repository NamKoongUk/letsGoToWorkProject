package com.kh.lgtw.community.model.vo;

import java.sql.Date;

public class CommunityPost implements java.io.Serializable 
{
	
	private int contentNO; //게시글 번호 
	private int bno;       //게시판 번호
	private int bwriter;   //게시글 작성자 번호
	private String btitle; //게시글 제목
	private String bcontent;//게시글 내용
	private Date createDate;//게시글 생성일자
	private Date modifyDate;//게시글 수정일자
	private int bcount;     //게시글 조회수 

	private String status;  //게시글 상태 
	private String createUserName; // 게시글 작성자 이름
	
	

	public CommunityPost () {}



	public CommunityPost(int contentNO, int bno, int bwriter, String btitle, String bcontent, Date createDate,
			Date modifyDate, int bcount, String status, String createUserName) {
		super();
		this.contentNO = contentNO;
		this.bno = bno;
		this.bwriter = bwriter;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.bcount = bcount;
		
		this.status = status;
		this.createUserName = createUserName;
	}



	public int getContentNO() {
		return contentNO;
	}



	public void setContentNO(int contentNO) {
		this.contentNO = contentNO;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public int getBwriter() {
		return bwriter;
	}



	public void setBwriter(int bwriter) {
		this.bwriter = bwriter;
	}



	public String getBtitle() {
		return btitle;
	}



	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}



	public String getBcontent() {
		return bcontent;
	}



	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



	public int getBcount() {
		return bcount;
	}



	public void setBcount(int bcount) {
		this.bcount = bcount;
	}






	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCreateUserName() {
		return createUserName;
	}



	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}



	@Override
	public String toString() {
		return "CommunityPost [contentNO=" + contentNO + ", bno=" + bno + ", bwriter=" + bwriter + ", btitle=" + btitle
				+ ", bcontent=" + bcontent + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", bcount="
				+ bcount + ", status=" + status + ", createUserName=" + createUserName + "]";
	}

	
	
	
	
	
	
}
