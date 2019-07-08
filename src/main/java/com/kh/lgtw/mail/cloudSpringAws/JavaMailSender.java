package com.kh.lgtw.mail.cloudSpringAws;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

@Component
public class JavaMailSender extends JavaMailSenderImpl{
	
	// 보내기 
	@Override
	public void send(SimpleMailMessage simpleMailMessage){
		System.out.println("JavaMailSender에서 send메소드 실행됨!!");
		try {
			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
			System.out.println("ProfileCredential생성 : " + credentialsProvider);
			
			try {
				// 자격증명 가져오기 
				credentialsProvider.getCredentials();
				System.out.println("자격 증명 가져오기 : " + credentialsProvider.getCredentials());
			} catch(Exception e) {
				throw new AmazonClientException("자격증명을 가져오지 못했음!\n자격증명 파일의 위치와 포맷은 (~/.aws/credentials) : " + e);
			}
			    
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
							.withCredentials(credentialsProvider)
							.withRegion("us-east-1")
					 		.build();
			 
			// 메일 전송  
			client.sendEmail(toSendRequest(simpleMailMessage));

			// 메일 전송한다는 로그 남기기 
					
		}catch(Exception exception) {
			System.out.println("이메일 전송에 있어서 에러 발생!");
			System.out.println("메일 에러 : " + exception.getMessage());
			throw new AmazonClientException(exception.getMessage(), exception);
		}
	}
	
	// 메시지 전송요청 메소드
	public SendEmailRequest toSendRequest(SimpleMailMessage smm) {
		
		// 받는 목적지 설정
		Destination destination = new Destination().withToAddresses(smm.getTo());
		
		// 전송하는 메일 내용 설정
		Message message = new Message()
				.withSubject(createContent(smm.getSubject()))
				.withBody(new Body().withHtml(createContent(smm.getText()))); // body는 html형식으로 전송
		
		// 전송할 메일내용을 세팅
		return new SendEmailRequest().withSource(smm.getFrom())
							.withDestination(destination)
							.withMessage(message);
	}
	
	// SimpleEmailService에 Content객체로 바꿔준다.
	private Content createContent(String text) {
		return new Content().withCharset("UTF-8").withData(text);
	}
}
