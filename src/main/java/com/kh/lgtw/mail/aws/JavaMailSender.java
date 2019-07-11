package com.kh.lgtw.mail.aws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
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
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;

@Component
public class JavaMailSender extends JavaMailSenderImpl{
	
	// 일반 메일 보내기 
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
			    
			// Amazon SES에 액새스 하기 위한 인터페이스, Amazin SES 사용자 빌드하는 클래스
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
							.withCredentials(credentialsProvider)
							.withRegion("us-east-1")
					 		.build();
			System.out.println("client : " + client.toString());
			 
			// 메일 전송  
			client.sendEmail(toSendRequest(simpleMailMessage)); // 이거 쓰려면 toSendRequest를 풀어야 한다.
			
			// 메일 전송한다는 로그 남기기 
		}catch(Exception exception) {
			System.out.println("이메일 전송에 있어서 에러 발생!");
			System.out.println("메일 에러 : " + exception.getMessage());
			throw new AmazonClientException(exception.getMessage(), exception);
		}
	}
	
	// 0710 수정하고 다시 작성한 코드 
	// 참고 자료 : https://stackoverflow.com/questions/7963439/example-of-sending-an-email-with-attachment-via-amazon-in-java
	public void send(SimpleMailMessage simpleMailMessage, File attachment){
		System.out.println("JavaMailSender에서 send메소드 실행됨!!");
		
		javax.mail.Message mimeMessage = new MimeMessage(Session.getDefaultInstance(new Properties()));
		System.out.println("AWS Session을 가져와야 하는 곳 : " + Session.getDefaultInstance(new Properties()));

		try {
			mimeMessage.setFrom(new InternetAddress(simpleMailMessage.getFrom()));
			mimeMessage.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(simpleMailMessage.getTo()[0]));
			mimeMessage.setSubject(simpleMailMessage.getSubject());
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(simpleMailMessage.getText());
			
			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String fileName = attachment.getName();
			DataSource source = new FileDataSource(attachment.getPath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			multipart.addBodyPart(messageBodyPart);
			
			mimeMessage.setContent(multipart);
		
		} catch (MessagingException e1) {
			System.out.println("mimeMessage에서 에러 발생");
			System.out.println("메시징 에러 : " + e1.getMessage());
		}
		
		try {
			ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
			System.out.println("ProfileCredential생성 : " + credentialsProvider);
			
			try {
				// 자격증명 가져오기 
				System.out.println("자격 증명 가져오기 : " + credentialsProvider.getCredentials());
			} catch(Exception e) {
				throw new AmazonClientException("자격증명을 가져오지 못했음!\n자격증명 파일의 위치와 포맷은 (~/.aws/credentials) : " + e);
			}
			    
			// Amazon SES에 액새스 하기 위한 인터페이스, Amazin SES 사용자 빌드하는 클래스
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
							.withCredentials(credentialsProvider)
							.withRegion("us-east-1")
					 		.build();
			 
			// 메일 전송  
			// client.sendEmail(toSendRequest(simpleMailMessage)); // 이거 쓰려면 toSendRequest를 풀어야 한다.
			
			// 콘솔창에 context내용 출력
			System.out.println("\n\n context출력 시작 :");
			PrintStream out = System.out;
			mimeMessage.writeTo(out);
			System.out.println("context출력 완료 \n\n");
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			mimeMessage.writeTo(outputStream);
			RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));
			
			SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);
			
			client.sendRawEmail(rawEmailRequest);
			System.out.println("첨부파일 메일 전송완료!");
			
		// 메일 전송한다는 로그 남기기 
		}catch(Exception exception) {
			System.out.println("이메일 전송에 있어서 에러 발생!");
			System.out.println("메일 에러 : " + exception.getMessage());
			throw new AmazonClientException(exception.getMessage(), exception);
		}
	}
	
	// 메시지 전송요자 생성 메소드
	public SendEmailRequest toSendRequest(SimpleMailMessage simpleMailMessage) {
		
		// 받는 목적지 설정
		Destination destination = new Destination().withToAddresses(simpleMailMessage.getTo());
		
		// 전송하는 메일 내용 설정
		// 일반 메시지 전송
		Message message = new Message()
				.withSubject(createContent(simpleMailMessage.getSubject()))
				.withBody(new Body().withHtml(createContent(simpleMailMessage.getText()))); // body는 html형식으로 전송
		System.out.println(message.getBody());
		
		
		// 전송할 메일내용을 세팅
		return new SendEmailRequest().withSource(simpleMailMessage.getFrom())
							.withDestination(destination)
							.withMessage(message);
	}
	
	// SimpleEmailService에 Content객체로 바꿔준다.
	private Content createContent(String text) {
		return new Content().withCharset("UTF-8").withData(text);
	}
}
