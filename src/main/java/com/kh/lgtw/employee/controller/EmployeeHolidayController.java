package com.kh.lgtw.employee.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.Employee;

@Controller
public class EmployeeHolidayController {
	@Autowired
	private EmployeeService es;
	
	//holiday 페이지 리턴
	@RequestMapping("showHolidayApply.em")
	public String showHolidayApply(HttpSession session, Model model) {
		//Employee emp =  (Employee) session.getAttribute("loginEmp");
		
		//HashMap<String, Object> hmap = es.showHolidayApply(emp.getEmpNo());
		
		//model.addAttribute(hmap);
		
		return "employee/holidayApply";
	}
	//holidayAdmin 페이지 리턴
	@RequestMapping("showHolidayApplyAdmin.em")
	public String showHolidayApplyAdmin() {
		return "employee/holidayApplyAdmin";
	}
	
	@RequestMapping("holidayInsert.em")
	public ResponseEntity<Integer> holidayInsertAdmin() {
		
		return new ResponseEntity<Integer>(es.holidayInsertAdmin(),HttpStatus.OK);
	}
	
}
