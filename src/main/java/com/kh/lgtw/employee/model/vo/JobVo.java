package com.kh.lgtw.employee.model.vo;

public class JobVo {
	private String jobCode;
	private String jobName;
	private int jobLevel;
	
	public JobVo() {}

	public JobVo(String jobCode, String jobName, int jobLevel) {
		super();
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobLevel = jobLevel;
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

	@Override
	public String toString() {
		return "JobVo [jobCode=" + jobCode + ", jobName=" + jobName + ", jobLevel=" + jobLevel + "]";
	}
	
	
}	
