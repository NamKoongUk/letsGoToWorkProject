package com.kh.lgtw.ses.app;

import java.util.Arrays;

public class AmazonAttachment {
	private String name;
	private byte[] content;
	private String contentType;
	public AmazonAttachment(String name, byte[] content, String contentType) {
		super();
		this.name = name;
		this.content = content;
		this.contentType = contentType;
	}
 
	public AmazonAttachment() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "AmazonAttachment [name=" + name + ", content=" + Arrays.toString(content) + ", contentType="
				+ contentType + "]";
	}
	
	
	
}
