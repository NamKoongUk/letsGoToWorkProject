package com.kh.lgtw.mail.model.vo;

import java.sql.Date;

import com.kh.lgtw.common.model.vo.Attachment;

public class Mail implements java.io.Serializable{
	private int mailNo; 				// 메일번호
	private String mTitle;				// 제목
	private String mContent;			// 내용
	private Object objContent;			// 내용
	private String sendMail;			// 보내는메일
	private String reciveMail;			// 받는메일
	private String dStatus;				// 삭제여부
	private Date sendDate;				// 보낸날짜
	private java.util.Date sendStringDate; // 보낸날짜 String 
	private String rStatus;				// 읽음여부
	private String mailType;			// 메일 종류
	private int mSize;					// 용량
	private String reservationCheck;	// 예약여부
	private Date reservationDate;		// 예약일
	private Date reservationTime;		// 예약시간
	private String empName;				// 사원 이름
	private String deptName;			// 부서명
	private String jobName;				// 직책이름
	private Attachment mailAtt;			// 메일 첨부파일이 존재하는 경우

	public Mail() {}

	public Attachment getMailAtt() {
		return mailAtt;
	}

	public void setMailAtt(Attachment mailAtt) {
		this.mailAtt = mailAtt;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public Object getObjContent() {
		return objContent;
	}

	public void setObjContent(Object objContent) {
		this.objContent = objContent;
	}

	public String getSendMail() {
		return sendMail;
	}

	public void setSendMail(String sendMail) {
		this.sendMail = sendMail;
	}

	public String getReciveMail() {
		return reciveMail;
	}

	public void setReciveMail(String reciveMail) {
		this.reciveMail = reciveMail;
	}

	public String getdStatus() {
		return dStatus;
	}

	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public java.util.Date getSendStringDate() {
		return sendStringDate;
	}

	public void setSendStringDate(java.util.Date sendStringDate) {
		this.sendStringDate = sendStringDate;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
	}

	public int getmSize() {
		return mSize;
	}

	public void setmSize(int mSize) {
		this.mSize = mSize;
	}

	public String getReservationCheck() {
		return reservationCheck;
	}

	public void setReservationCheck(String reservationCheck) {
		this.reservationCheck = reservationCheck;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	@Override
	public String toString() {
		return "Mail [mailNo=" + mailNo + ", mTitle=" + mTitle + ", mContent=" + mContent + ", objContent=" + objContent
				+ ", sendMail=" + sendMail + ", reciveMail=" + reciveMail + ", dStatus=" + dStatus + ", sendDate="
				+ sendDate + ", sendStringDate=" + sendStringDate + ", rStatus=" + rStatus + ", mailType=" + mailType
				+ ", mSize=" + mSize + ", reservationCheck=" + reservationCheck + ", reservationDate=" + reservationDate
				+ ", reservationTime=" + reservationTime + ", empName=" + empName + ", deptName=" + deptName
				+ ", jobName=" + jobName + ", mailAtt=" + mailAtt + "]";
	}

}
