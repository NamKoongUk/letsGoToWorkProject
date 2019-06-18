package com.kh.lgtw.community.model.vo;

import java.sql.Date;

public class CommunityComment implements java.io.Serializable
{
	private int psno; //게시글 번호
	private int cno;//댓글 번호
	private String cwriter;//댓글작성자
	private String ccontent;//댓글내용
	private Date ccreateDate;//댁글작성일자
	private Date cmodifyDate;//댓글수정일자
	private String stauts; // 댓글상태
	
	

	public CommunityComment () {}



	public CommunityComment(int psno, int cno, String cwriter, String ccontent, Date ccreateDate, Date cmodifyDate,
			String stauts) {
		super();
		this.psno = psno;
		this.cno = cno;
		this.cwriter = cwriter;
		this.ccontent = ccontent;
		this.ccreateDate = ccreateDate;
		this.cmodifyDate = cmodifyDate;
		this.stauts = stauts;
	}



	public int getPsno() {
		return psno;
	}



	public void setPsno(int psno) {
		this.psno = psno;
	}



	public int getCno() {
		return cno;
	}



	public void setCno(int cno) {
		this.cno = cno;
	}



	public String getCwriter() {
		return cwriter;
	}



	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}



	public String getCcontent() {
		return ccontent;
	}



	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}



	public Date getCcreateDate() {
		return ccreateDate;
	}



	public void setCcreateDate(Date ccreateDate) {
		this.ccreateDate = ccreateDate;
	}



	public Date getCmodifyDate() {
		return cmodifyDate;
	}



	public void setCmodifyDate(Date cmodifyDate) {
		this.cmodifyDate = cmodifyDate;
	}



	public String getStauts() {
		return stauts;
	}



	public void setStauts(String stauts) {
		this.stauts = stauts;
	}



	@Override
	public String toString() {
		return "CommunityComment [psno=" + psno + ", cno=" + cno + ", cwriter=" + cwriter + ", ccontent=" + ccontent
				+ ", ccreateDate=" + ccreateDate + ", cmodifyDate=" + cmodifyDate + ", stauts=" + stauts + "]";
	}
	 
	
	
	
	
	
}
