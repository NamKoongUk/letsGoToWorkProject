package com.kh.lgtw.mail.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class Sender implements java.io.Serializable{
	private String from;								// 보내는곳
	private List<String> to = new ArrayList<>();		// 받는곳
	private String subject;								// 제목
	private String content;								// 내용
	 
	public Sender() {}

	public Sender(String from, List<String> to, String subject, String content) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	// 수신자 추가 
	public void addTo(String email){
        this.to.add(email);
    }
	
	// 원래 이거는 MailUtils에 넣어야 하는듯 ?
	// 메일 전송 
	public SendEmailRequest toSendRequest() {
		// 받는 목적지 설정
		Destination destination = new Destination().withToAddresses(this.to);
		
		// 전송하는 메일 내용 설정
		Message message = new Message()
				.withSubject(createContent(this.subject))
				.withBody(new Body().withHtml(createContent(this.content))); // body는 html형식으로 전송
		
		// 전송할 메일내용을 세팅
		return new SendEmailRequest().withSource(this.from)
							.withDestination(destination)
							.withMessage(message);
	}
	
	// SimpleEmailService에 Content객체로 바꿔준다.
	private Content createContent(String text) {
		return new Content().withCharset("UTF-8").withData(text);
	}
	
	
	

}
