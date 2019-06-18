package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;

public class SignLine implements Serializable{
	private int slNo;
	private int slMno;
	private String slType;
	private int seNo;
	private int seLevel;
	private String mno;
	
	public SignLine(int slNo, int slMno, String slType, int seNo, int seLevel, String mno) {
		super();
		this.slNo = slNo;
		this.slMno = slMno;
		this.slType = slType;
		this.seNo = seNo;
		this.seLevel = seLevel;
		this.mno = mno;
	}
	
	public SignLine() {}

	public int getSlNo() {
		return slNo;
	}

	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	public int getSlMno() {
		return slMno;
	}

	public void setSlMno(int slMno) {
		this.slMno = slMno;
	}

	public String getSlType() {
		return slType;
	}

	public void setSlType(String slType) {
		this.slType = slType;
	}

	public int getSeNo() {
		return seNo;
	}

	public void setSeNo(int seNo) {
		this.seNo = seNo;
	}

	public int getSeLevel() {
		return seLevel;
	}

	public void setSeLevel(int seLevel) {
		this.seLevel = seLevel;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "SignLine [slNo=" + slNo + ", slMno=" + slMno + ", slType=" + slType + ", seNo=" + seNo + ", seLevel="
				+ seLevel + ", mno=" + mno + "]";
	}
	
	
	
}
