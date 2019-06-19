package com.kh.lgtw;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("approval.ap")
	public String approvalHome() {
		return "approval/approvalMain";
	}
	
	@RequestMapping("community.co")
	public String communityHome() {
		return "community/communityMain";
	}
	
	@RequestMapping("employee.em")
	public String employeeHome() {
		return "employee/employeeMain";
	}
	
	@RequestMapping("messenger.me")
	public String messengerHome() {
		return "messenger/messengerMain";
	}
	
	@RequestMapping("scheduler.sc")
	public String schedulerHome() {
		return "scheduler/schedulerMain";
	}
	
	@RequestMapping("mail.ma")
	public String mailHome() {
		return "mail/mailMain";
	}
}
