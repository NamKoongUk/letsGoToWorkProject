package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

public class Employee {
	private int empNo;
	private String empId;
	private String empPwd;
	private String empName;
	private Date empBirth;
	private String gender;
	private String empPhone;
	
	public Employee() {}

	public Employee(int empNo, String empId, String empPwd, String empName, Date empBirth, String gender,
			String empPhone) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empBirth = empBirth;
		this.gender = gender;
		this.empPhone = empPhone;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public Date getEmpBirth() {
		return empBirth;
	}

	public String getGender() {
		return gender;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName
				+ ", empBirth=" + empBirth + ", gender=" + gender + ", empPhone=" + empPhone + "]";
	}

	
}
