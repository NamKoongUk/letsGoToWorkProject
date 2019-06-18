package com.kh.lgtw.employee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.employee.model.vo.Employee;

@Controller
public class EmployeeController {
	//로그인
	@RequestMapping("login.em")
	public String loginCheck(Employee employee, HttpServletRequest request) {
		return "";
	}
	//사원 한명 추가 
	@RequestMapping("insertOne.em")
	public String insertEmployee(Employee employee, Model model){
		return "";
	}
	//사원 조회
	@RequestMapping("select.em")
	public String selectEmployee(Employee employee, Model model) {
		return "";
	}
	//사원 상세 조회
	@RequestMapping("selectOne.em")
	public String selectOneEmployee(Employee employee, Model model) {
		return "";
	}
	//사원 정보 수정
	@RequestMapping("update.em")
	public String updateOneEmployee(Employee employee, Model model) {
		return "";
	}
	//사원 검색
	@RequestMapping("search.em")
	public String searchEmployee(Employee employee, Model model) {
		return "";
	}
	
}





















