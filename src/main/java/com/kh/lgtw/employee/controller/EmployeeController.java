package com.kh.lgtw.employee.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.employee.model.service.EmployeeService;
import com.kh.lgtw.employee.model.vo.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService emplService;
	
	//로그인
	@RequestMapping("login.em")
	public String loginCheck(Employee employee, HttpServletRequest request) {
		
		//Employee loginUser = emplService.loginEmpl(employee);
		
		return "";
	}
	//사원 조회
	@RequestMapping("selectEmpl.em")
	public String selectEmployee(Model model) {
		
		//ArrayList<Employee> empList = emplService.selectEmlList();
		
		return "";
	}
	//사원 상세 조회
	@RequestMapping("selectOneEmpl.em")
	public String selectOneEmployee(Employee employee, Model model) {
		//Employee emp = emplService.selectOneEmp(employee);
		return "";
	}
	//사원 정보 수정
	@RequestMapping("updateEmpl.em")
	public String updateOneEmployee(HttpServletRequest request, Employee employee, Model model) {
		//Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		
		//int result = emplService.updateOneEmp(loginUser,employee);
		
		
		return "";
	}
	//사원 검색
	@RequestMapping("searchEmpl.em")
	public String searchEmployee(Employee employee, Model model) {
		
		//ArrayList<Employee> list = emplService.searchEmp(employee);
		
		return "";
	}
	//조직도 조회
	@RequestMapping("selectDept.em")
	public String selectDept(Model model) {
		
		return "";
	}
	
	//휴가신청
	@RequestMapping("reqHoliday.em")
	public String reqHoliday(HttpServletRequest request, Model model) {
		Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		//int result = emplService.reqHoliday(loginUser);
		
		return "";
	}
	
	//휴가 확인
	@RequestMapping("selectHoliday.em")
	public String selectHoliday(HttpServletRequest request, Model model) {
		return "";
	}
	//휴가 신청확인
	@RequestMapping("selectReqHoliday.em")
	public String selectReqHoliday(HttpServletRequest request, Model model) {
		return "";
	}
	
	//근태현황 ATTENDANCE
	@RequestMapping("selectAttend.em")
	public String selectAttend(HttpServletRequest request, Model model) {
		Employee loginUser =(Employee)request.getSession().getAttribute("loginUser");
		
		//Attendace attend = emplService.selectAttend(loginUser);
		
		return "";
	}
	
	//근태수정내역
	@RequestMapping("updateAttendList.em")
	public String updateAttendList(HttpServletRequest request, Model model) {
		return "";
	}
	
	
	
	//인사 관리자
	//근태수정
	@RequestMapping("updateAttend.em")
	public String updateAttend(Employee employee, Model model) {
		return "";
	}
	
	//조직도등록
	@RequestMapping("insertDept.em")
	public String insertDept(Model model) {
		return "";
	}
	
	//사원 한명 추가 
	@RequestMapping("insertOneEmpl.em")
	public String insertEmployee(Employee employee, Model model){
		//int result = emplService.insertEmp(employee);
		return "";
	}
	
	//직무추가
	@RequestMapping("insertDuty.em")
	public String insertDuty(Model model) {
		//int result = emplService.insertDuty();
		return "";
	}
	
	//휴직자 추가
	@RequestMapping("updateLeave.em")
	public String updateLeave(Employee employee, Model model) {
		//int result = emplService.updateLeave(employee);
		return "";
	}
	
	
	//휴직자 조회
	@RequestMapping("selectLeaveList.em")
	public String selectLeaveList(Model model) {
		
		//ArrayList<Employee> leaveList = emplService.selctLeaveList();
		
		return "";
	}
}






















