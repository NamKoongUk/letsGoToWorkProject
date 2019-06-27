package com.kh.lgtw.mail.model.vo;

public class ListCondition {
	private String listType; 	// 페이지 유형 - all, receive, send, outbox, trash
	private String sName; 		// 이름으로 검색  
	private String nameMail;	// 이름으로 검색한 메일  
	private String sTitle;		// 제목으로 검색
	private String sContent;	// 내용으로 검색
	private String sMail;		// 이메일로 검색 

	/*  이름으로 검색
	 *  1. 해당이름의 사원, 이메일 정보 조회
	 *  2. 사원의 이메일로 보내거나 받은 사람을 조회 
	 * */   
	
	public ListCondition() {}

	public ListCondition(String listType, String sName, String nameMail, String sTitle, String sContent,
			String sMail) {
		super();
		this.listType = listType;
		this.sName = sName;
		this.nameMail = nameMail;
		this.sTitle = sTitle;
		this.sContent = sContent;
		this.sMail = sMail;
	}

	public String getNameMail() {
		return nameMail;
	}

	public void setNameMail(String nameMail) {
		this.nameMail = nameMail;
	}

	public String getsMail() {
		return sMail;
	}

	public void setsMail(String sMail) {
		this.sMail = sMail;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	@Override
	public String toString() {
		return "ListCondition [listType=" + listType + ", sName=" + sName + ", nameMail=" + nameMail + ", sTitle="
				+ sTitle + ", sContent=" + sContent + ", sMail=" + sMail + "]";
	}
}
