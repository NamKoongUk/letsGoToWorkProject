package com.kh.lgtw.mail.model.vo;

import java.sql.Date;

public class Mail implements java.io.Serializable{
	private int mailNo; 				// 메일번호
	private String mTitle;				// 제목
	private String mContent;			// 내용
	private String sendMail;			// 보내는메일
	private String reciveMail;			// 받는메일
	private String dStatus;				// 삭제여부
	private Date sendDate;				// 보낸날짜
	private String rStatus;				// 읽음여부
	private String mailType;			// 메일 종류
	private int mSize;					// 용량
	private String reservationCheck;	// 예약여부
	private Date reservationDate;		// 예약일
	private Date reservationTime;		// 예약시간

	public Mail() {}

	public Mail(int mailNo, String mTitle, String mContent, String sendMail, String reciveMail, String dStatus,
			Date sendDate, String rStatus, String mailType, int mSize, String reservationCheck, Date reservationDate,
			Date reservationTime) {
		super();
		this.mailNo = mailNo;
		this.mTitle = mTitle;
		this.mContent = mContent;
		this.sendMail = sendMail;
		this.reciveMail = reciveMail;
		this.dStatus = dStatus;
		this.sendDate = sendDate;
		this.rStatus = rStatus;
		this.mailType = mailType;
		this.mSize = mSize;
		this.reservationCheck = reservationCheck;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
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

	public String getMailType() {
		return mailType;
	}

	public void setMailType(String mailType) {
		this.mailType = mailType;
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

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
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
		return "Mail [mailNo=" + mailNo + ", mTitle=" + mTitle + ", mContent=" + mContent + ", sendMail=" + sendMail
				+ ", reciveMail=" + reciveMail + ", dStatus=" + dStatus + ", sendDate=" + sendDate + ", rStatus="
				+ rStatus + ", mailType=" + mailType + ", mSize=" + mSize + ", reservationCheck=" + reservationCheck
				+ ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + "]";
	}
}
