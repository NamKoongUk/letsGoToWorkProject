package com.kh.lgtw.employee.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.exception.LoginException;
import com.kh.lgtw.employee.model.vo.DeptVo;
import com.kh.lgtw.employee.model.vo.Employee;
import com.kh.lgtw.employee.model.vo.EmployeeResult;
import com.kh.lgtw.employee.model.vo.ExcelEmp;
import com.kh.lgtw.employee.model.vo.JobVo;

public interface EmployeeService {

	Employee loginCheck(Employee employee) throws LoginException;

	int insertEmpOne(Employee employee, Attachment attach, DeptVo dpVo, JobVo jobVo);

	int empExcelUpload(File destFile);

	List<ExcelEmp> xlsEmpInsert(MultipartHttpServletRequest request, MultipartFile excelFile);

	List<ExcelEmp> xlsxEmpInsert(MultipartHttpServletRequest request, MultipartFile excelFile, Attachment attach);

	List<String> selectEmpEamilForName(String sName);
	
	ArrayList<DeptVo> selectDeptList();
	
    int insertEmpQuick(Employee employee, DeptVo dpVo, JobVo jobVo, Attachment attach);
	
    ArrayList<EmployeeResult> selectEmpListAdmin(PageInfo pi);
	
    HashMap<String, Object> selectJopDeptAdmin();
	
	int getEmpListCount();
	
	int deleteEmpList(int empNo);
	
	int insertEmpOneNoAttach(Employee employee,DeptVo dpVo, JobVo jobVo);

	void dbEmpList(HttpServletResponse response);

	List<EmployeeResult> xlsEmpUpdate(MultipartHttpServletRequest request, MultipartFile excelFile);

	List<EmployeeResult> xlsxEmpUpdate(MultipartHttpServletRequest request, MultipartFile excelFile);

	HashMap<String, Object> selectEmpDeptJob(Employee employee);

	Attachment selectProfile(Employee employee);

	int updatePwdCheck(EmployeeResult employee);

	int updateEmpOne(EmployeeResult employee, Attachment attach);

	HashMap<String, Object> selectLevelCaptain();

	ArrayList<DeptVo> selectOrgDept();







//	Employee loginEmpl(Employee employee);
//
//	ArrayList<Employee> selectEmlList();
//
//	Employee selectOneEmp(Employee employee);
//
//	int updateOneEmp(Employee loginUser, Employee employee);
//
//	ArrayList<Employee> searchEmp(Employee employee);
//
//	int reqHoliday(Employee loginUser);
//
//	Attendace selectAttend(Employee loginUser);
//
//	int insertEmp(Employee employee);
//
//	int insertDuty();
//
//	int updateLeave(Employee employee);
//
//	ArrayList<Employee> selctLeaveList();

}
