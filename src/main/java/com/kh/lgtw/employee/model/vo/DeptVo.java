package com.kh.lgtw.employee.model.vo;

public class DeptVo {
	private String deptCode;
	private String deptName;
	private String topDept;
	private int managerEmpNo;

	public DeptVo() {}

	public DeptVo(String deptCode, String deptName, String topDept, int managerEmpNo) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.topDept = topDept;
		this.managerEmpNo = managerEmpNo;
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

	@Override
	public String toString() {
		return "DeptVo [deptCode=" + deptCode + ", deptName=" + deptName + ", topDept=" + topDept + ", managerEmpNo="
				+ managerEmpNo + "]";
	}

	
	
}
