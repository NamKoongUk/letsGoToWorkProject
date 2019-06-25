package com.kh.lgtw.employee.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.lgtw.employee.model.dao.EmployeeDao;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.util.ExcelRead;
import com.kh.lgtw.employee.model.util.ExcelReadOption;
import com.kh.lgtw.employee.model.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired SqlSession sqlSession; 
	@Autowired private EmployeeDao empDao;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 확인용
	@Override
	public Employee loginCheck(Employee employee) throws LoginException {
		Employee loginEmp = null;
		
		String encPassword = empDao.selectEncPassword(sqlSession, employee);
		
		System.out.println("비밀번호 : " + encPassword);
		System.out.println("암호 2 : " + employee.getEmpPwd());	
		String pass =  passwordEncoder.encode(employee.getEmpPwd());
		System.out.println(pass);
		
		if(passwordEncoder.matches(employee.getEmpPwd(), encPassword)) {
			loginEmp = empDao.loginCheck(sqlSession, employee);
		}else {
			throw new LoginException("로그인실패!");
		}
		
		return loginEmp;
	}
	
//	@Override
//	public Member loginMember(Member m) throws LoginException {
//		Member loginUser = null;
//		
//		String encPassword = md.selectEncPassword(sqlSession, m);
//		
//		
//		if(!passwordEncoder.matches(m.getUserPwd(), encPassword)) {
//			throw new LoginException("로그인실패!");
//		}else {
//			loginUser = md.selectMember(sqlSession, m);
//		}
//		
//		return loginUser;
//	}

	@Override
	public int insertEmpOne(Employee employee) {
		return empDao.inSertEmpOne(sqlSession, employee);
	}

	@Override
	public int empExcelUpload(File destFile) {
		return empDao.empExcelUpload(sqlSession, destFile);
	}


	

	//	@Override
//	public Employee loginEmpl(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.loginEmpl(employee,sqlSession);
//	}
//
//	@Override
//	public ArrayList<Employee> selectEmlList() {
//		// TODO Auto-generated method stub
//		return empDao.selectEmpList(sqlSession);
//	}
//
//	@Override
//	public Employee selectOneEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.selectOneEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int updateOneEmp(Employee loginUser, Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.updateOneEmp(sqlSession, loginUser, employee);
//	}
//
//	@Override
//	public ArrayList<Employee> searchEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.searchEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int reqHoliday(Employee loginUser) {
//		// TODO Auto-generated method stub
//		return empDao.reqHoliday(sqlSession, loginUser);
//	}
//
//	@Override
//	public Attendace selectAttend(Employee loginUser) {
//		// TODO Auto-generated method stub
//		return empDao.selectAttend(sqlSession, loginUser);
//	}
//
//	@Override
//	public int insertEmp(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.insertEmp(sqlSession, employee);
//	}
//
//	@Override
//	public int insertDuty() {
//		// TODO Auto-generated method stub
//		return empDao.insertDuty(sqlSession);
//	}
//
//	@Override
//	public int updateLeave(Employee employee) {
//		// TODO Auto-generated method stub
//		return empDao.updateLeave(sqlSession, employee);
//	}
//
//	@Override
//	public ArrayList<Employee> selctLeaveList() {
//		// TODO Auto-generated method stub
//		return empDao.selectLeaveList(sqlSession);
//	}

}
