package com.kh.lgtw.employee.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	// 로그인 확인
	@Override
	public Employee loginCheck(SqlSession sqlSession, Employee employee) throws LoginException {
		return sqlSession.selectOne("Employee.loginCheck", employee);
	}
	
	// 비밀번호 확인
	@Override
	public String selectEncPassword(SqlSession sqlSession, Employee employee) {
		return sqlSession.selectOne("Employee.selectEncPassword", employee);
	}
	
	// 사원추가
	@Override
	public int inSertEmpOne(SqlSession sqlSession, Employee employee) {
		return sqlSession.insert("Employee.insertEmpOne",employee);
	}


//	@Override
//	public Employee loginEmpl(Employee employee, SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ArrayList<Employee> selectEmpList(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Employee selectOneEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int updateOneEmp(SqlSession sqlSession, Employee loginUser, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<Employee> searchEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int reqHoliday(SqlSession sqlSession, Employee loginUser) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Attendace selectAttend(SqlSession sqlSession, Employee loginUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int insertEmp(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int insertDuty(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int updateLeave(SqlSession sqlSession, Employee employee) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public ArrayList<Employee> selectLeaveList(SqlSession sqlSession) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
