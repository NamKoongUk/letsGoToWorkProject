package com.kh.lgtw.employee.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.employee.model.dao.EmployeeDao;
import com.kh.lgtw.employee.model.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	private EmployeeDao empDao;
//	private SqlSession sqlSession;
//
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
