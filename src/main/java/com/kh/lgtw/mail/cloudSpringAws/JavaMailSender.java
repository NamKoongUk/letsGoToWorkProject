package com.kh.lgtw.mail.cloudSpringAws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.auth.profile.internal.Profile;
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
			
			// toSendRequest와 같은 코드임 
//			SendEmailRequest request = new SendEmailRequest()
//						.withDestination(new Destination()
//									.withToAddresses(simpleMailMessage.getTo()))
//									.withMessage(new Message()
//											.withSubject(createContent(simpleMailMessage.getSubject()))
//											.withBody(new Body().withHtml(createContent(simpleMailMessage.getText()))));
			
			// 메일 전송한다는 로그 남기기 
		}catch(Exception exception) {
			System.out.println("이메일 전송에 있어서 에러 발생!");
			System.out.println("메일 에러 : " + exception.getMessage());
			throw new AmazonClientException(exception.getMessage(), exception);
		}
	}
	
	public void send(SimpleMailMessage simpleMailMessage, File attachment){
		System.out.println("JavaMailSender에서 send메소드 실행됨!!");
		
		/*  190709
		 *  참고 : https://docs.aws.amazon.com/ko_kr/ses/latest/DeveloperGuide/send-email-raw.html*/ 
		// 첨부파일 메시지를 만들 수 있는 mimeMessage 객체 생성  // 세션에서 디폴트를 가져온다..?
		MimeMessage mimeMessage = new MimeMessage(Session.getDefaultInstance(new Properties()));
		
		Body bodyMsg = new Body().withHtml(createContent(simpleMailMessage.getText()));
		// multipart/alternative 자식 컨테이너 생성
		System.out.println("alternative 출력물 ");
		MimeMultipart msg_body = new MimeMultipart("alternative");
		System.out.println(msg_body.getContentType());
		try {
			// msg_body.setPreamble();
			System.out.println(msg_body.getPreamble());
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
		
		// html과 text부분 래퍼를 생성한다. 
		MimeBodyPart wrap = new MimeBodyPart();
		// test part 정의
		MimeBodyPart textPart = new MimeBodyPart();
		// htmlPart 정의 
		MimeBodyPart htmlPart = new MimeBodyPart();
		// multipart/mixed 부모 컨테이너 생성
		MimeMultipart msg = new MimeMultipart("mixed");

		// Attachment 정의 
		MimeBodyPart att = new MimeBodyPart();
		DataSource fds = new FileDataSource(attachment);
		
		try {
			mimeMessage.setSubject(simpleMailMessage.getSubject(), "UTF-8");
			mimeMessage.setFrom(new InternetAddress(simpleMailMessage.getFrom()));
			mimeMessage.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(simpleMailMessage.getTo()[0]));
			System.out.println("mimeMessage recipients : " + mimeMessage.getRecipients(MimeMessage.RecipientType.TO));
			
			textPart.setContent(bodyMsg, "text/plain; charset=UTF-8");
			htmlPart.setContent(bodyMsg, "text/html; charset=UTF-8");
			
			wrap.setContent(msg_body);
//			System.out.println("wrap : " + wrap);
//			System.out.println("wrap : " + wrap.getFileName());
//			System.out.println("wrap : " + wrap.getContentType());
			// wrap.setContent(mp); // multipart type으로 넣어주어야 함
			
			mimeMessage.setContent(msg);
			msg.addBodyPart(wrap);
			
			att.setDataHandler(new DataHandler(fds));
			att.setFileName(fds.getName());
			msg.addBodyPart(att);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		/* 190709 작성 끝부분  */
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
			System.out.println("client : " + client.toString());
			 
			// 메일 전송  
			// client.sendEmail(toSendRequest(simpleMailMessage)); // 이거 쓰려면 toSendRequest를 풀어야 한다.
			
			// 콘솔창에 context내용 출력
			System.out.println("\n\n context출력 시작 :");
			PrintStream out = System.out;
			mimeMessage.writeTo(out);
			System.out.println("context출력 완료 \n\n");
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			System.out.println("스트림 생성완료 ");
			mimeMessage.writeTo(outputStream);
			System.out.println("메시지에 작성하기 완료 ");
			RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));
			System.out.println("rawMessage : " + rawMessage);
			
			SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);
			
			System.out.println("rawEmailSend직전 request : " + rawEmailRequest);
			client.sendRawEmail(rawEmailRequest);
			System.out.println("apdlf 메일 전송!");
			
			// toSendRequest와 같은 코드임 
//			SendEmailRequest request = new SendEmailRequest()
//						.withDestination(new Destination()
//									.withToAddresses(simpleMailMessage.getTo()))
//									.withMessage(new Message()
//											.withSubject(createContent(simpleMailMessage.getSubject()))
//											.withBody(new Body().withHtml(createContent(simpleMailMessage.getText()))));
			
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
