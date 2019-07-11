package com.kh.lgtw.mail.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

// 메일 수신을 위한 s3 버킷 접근 
public class AwsS3Controller {
	
	private AmazonS3 conn;
	
	public void buildS3() {
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		System.out.println("자격 증명 가져오기 : " + credentialsProvider.getCredentials());

		// 자격 증명 가져오기 // SES에서는 Exception을 내줌
		credentialsProvider.getCredentials();
		
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .build();
		
		// 버킷 리스트 가져오기 
		
	}
	

	
}
