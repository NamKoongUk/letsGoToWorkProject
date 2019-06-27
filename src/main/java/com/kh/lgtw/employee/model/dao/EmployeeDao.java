package com.kh.lgtw.employee.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.ExcelEmp;

public interface EmployeeDao{

	Employee loginCheck(SqlSession sqlSession, Employee employee) throws LoginException;

	int inSertEmpOne(SqlSession sqlSession, Employee employee);

	String selectEncPassword(SqlSession sqlSession, Employee employee);

	int empExcelUpload(SqlSession sqlSession, File destFile);

	List<ExcelEmp> excelEmpInsert(SqlSession sqlSession, List<ExcelEmp> list);

	ArrayList<DeptVo> selectDeptList(SqlSession sqlSession);



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
