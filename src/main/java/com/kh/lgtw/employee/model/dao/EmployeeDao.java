package com.kh.lgtw.employee.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.Employee;

public interface EmployeeDao{

	Employee loginCheck(SqlSession sqlSession, Employee employee) throws LoginException;

	int inSertEmpOne(SqlSession sqlSession, Employee employee);

//	Employee loginEmpl(Employee employee, SqlSession sqlSession);
//
//	ArrayList<Employee> selectEmpList(SqlSession sqlSession);
//
//	Employee selectOneEmp(SqlSession sqlSession, Employee employee);
//
//	int updateOneEmp(SqlSession sqlSession, Employee loginUser, Employee employee);
//
//	ArrayList<Employee> searchEmp(SqlSession sqlSession, Employee employee);
//
//	int reqHoliday(SqlSession sqlSession, Employee loginUser);
//
//	Attendace selectAttend(SqlSession sqlSession, Employee loginUser);
//
//	int insertEmp(SqlSession sqlSession, Employee employee);
//
//	int insertDuty(SqlSession sqlSession);
//
//	int updateLeave(SqlSession sqlSession, Employee employee);
//
//	ArrayList<Employee> selectLeaveList(SqlSession sqlSession);

}
