package com.kh.lgtw.mail.model.vo;

import java.util.ArrayList;

import com.kh.lgtw.employee.model.vo.Employee;

public class CommonMail implements java.io.Serializable{
	private int omNo; 
	private String omName;
	private String email;
	private String memo;
	private String useYN;
	private ArrayList<Employee> mailMember;  		// 공용 메일 멤버
	
	public CommonMail() {}

	public CommonMail(int omNo, String omName, String email, String memo, String useYN,
			ArrayList<Employee> mailMember) {
		super();
		this.omNo = omNo;
		this.omName = omName;
		this.email = email;
		this.memo = memo;
		this.useYN = useYN;
		this.mailMember = mailMember;
	}

	public ArrayList<Employee> getMailMember() {
		return mailMember;
	}

	public void setMailMember(ArrayList<Employee> mailMember) {
		this.mailMember = mailMember;
	}

	public int getOmNo() {
		return omNo;
	}

	public void setOmNo(int omNo) {
		this.omNo = omNo;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUseYN() {
		return useYN;
	}

	public void setUseYN(String useYN) {
		this.useYN = useYN;
	}

	@Override
	public String toString() {
		return "CommonMail [omNo=" + omNo + ", omName=" + omName + ", email=" + email + ", memo=" + memo + ", useYN="
				+ useYN + ", mailMember=" + mailMember + "]";
	}
}
