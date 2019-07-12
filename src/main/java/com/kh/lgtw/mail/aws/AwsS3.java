package com.kh.lgtw.mail.aws;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.util.StringUtils;

import static com.kh.lgtw.common.CommonUtils.*; 

// 메일 수신을 위한 s3 버킷 접근 
// @Component
public class AwsS3 {
	private AmazonS3 conn;
	
	public AwsS3() {
		// 생성자가 작동하면 기본적으로 빌드를 한다.
		// buildS3();
	}
	
	// 빌드하기 
	public void buildS3() {
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
		System.out.println("자격 증명 가져오기 : " + credentialsProvider.getCredentials());

		// 자격 증명 가져오기 // SES에서는 Exception을 내줌
		credentialsProvider.getCredentials();
		
		this.conn = AmazonS3ClientBuilder.standard()
				.withCredentials(credentialsProvider)
				.withRegion("us-east-1")
				.build();
		System.out.println("커넥션 빌드 성공");

	}
	
	// 버킷 가져오기
	public Bucket getBucket(String bucket_name) {
		System.out.println("찾는 버킷 : " + bucket_name);
		
		List<Bucket> buckets = conn.listBuckets();
		System.out.println("버킷 리스트 : " + buckets);
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" + StringUtils.fromDate(bucket.getCreationDate()));
		}		
        
        Bucket named_bucket = null;
        for (Bucket b : buckets) {
            if (b.getName().equals(bucket_name)) {
                named_bucket = b;
            }
        }
        return named_bucket;
    }
	
	// S3 스토리지에 파일 업로드 하는 메소드
	public void putObject(String bucket_name, String file_name, File uploadFiles) {
		conn.putObject(bucket_name, file_name, uploadFiles);
	}
	
	// 버킷 내부 객체 가져오기 
	public ListObjectsV2Result getObjects(String bucket_name) {
		// S3Object o = conn.getObject(bucket_name, objKey);  // 객체 정보를 반환해주는 메소드 
		String key = "";
		ListObjectsV2Result result = conn.listObjectsV2(bucket_name);
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		for (S3ObjectSummary os: objects) {
		    // System.out.println("* " + os.getKey());
		    key = os.getKey();  // 하나만 불러오고 빠져나가라 -> 테스토용임
		    break;
		}
		downloadObject(bucket_name, key);
		return result; 
	}
	
	// 버킷 객체를 받아와 이메일 파싱을 해주는 메소드
	public void parseEmailMessage(ListObjectsV2Result listObject) {
		
		return;
	}
	
	// 객체를 다운로드 해주는 메소드
	// 내부 내용을 출력할 수 있게 도와준다. -> 첨부파일 분리를 먼저 작업한 후에 다시한번 시도한다.
	public void downloadObject(String bucketName, String key) {
		 S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
	     try {
	         AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                 .withRegion("us-east-1")
	                 .withCredentials(new ProfileCredentialsProvider())
	                 .build();
	
	         // Get an object and print its contents.
	         System.out.println("Downloading an object");
	         fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
	         System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
	         System.out.println("Content: ");
	         displayTextInputStream(fullObject.getObjectContent()); // 객체의 content 내용 출력! 
	         
	         // Get a range of bytes from an object and print the bytes.
	         GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, key)
	                                                     .withRange(0,9);
	         objectPortion = s3Client.getObject(rangeObjectRequest);
	         System.out.println("Printing bytes retrieved.");
	         System.out.println("\n\n objectPrtion 내용 출력");
	         // displayTextInputStream(objectPortion.getObjectContent());
	         
	         // Get an entire object, overriding the specified response headers, and print the object's content.
	         ResponseHeaderOverrides headerOverrides = new ResponseHeaderOverrides()
	                                                         .withCacheControl("No-cache")
	                                                         .withContentDisposition("attachment; filename=example.txt");
	         GetObjectRequest getObjectRequestHeaderOverride = new GetObjectRequest(bucketName, key)
	                                                         .withResponseHeaders(headerOverrides);
	         headerOverrideObject = s3Client.getObject(getObjectRequestHeaderOverride);
	         System.out.println("\n\n 헤더 내용 출력 ");
	         // displayTextInputStream(headerOverrideObject.getObjectContent());
	     } catch(AmazonServiceException e) {
	         e.printStackTrace();
	     } catch(SdkClientException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
			e.printStackTrace();
	     } finally {
	    	 try{
	    		 if(fullObject != null) {
	 				fullObject.close();
	 	         }
	 	         if(objectPortion != null) {
	 	             objectPortion.close();
	 	         }
	 	         if(headerOverrideObject != null) {
	 	             headerOverrideObject.close();
	 	         }
	    	 }catch (IOException e) {
				e.printStackTrace();
			}
	     }
	 }

	// 불러온 inputStream 자료형의 파일의 내용을 출력해주는 메소드 
	// 파일 내용을 읽어서 출력해주는 메소드 
	 private static void displayTextInputStream(InputStream input) throws IOException {
	     BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	     String line = null;
	     while ((line = reader.readLine()) != null) {
	         System.out.println(line);
	     }
	     System.out.println();
	 }
	
	 // 파일 업로드 
	  public void fileUpload(String filePath) {
		String bucketName = "lgtw-send-mail";
		String keyName = "보낸메일-" + getServerTime();
		System.out.println("파일 이름 추출" + filePath.substring(filePath.lastIndexOf("/"), filePath.lastIndexOf(".")));
		  
        File file = new File(filePath);
        long contentLength = file.length();
        long partSize = 5 * 1024 * 1024; // Set part size to 5 MB. 

        try {
            // Create a list of ETag objects. You retrieve ETags for each object part uploaded,
            // then, after each individual part has been uploaded, pass the list of ETags to 
            // the request to complete the upload.
            List<PartETag> partETags = new ArrayList<PartETag>();

            // Initiate the multipart upload.
            InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, keyName);
            InitiateMultipartUploadResult initResponse = conn.initiateMultipartUpload(initRequest);

            // Upload the file parts.
            long filePosition = 0;
            for (int i = 1; filePosition < contentLength; i++) {
                // Because the last part could be less than 5 MB, adjust the part size as needed.
                partSize = Math.min(partSize, (contentLength - filePosition));

                // Create the request to upload a part.
                UploadPartRequest uploadRequest = new UploadPartRequest()
                        .withBucketName(bucketName)
                        .withKey(keyName)
                        .withUploadId(initResponse.getUploadId())
                        .withPartNumber(i)
                        .withFileOffset(filePosition)
                        .withFile(file)
                        .withPartSize(partSize);

                // Upload the part and add the response's ETag to our list.
                UploadPartResult uploadResult = conn.uploadPart(uploadRequest);
                partETags.add(uploadResult.getPartETag());

                filePosition += partSize;
            }

            // Complete the multipart upload.
            CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest(bucketName, keyName,
                    initResponse.getUploadId(), partETags);
            conn.completeMultipartUpload(compRequest);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
    
}
