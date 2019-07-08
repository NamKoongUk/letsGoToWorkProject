package com.kh.lgtw.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.lgtw.ses.app.AmazonEmail;
import com.kh.lgtw.ses.app.SESFrom;
import com.kh.lgtw.ses.app.SESProcessor;
 
@RestController
public class AppController {
	@RequestMapping("/")
    public String index() {

        //send Email using default NO_REPLY from email
        SESProcessor.getInstance().add(new AmazonEmail(
        "hi@atta.me",
        "Hey Atta",
        "We have an offer for you :)"));

        //send Email using ATTA from email
        SESProcessor.getInstance().add(new AmazonEmail(
        "hi@atta.me",
        SESFrom.ATTA,
        "Hey Atta",
        "We have an offer for you :)"));

        return "Emails Sent!"; 
    }
}
