package com.kh.lgtw.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.employee.model.vo.Employee;

@Controller
public class EmployeeController {
	@RequestMapping("login.em")
	public String loginCheck(Employee e, HttpServletRequest request) {
	
		return "";
	}
}
