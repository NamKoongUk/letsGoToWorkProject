package com.kh.lgtw.community.model.vo;

import java.sql.Date;

public class CommunityPost implements java.io.Serializable 
{
	private int bno;//게시판 번호
	private int psno;//게시글 번호
	private String pstitle;//게시글제목
	private String pscontent;//게시글내용
	private Date pscreateDate;//게시글 작성일자
	private Date psmodifyDate;//게시글 수정일자
	private int pscount;//게시글 조회수
	private String pstype;//게시글 종류
	private String psstaus;//게시글 상태
	
	

	public CommunityPost() {}



	public CommunityPost(int bno, int psno, String pstitle, String pscontent, Date pscreateDate, Date psmodifyDate,
			int pscount, String pstype, String psstaus) {
		super();
		this.bno = bno;
		this.psno = psno;
		this.pstitle = pstitle;
		this.pscontent = pscontent;
		this.pscreateDate = pscreateDate;
		this.psmodifyDate = psmodifyDate;
		this.pscount = pscount;
		this.pstype = pstype;
		this.psstaus = psstaus;
	}



	public int getBno() {
		return bno;
	}



	public void setBno(int bno) {
		this.bno = bno;
	}



	public int getPsno() {
		return psno;
	}



	public void setPsno(int psno) {
		this.psno = psno;
	}



	public String getPstitle() {
		return pstitle;
	}



	public void setPstitle(String pstitle) {
		this.pstitle = pstitle;
	}



	public String getPscontent() {
		return pscontent;
	}



	public void setPscontent(String pscontent) {
		this.pscontent = pscontent;
	}



	public Date getPscreateDate() {
		return pscreateDate;
	}



	public void setPscreateDate(Date pscreateDate) {
		this.pscreateDate = pscreateDate;
	}



	public Date getPsmodifyDate() {
		return psmodifyDate;
	}



	public void setPsmodifyDate(Date psmodifyDate) {
		this.psmodifyDate = psmodifyDate;
	}



	public int getPscount() {
		return pscount;
	}



	public void setPscount(int pscount) {
		this.pscount = pscount;
	}



	public String getPstype() {
		return pstype;
	}



	public void setPstype(String pstype) {
		this.pstype = pstype;
	}



	public String getPsstaus() {
		return psstaus;
	}



	public void setPsstaus(String psstaus) {
		this.psstaus = psstaus;
	}



	@Override
	public String toString() {
		return "CommunityPost [bno=" + bno + ", psno=" + psno + ", pstitle=" + pstitle + ", pscontent=" + pscontent
				+ ", pscreateDate=" + pscreateDate + ", psmodifyDate=" + psmodifyDate + ", pscount=" + pscount
				+ ", pstype=" + pstype + ", psstaus=" + psstaus + "]";
	}
	
	
	
	
	
}
