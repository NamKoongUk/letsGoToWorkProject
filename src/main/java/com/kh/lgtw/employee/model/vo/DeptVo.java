package com.kh.lgtw.employee.model.vo;

public class DeptVo {
	private String deptCode;
	private String deptName;
	private String topDept;

	public DeptVo() {}

	public DeptVo(String deptCode, String deptName, String topDept) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.topDept = topDept;
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

	@Override
	public String toString() {
		return "DeptVo [deptCode=" + deptCode + ", deptName=" + deptName + ", topDept=" + topDept + "]";
	}
	
	
}
