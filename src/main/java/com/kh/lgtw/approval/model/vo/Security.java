package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Security implements Serializable{
	private String securityCode;
	private String securityGrade;
	private String jobCode;
	private String jobName;
	private int jobLevel;
	private ArrayList<HashMap<String, Object>> jobList;
	
	public Security() {}

	
	
	public Security(String securityCode, String securityGrade, String jobCode, String jobName, int jobLevel,
			ArrayList<HashMap<String, Object>> jobList) {
		super();
		this.securityCode = securityCode;
		this.securityGrade = securityGrade;
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobLevel = jobLevel;
		this.jobList = jobList;
	}



	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSecurityGrade() {
		return securityGrade;
	}

	public void setSecurityGrade(String securityGrade) {
		this.securityGrade = securityGrade;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public ArrayList<HashMap<String, Object>> getJobList() {
		return jobList;
	}

	public void setJobList(ArrayList<HashMap<String, Object>> jobList) {
		this.jobList = jobList;
	}



	@Override
	public String toString() {
		return "Security [securityCode=" + securityCode + ", securityGrade=" + securityGrade + ", jobCode=" + jobCode
				+ ", jobName=" + jobName + ", jobLevel=" + jobLevel + ", jobList=" + jobList + "]";
	}

	

	
	
	
}
