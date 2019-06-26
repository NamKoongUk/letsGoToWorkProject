package com.kh.lgtw.scheduler.model.vo;

import java.io.Serializable;

public class GroupMember implements Serializable{
	private int invitationNo;
	private int schedulerNo;
	private int empNo;
	private String authority;
	
	public GroupMember() {}

	public GroupMember(int invitationNo, int schedulerNo, int empNo, String authority) {
		super();
		this.invitationNo = invitationNo;
		this.schedulerNo = schedulerNo;
		this.empNo = empNo;
		this.authority = authority;
	}

	public int getInvitationNo() {
		return invitationNo;
	}

	public int getSchedulerNo() {
		return schedulerNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getAuthority() {
		return authority;
	}

	public void setInvitationNo(int invitationNo) {
		this.invitationNo = invitationNo;
	}

	public void setSchedulerNo(int schedulerNo) {
		this.schedulerNo = schedulerNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "GroupMember [invitationNo=" + invitationNo + ", schedulerNo=" + schedulerNo + ", empNo=" + empNo
				+ ", authority=" + authority + "]";
	}
	
	
	
}



























































