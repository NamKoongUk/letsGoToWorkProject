package com.kh.lgtw.scheduler.model.vo;

import java.io.Serializable;

public class Scheduler implements Serializable{
	private int schedulerNo;
	private String schedulerName;
	private String schedulerType;
	private int createEmpNo;
	private String schedulerColor;
	private String status;
	
	public Scheduler() {}

	public Scheduler(int schedulerNo, String schedulerName, String schedulerType, int createEmpNo,
			String schedulerColor, String status) {
		super();
		this.schedulerNo = schedulerNo;
		this.schedulerName = schedulerName;
		this.schedulerType = schedulerType;
		this.createEmpNo = createEmpNo;
		this.schedulerColor = schedulerColor;
		this.status = status;
	}

	public int getSchedulerNo() {
		return schedulerNo;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public String getSchedulerType() {
		return schedulerType;
	}

	public int getCreateEmpNo() {
		return createEmpNo;
	}

	public String getSchedulerColor() {
		return schedulerColor;
	}

	public String getStatus() {
		return status;
	}

	public void setSchedulerNo(int schedulerNo) {
		this.schedulerNo = schedulerNo;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public void setSchedulerType(String schedulerType) {
		this.schedulerType = schedulerType;
	}

	public void setCreateEmpNo(int createEmpNo) {
		this.createEmpNo = createEmpNo;
	}

	public void setSchedulerColor(String schedulerColor) {
		this.schedulerColor = schedulerColor;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Scheduler [schedulerNo=" + schedulerNo + ", schedulerName=" + schedulerName + ", schedulerType="
				+ schedulerType + ", createEmpNo=" + createEmpNo + ", schedulerColor=" + schedulerColor + ", status="
				+ status + "]";
	}

	

	
	
	
	
}
