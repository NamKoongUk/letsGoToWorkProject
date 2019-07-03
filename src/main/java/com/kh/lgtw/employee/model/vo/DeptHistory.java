package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

public class DeptHistory {
	private int dhNo;
	private int empNo;
	private Date modifyDate;
	private String deptCode;
	
	public DeptHistory() {}

	public DeptHistory(int dhNo, int empNo, Date modifyDate, String deptCode) {
		super();
		this.dhNo = dhNo;
		this.empNo = empNo;
		this.modifyDate = modifyDate;
		this.deptCode = deptCode;
	}

	public int getDhNo() {
		return dhNo;
	}

	public void setDhNo(int dhNo) {
		this.dhNo = dhNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "DeptHistory [dhNo=" + dhNo + ", empNo=" + empNo + ", modifyDate=" + modifyDate + ", deptCode="
				+ deptCode + "]";
	}
	
	
	
}
