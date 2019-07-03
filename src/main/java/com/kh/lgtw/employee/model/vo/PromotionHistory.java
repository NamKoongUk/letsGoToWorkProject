package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

public class PromotionHistory {
	private int phNo;
	private int empNo;
	private Date modify_Date;
	private String jobCode;
	
	public PromotionHistory() {}

	public PromotionHistory(int phNo, int empNo, Date modify_Date, String jobCode) {
		super();
		this.phNo = phNo;
		this.empNo = empNo;
		this.modify_Date = modify_Date;
		this.jobCode = jobCode;
	}

	public int getPhNo() {
		return phNo;
	}

	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getModify_Date() {
		return modify_Date;
	}

	public void setModify_Date(Date modify_Date) {
		this.modify_Date = modify_Date;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	@Override
	public String toString() {
		return "PromotionHistory [phNo=" + phNo + ", empNo=" + empNo + ", modify_Date=" + modify_Date + ", jobCode="
				+ jobCode + "]";
	}
	
	
}
