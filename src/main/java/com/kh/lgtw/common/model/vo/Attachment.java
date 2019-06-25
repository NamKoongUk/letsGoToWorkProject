package com.kh.lgtw.common.model.vo;

public class Attachment implements java.io.Serializable{
	private int attNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String fileType; 	// 파일 종류 - 휴가, 메일, 게시글, 결재, 프로필
	// FK속성
	private int requestNo; 		// 휴가신청번호
	private int mailNo;			// 메일 번호 
	private int contentNo;		// 게시글 번호
	private String adNo;		// 결재문서번호
	private int empNo;			// 사원번호
	
	public Attachment() {}

	public Attachment(int attNo, String originName, String changeName, String filePath, String fileType, int requestNo,
			int mailNo, int contentNo, String adNo, int empNo) {
		super();
		this.attNo = attNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.requestNo = requestNo;
		this.mailNo = mailNo;
		this.contentNo = contentNo;
		this.adNo = adNo;
		this.empNo = empNo;
	}

	public Attachment(int attNo, String originName, String changeName, String filePath, String fileType) {
		super();
		this.attNo = attNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileType = fileType;
	}

	public int getAttNo() {
		return attNo;
	}

	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public String getAdNo() {
		return adNo;
	}

	public void setAdNo(String adNo) {
		this.adNo = adNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "Attachment [attNo=" + attNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", fileType=" + fileType + ", requestNo=" + requestNo + ", mailNo="
				+ mailNo + ", contentNo=" + contentNo + ", adNo=" + adNo + ", empNo=" + empNo + "]";
	}
}
