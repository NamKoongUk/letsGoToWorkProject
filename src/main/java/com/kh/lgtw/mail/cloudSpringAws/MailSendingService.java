package com.kh.lgtw.mail.cloudSpringAws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.kh.lgtw.mail.model.vo.Sender;
@Component
public class MailSendingService {
	@Autowired private JavaMailSender mailSender; // javaMailSender만들기
	private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	
	public  MailSendingService() {}
	
	public void sendMailMessage() {
		System.out.println("MailSendingService에 sendMailMessag실행");
		simpleMailMessage.setFrom("admin@lgtw.ga");
		simpleMailMessage.setTo("cymkim0917@naver.com");
		simpleMailMessage.setSubject("test subject");
		simpleMailMessage.setText("test content");
		this.mailSender.send(simpleMailMessage);
		
		/*
		 * this.mailSender.send(new MimeMessagePreparator() {
		 * 
		 * @Override public void prepare(MimeMessage mimeMessage) throws Exception{
		 * MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		 * 
		 * 
		 * } });
		 */
	}

	public void sendMailMessage(Sender sender) {
		System.out.println("sender가 매개변수인 sendMailMessage");
		simpleMailMessage.setFrom(sender.getFrom());
		simpleMailMessage.setTo(sender.getTo().get(0));
		simpleMailMessage.setSubject(sender.getSubject());
		simpleMailMessage.setText(sender.getContent());
		System.out.println("simpleMailMessage : " + simpleMailMessage);
		System.out.println("mailSender : " + mailSender);
		mailSender.send(simpleMailMessage);
	}
}





