package com.kh.lgtw.mail.model.vo;

public class ListCondition {
	private String listType; 	// 페이지 유형 - all, recive, send, outbox, trash
	private String sName; 		// 이름으로 검색
	private String sTitle;		// 제목으로 검색
	private String sContent;	// 내용으로 검색
	private String sWriter;

	public ListCondition() {}

	public ListCondition(String listType, String sName, String sTitle, String sContent) {
		super();
		this.listType = listType;
		this.sName = sName;
		this.sTitle = sTitle;
		this.sContent = sContent;
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
		return "ListCondition [listType=" + listType + ", sName=" + sName + ", sTitle=" + sTitle + ", sContent="
				+ sContent + "]";
	}
	
}
