package com.kh.lgtw.community.model.vo;

public class CommunityAttachment  implements java.io.Serializable
{
	
	private int attno; //파일 번호
	private int psno; //게시글 번호
	private String changName;//변경파일명 
	private String originName;//원본파일명 
	private String filePath;//파일경로 
	private String fileType;//파일종류 
	
	
	
	public CommunityAttachment () {}



	public CommunityAttachment(int attno, int psno, String changName, String originName, String filePath,
			String fileType) {
		super();
		this.attno = attno;
		this.psno = psno;
		this.changName = changName;
		this.originName = originName;
		this.filePath = filePath;
		this.fileType = fileType;
	}



	public int getAttno() {
		return attno;
	}



	public void setAttno(int attno) {
		this.attno = attno;
	}



	public int getPsno() {
		return psno;
	}



	public void setPsno(int psno) {
		this.psno = psno;
	}



	public String getChangName() {
		return changName;
	}



	public void setChangName(String changName) {
		this.changName = changName;
	}



	public String getOriginName() {
		return originName;
	}



	public void setOriginName(String originName) {
		this.originName = originName;
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



	@Override
	public String toString() {
		return "CommunityAttachment [attno=" + attno + ", psno=" + psno + ", changName=" + changName + ", originName="
				+ originName + ", filePath=" + filePath + ", fileType=" + fileType + "]";
	}
	
	
	
	
	
	
	
	
}
