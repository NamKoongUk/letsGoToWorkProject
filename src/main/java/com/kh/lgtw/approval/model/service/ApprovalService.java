package com.kh.lgtw.approval.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.employee.model.vo.Employee;

public interface ApprovalService {

	SignForm selectSignForm(SignForm sf);

//	ArrayList<HashMap<String, Object>> showAllPrograssDocument(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi);
//
//	ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi);
//
//	ArrayList<Employee> showAppManager();
//
//	int insertApprovalMng(int eid);
//
	ArrayList<AppForm> showFormManagement(PageInfo pi);
//
	int insertAppForm(AppForm form);
//
	int deleteAppForm(List<String> afNo);
//
	int statusUpdateAppForm(Map<String, Object> map);
//
	int updateAppForm(AppForm form);
//
//	ArrayList<AppForm> selectOfferDcm();
//
	AppForm selectOneAppFormDcm(int afNo);
//
//	int saveOfferDcm(int[] afNo);
//
//	ArrayList<HashMap<String, Object>> showAllDcm();
//
//	ArrayList<HashMap<String, Object>> showDeleteDcm();
//
//	HashMap<String, Object> showDetailDcm(String adNo);
//
//	int approvalDcm(String adNo, int eid);
//
//	int confirmDcm(String adNo, int eid);
//
//	int updateDcm(String adNo, int eid);
//
	ArrayList<HashMap<String, Object>> selectFormList();
//
//	AppForm selectDcmForm(int afNo);
//
//	ArrayList<SignLine> selectApprovalLine(int eid);
//
//	ArrayList<Employee> selectReferenceEmp(String name);
//
//	int saveApprovalDcm(AppDocument ad);
//
//	int insertApprovalDcm(AppDocument ad, int []eid);
//
//	ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi);

	int getFormManagementListCount();

	ArrayList<Security> selectSecurity();

	ArrayList<HashMap<String, Object>> selectJob();

	int updateGrade(Map<String, String> grade);

	HashMap<String, Object> selectWriteForm(int afNo);

	List<HashMap<String, Object>> autocompleteCircle(String value);

	Map<String, ArrayList<HashMap<String, Object>>> selectEmp();

	Map<String, ArrayList<HashMap<String, Object>>> selectUnderDept(String deptCode);

	int writeApproval(Map<String, Object> appDcm);

	int selectWaitCircleDcm(int empNo);

	ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi);

	HashMap<String, Object> showDetailDcm(String adNo);

	

}
