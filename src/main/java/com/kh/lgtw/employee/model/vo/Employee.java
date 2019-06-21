package com.kh.lgtw.employee.model.vo;

import java.sql.Date;

public class Employee {
	private int eid;
	private int empNo;
	private String empId;
	private String empPwd;
	private String empName;
	private Date empBirth;
	private String gender;
	private String empPhone;
	
	public Employee() {}

	public Employee(int eid, int empNo, String empId, String empPwd, String empName, Date empBirth, String gender,
			String empPhone) {
		super();
		this.eid = eid;
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empBirth = empBirth;
		this.gender = gender;
		this.empPhone = empPhone;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empNo=" + empNo + ", empId=" + empId + ", empPwd=" + empPwd + ", empName="
				+ empName + ", empBirth=" + empBirth + ", gender=" + gender + ", empPhone=" + empPhone + "]";
	}
}
