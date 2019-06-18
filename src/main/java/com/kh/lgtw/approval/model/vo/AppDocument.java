package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.apache.ibatis.session.SqlSession;

public class AppDocument implements Serializable{
	private String adNo;
	private String adWriter;
	private String adTitle;
	private String adContent;
	private Date adStartDate;
	private Date adEndDate;
	private String adType;
	private int afNo;
	private String adStatus;
	
	public AppDocument() {}

	public AppDocument(String adNo, String adWriter, String adTitle, String adContent, Date adStartDate, Date adEndDate,
			String adType, int afNo, String adStatus) {
		super();
		this.adNo = adNo;
		this.adWriter = adWriter;
		this.adTitle = adTitle;
		this.adContent = adContent;
		this.adStartDate = adStartDate;
		this.adEndDate = adEndDate;
		this.adType = adType;
		this.afNo = afNo;
		this.adStatus = adStatus;
	}

	public String getAdNo() {
		return adNo;
	}

	public void setAdNo(String adNo) {
		this.adNo = adNo;
	}

	public String getAdWriter() {
		return adWriter;
	}

	public void setAdWriter(String adWriter) {
		this.adWriter = adWriter;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public Date getAdStartDate() {
		return adStartDate;
	}

	public void setAdStartDate(Date adStartDate) {
		this.adStartDate = adStartDate;
	}

	public Date getAdEndDate() {
		return adEndDate;
	}

	public void setAdEndDate(Date adEndDate) {
		this.adEndDate = adEndDate;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public int getAfNo() {
		return afNo;
	}

	public void setAfNo(int afNo) {
		this.afNo = afNo;
	}

	public String getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}

	@Override
	public String toString() {
		return "AppDocument [adNo=" + adNo + ", adWriter=" + adWriter + ", adTitle=" + adTitle + ", adContent="
				+ adContent + ", adStartDate=" + adStartDate + ", adEndDate=" + adEndDate + ", adType=" + adType
				+ ", afNo=" + afNo + ", adStatus=" + adStatus + "]";
	}

	public int saveApprovalDcm(SqlSession session, AppDocument ad) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
