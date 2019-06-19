package com.kh.lgtw.scheduler.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Schedule implements Serializable{
	private int scheduleNo;
	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	private String scheduleName;
	private String scheduleContent;
	private String status;
	private String writer;
	private Date createDate;
	private Date modifyDate;
	private int schedulerNo;
	
	public Schedule() {}

	public Schedule(int scheduleNo, Date startDate, Date endDate, String startTime, String endTime, String scheduleName,
			String scheduleContent, String status, String writer, Date createDate, Date modifyDate, int schedulerNo) {
		super();
		this.scheduleNo = scheduleNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.scheduleName = scheduleName;
		this.scheduleContent = scheduleContent;
		this.status = status;
		this.writer = writer;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.schedulerNo = schedulerNo;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public String getStatus() {
		return status;
	}

	public String getWriter() {
		return writer;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public int getSchedulerNo() {
		return schedulerNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setSchedulerNo(int schedulerNo) {
		this.schedulerNo = schedulerNo;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", scheduleName=" + scheduleName
				+ ", scheduleContent=" + scheduleContent + ", status=" + status + ", writer=" + writer + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", schedulerNo=" + schedulerNo + "]";
	}
	
	
	
	
}
