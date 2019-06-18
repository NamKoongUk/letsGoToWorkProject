package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AppForm implements Serializable{
	private int afNo;
	private String agName;
	private String afAlias;
	private String afComment;
	private Date afDate;
	private String afContent;
	private String securityCode;
	private String signCode;
	private String signName;
	private String signContent;
	
	public AppForm() {}

	public AppForm(int afNo, String agName, String afAlias, String afComment, Date afDate, String afContent,
			String securityCode, String signCode, String signName, String signContent) {
		super();
		this.afNo = afNo;
		this.agName = agName;
		this.afAlias = afAlias;
		this.afComment = afComment;
		this.afDate = afDate;
		this.afContent = afContent;
		this.securityCode = securityCode;
		this.signCode = signCode;
		this.signName = signName;
		this.signContent = signContent;
	}

	public int getAfNo() {
		return afNo;
	}

	public void setAfNo(int afNo) {
		this.afNo = afNo;
	}

	public String getAgName() {
		return agName;
	}

	public void setAgName(String agName) {
		this.agName = agName;
	}

	public String getAfAlias() {
		return afAlias;
	}

	public void setAfAlias(String afAlias) {
		this.afAlias = afAlias;
	}

	public String getAfComment() {
		return afComment;
	}

	public void setAfComment(String afComment) {
		this.afComment = afComment;
	}

	public Date getAfDate() {
		return afDate;
	}

	public void setAfDate(Date afDate) {
		this.afDate = afDate;
	}

	public String getAfContent() {
		return afContent;
	}

	public void setAfContent(String afContent) {
		this.afContent = afContent;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignContent() {
		return signContent;
	}

	public void setSignContent(String signContent) {
		this.signContent = signContent;
	}

	@Override
	public String toString() {
		return "AppForm [afNo=" + afNo + ", agName=" + agName + ", afAlias=" + afAlias + ", afComment=" + afComment
				+ ", afDate=" + afDate + ", afContent=" + afContent + ", securityCode=" + securityCode + ", signCode="
				+ signCode + ", signName=" + signName + ", signContent=" + signContent + "]";
	}
	
	
}
