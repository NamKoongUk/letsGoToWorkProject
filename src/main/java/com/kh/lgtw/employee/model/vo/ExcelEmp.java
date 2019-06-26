package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ExcelEmp {
	
	private int empNo= 0;
	private String empId= null;
	private String empPwd= null;
	private String empName= null;
	private String empPhone=null;
	private String status= null;
	private Date enrollDate= null;
	private CommonsMultipartFile file = null;
	
	public ExcelEmp() {}

	public ExcelEmp(int empNo, String empId, String empPwd, String empName, String empPhone, String status,
			Date enrollDate, CommonsMultipartFile file) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empPhone = empPhone;
		this.status = status;
		this.enrollDate = enrollDate;
		this.file = file;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ExcelEmp [empNo=" + empNo + ", empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName
				+ ", empPhone=" + empPhone + ", status=" + status + ", enrollDate=" + enrollDate + ", file=" + file
				+ "]";
	}
	
	
	

	
	
}
