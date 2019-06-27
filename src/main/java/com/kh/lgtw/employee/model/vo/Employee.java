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
	private String officeTel;
	private String address;
	private String email;
	private String managerType;
	private String status;
	private Date enrollDate;
	private Date retirementDate;
	private String otherInfo;
	private String personalInfoCheck;
	private int refEmpNo;
	private Date lstartDate;
	private Date lendDate;
	private String leaveTerm;
	private String leaveReason;
	private String retirementReason;
	private String leaveType;
	
	public Employee() {}

	public Employee(int empNo, String empId, String empPwd, String empName, Date empBirth, String gender,
			String empPhone, String officeTel, String address, String email, String managerType, String status,
			Date enrollDate, Date retirementDate, String otherInfo, String personalInfoCheck, int refEmpNo,
			Date lstartDate, Date lendDate, String leaveTerm, String leaveReason, String retirementReason,
			String leaveType) {
		super();
		this.empNo = empNo;
		this.empId = empId;
		this.empPwd = empPwd;
		this.empName = empName;
		this.empBirth = empBirth;
		this.gender = gender;
		this.empPhone = empPhone;
		this.officeTel = officeTel;
		this.address = address;
		this.email = email;
		this.managerType = managerType;
		this.status = status;
		this.enrollDate = enrollDate;
		this.retirementDate = retirementDate;
		this.otherInfo = otherInfo;
		this.personalInfoCheck = personalInfoCheck;
		this.refEmpNo = refEmpNo;
		this.lstartDate = lstartDate;
		this.lendDate = lendDate;
		this.leaveTerm = leaveTerm;
		this.leaveReason = leaveReason;
		this.retirementReason = retirementReason;
		this.leaveType = leaveType;
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

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
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

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
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

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getPersonalInfoCheck() {
		return personalInfoCheck;
	}

	public void setPersonalInfoCheck(String personalInfoCheck) {
		this.personalInfoCheck = personalInfoCheck;
	}

	public int getRefEmpNo() {
		return refEmpNo;
	}

	public void setRefEmpNo(int refEmpNo) {
		this.refEmpNo = refEmpNo;
	}

	public Date getLstartDate() {
		return lstartDate;
	}

	public void setLstartDate(Date lstartDate) {
		this.lstartDate = lstartDate;
	}

	public Date getLendDate() {
		return lendDate;
	}

	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}

	public String getLeaveTerm() {
		return leaveTerm;
	}

	public void setLeaveTerm(String leaveTerm) {
		this.leaveTerm = leaveTerm;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getRetirementReason() {
		return retirementReason;
	}

	public void setRetirementReason(String retirementReason) {
		this.retirementReason = retirementReason;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName
				+ ", empBirth=" + empBirth + ", gender=" + gender + ", empPhone=" + empPhone + ", officeTel="
				+ officeTel + ", address=" + address + ", email=" + email + ", managerType=" + managerType + ", status="
				+ status + ", enrollDate=" + enrollDate + ", retirementDate=" + retirementDate + ", otherInfo="
				+ otherInfo + ", personalInfoCheck=" + personalInfoCheck + ", refEmpNo=" + refEmpNo + ", lstartDate="
				+ lstartDate + ", lendDate=" + lendDate + ", leaveTerm=" + leaveTerm + ", leaveReason=" + leaveReason
				+ ", retirementReason=" + retirementReason + ", leaveType=" + leaveType + "]";
	}
	
	
	
	
}
