package com.kh.lgtw.employee.model.vo;

public class DeptVo {
	private String deptCode;
	private String deptName;
	private String topDept;
	private int managerEmpNo;
	private int level;

	public DeptVo() {}

	public DeptVo(String deptCode, String deptName, String topDept, int managerEmpNo, int level) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.topDept = topDept;
		this.managerEmpNo = managerEmpNo;
		this.level = level;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getTopDept() {
		return topDept;
	}

	public void setTopDept(String topDept) {
		this.topDept = topDept;
	}

	public int getManagerEmpNo() {
		return managerEmpNo;
	}

	public void setManagerEmpNo(int managerEmpNo) {
		this.managerEmpNo = managerEmpNo;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "DeptVo [deptCode=" + deptCode + ", deptName=" + deptName + ", topDept=" + topDept + ", managerEmpNo="
				+ managerEmpNo + ", level=" + level + "]";
	}

	

	
	
}
