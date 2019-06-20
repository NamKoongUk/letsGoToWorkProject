package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;

public class SignForm implements Serializable{
	private String signCode;
	private String signName;
	private String signContent;
	
	public SignForm() {}

	public SignForm(String signCode, String signName, String signContent) {
		super();
		this.signCode = signCode;
		this.signName = signName;
		this.signContent = signContent;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignContent() {
		return signContent;
	}

	public void setSignContent(String signContent) {
		this.signContent = signContent;
	}

	@Override
	public String toString() {
		return "SignForm [signCode=" + signCode + ", signName=" + signName + ", signContent=" + signContent + "]";
	}
	
	
	
}
