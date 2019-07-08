package com.kh.lgtw.ses.app;

// 열거형 form?
public enum SESFrom {
	
	ATTA("atta@lgtw.ga", "SES TEST atta"),
	NO_REPLY("noreply@lgtw.ga", "no reply test"),
	SUPPORT("support@lgatw.ga", "SES support");
	
	private final String email;
	private final String name;
	
	private SESFrom(String email, String name) {
		this.email = email;
		this.name = name;
	} 
	
	public String getEmail() {
		return email; 
	}
	
	public String getName() {
		return name;
	}
	
}
