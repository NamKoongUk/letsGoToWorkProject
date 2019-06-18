package com.kh.lgtw.community.model.vo;

import java.sql.Date;

public class Community  implements java.io.Serializable  {

	private  int bid; //게시판 번호 
	private  String btitle; //게시판 이름
	private  Date bcreateDate;//게시판 작성일자
	private  String authority;//게시판 권한
	private  String status;//게시판 상태
	private  String btype;//게시판 유형
	private  String bwriter;//게시판 작성자
	
	
	
	
  public Community() {}




public Community(int bid, String btitle, Date bcreateDate, String authority, String status, String btype,
		String bwriter) {
	super();
	this.bid = bid;
	this.btitle = btitle;
	this.bcreateDate = bcreateDate;
	this.authority = authority;
	this.status = status;
	this.btype = btype;
	this.bwriter = bwriter;
}




public int getBid() {
	return bid;
}




public void setBid(int bid) {
	this.bid = bid;
}




public String getBtitle() {
	return btitle;
}




public void setBtitle(String btitle) {
	this.btitle = btitle;
}




public Date getBcreateDate() {
	return bcreateDate;
}




public void setBcreateDate(Date bcreateDate) {
	this.bcreateDate = bcreateDate;
}




public String getAuthority() {
	return authority;
}




public void setAuthority(String authority) {
	this.authority = authority;
}




public String getStatus() {
	return status;
}




public void setStatus(String status) {
	this.status = status;
}




public String getBtype() {
	return btype;
}




public void setBtype(String btype) {
	this.btype = btype;
}




public String getBwriter() {
	return bwriter;
}




public void setBwriter(String bwriter) {
	this.bwriter = bwriter;
}




@Override
public String toString() {
	return "Community [bid=" + bid + ", btitle=" + btitle + ", bcreateDate=" + bcreateDate + ", authority=" + authority
			+ ", status=" + status + ", btype=" + btype + ", bwriter=" + bwriter + "]";
}





  
	
	
	
}
