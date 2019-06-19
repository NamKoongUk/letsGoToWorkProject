package com.kh.lgtw.scheduler.model.vo;

import java.io.Serializable;

public class Scheduler implements Serializable{
	private int schedulerNo;
	private String schedulerName;
	private String schedulerType;
	private int createEmpNo;
	
	public Scheduler() {}

	public Scheduler(int schedulerNo, String schedulerName, String schedulerType, int createEmpNo) {
		super();
		this.schedulerNo = schedulerNo;
		this.schedulerName = schedulerName;
		this.schedulerType = schedulerType;
		this.createEmpNo = createEmpNo;
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

	@Override
	public String toString() {
		return "Scheduler [schedulerNo=" + schedulerNo + ", schedulerName=" + schedulerName + ", schedulerType="
				+ schedulerType + ", createEmpNo=" + createEmpNo + "]";
	}
	
	
	
}
