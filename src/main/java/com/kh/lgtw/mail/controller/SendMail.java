package com.kh.lgtw.mail.controller;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.kh.lgtw.mail.model.vo.Sender;


public class SendMail {
	public void send (Sender sender) {
		// 로깅처리해줘야함!
		System.out.println("sendMail 실행됨!!");
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
			client.sendEmail(sender.toSendRequest());

			// 메일 전송한다는 로그 남기기 
					
		}catch(Exception exception) {
			System.out.println("이메일 전송에 있어서 에러 발생!");
			System.out.println("메일 에러 : " + exception.getMessage());
			throw new AmazonClientException(exception.getMessage(), exception);
		}
		
		
	}
}
