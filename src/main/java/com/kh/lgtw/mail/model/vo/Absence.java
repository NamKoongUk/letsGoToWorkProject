package com.kh.lgtw.mail.model.vo;

import java.sql.Date;

public class Absence implements java.io.Serializable{
	private int aNo;
	private Date startDate;
	private Date endDate;
	private String aKind;
	private String content;
	private String dStatus;
	private int empNo;

	public Absence() {}

	public Absence(int aNo, Date startDate, Date endDate, String aKind, String content, String dStatus, int empNo) {
		super();
		this.aNo = aNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.aKind = aKind;
		this.content = content;
		this.dStatus = dStatus;
		this.empNo = empNo;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getaKind() {
		return aKind;
	}

	public void setaKind(String aKind) {
		this.aKind = aKind;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getdStatus() {
		return dStatus;
	}

	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@Override
	public String toString() {
		return "Absence [aNo=" + aNo + ", startDate=" + startDate + ", endDate=" + endDate + ", aKind=" + aKind
				+ ", content=" + content + ", dStatus=" + dStatus + ", empNo=" + empNo + "]";
	}
}
