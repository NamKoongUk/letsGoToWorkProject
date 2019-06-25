package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ExcelEmp {
	private int empNo= 0;
	private String empId= null;
	private String empPwd= null;
	private String empName= null;
	private Date empBirth= null;
	private String gender= null;
	private String empPhone= null;
	private String address= null;
	private String email= null;
	private String status= null;
	private Date enrollDate= null;
	private String dutyCode= null;
	private CommonsMultipartFile file = null;
	
	public ExcelEmp() {}
	
	
	

	public ExcelEmp(int empNo, String empId, String empPwd, String empName, Date empBirth, String gender,
			String empPhone, String address, String email, String status, Date enrollDate, String dutyCode,
			CommonsMultipartFile file) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empBirth = empBirth;
		this.gender = gender;
		this.empPhone = empPhone;
		this.address = address;
		this.email = email;
		this.status = status;
		this.enrollDate = enrollDate;
		this.dutyCode = dutyCode;
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




	public Date getEmpBirth() {
		return empBirth;
	}




	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getEmpPhone() {
		return empPhone;
	}




	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
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




	public String getDutyCode() {
		return dutyCode;
	}




	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
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
				+ ", empBirth=" + empBirth + ", gender=" + gender + ", empPhone=" + empPhone + ", address=" + address
				+ ", email=" + email + ", status=" + status + ", enrollDate=" + enrollDate + ", dutyCode=" + dutyCode
				+ ", file=" + file + "]";
	}
	
	
}
