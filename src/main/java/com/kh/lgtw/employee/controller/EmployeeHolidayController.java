package com.kh.lgtw.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeHolidayController {
	
	//holiday 페이지 리턴
	@RequestMapping("showHolidayApply.em")
	public String showHolidayApply() {
		return "employee/holidayApply";
	}
	//holidayAdmin 페이지 리턴
	@RequestMapping("showHolidayApplyAdmin.em")
	public String showHolidayApplyAdmin() {
		return "employee/holidayApplyAdmin";
	}
	
}
