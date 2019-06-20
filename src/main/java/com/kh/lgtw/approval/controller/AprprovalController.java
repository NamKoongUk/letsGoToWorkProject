package com.kh.lgtw.approval.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.lgtw.approval.model.service.ApprovalService;
import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.employee.model.vo.Employee;

@Controller
public class AprprovalController {
	@Autowired
	private ApprovalService as;
	
	//------------------------진행중인 문서------------------------------
	//진행중인 전체문서 이동
	@RequestMapping("approval.ap")
	public String approvalHome() {
		return "approval/approvalMain";
	}
	
	@RequestMapping("showAllPrograssDcm.ap")
	public String showAllPrograssDocument(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		
		
		// ArrayList<HashMap<String, Object>> list = as.showAllPrograssDocument(pi);
		
		return "";
	}
	
	//결재대기문서 이동
	@RequestMapping("showWaitDcm.ap")
	public String showWaitDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showWaitDcm(pi);
		
		
		return "";
	}
	
	//처리예정문서 이동
	@RequestMapping("showIntendedDcm.ap")
	public String showIntendedDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showIntendedDcm(pi);
		
		return "";
	}
	
	//처리중인문서 이동
	@RequestMapping("showProgressgDcm.ap")
	public String showProgressgDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showProgressgDcm(pi);
		
		return "";
	}
	
	//완료문서 이동
	@RequestMapping("showFinishDcm.ap")
	public String showFinishDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showFinishDcm(pi);
		
		return "";
	}
	
	//수신대기 문서 이동
	@RequestMapping("showWaitReceptionDcm.ap")
	public String showWaitReceptionDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showWaitReceptionDcm(pi);
		
		return "";
	}
	
	//회람대기 문서 이동
	@RequestMapping("showWaitCirculationDcm.ap")
	public String showWaitCirculationDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showWaitCirculationDcm(pi);
		
		return "";
	}
	
	//-------------------------완료문서-----------------------------
	//완료문서 - 전체보기
	@RequestMapping("showAllFinishDcm.ap")
	public String showAllFinishDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showAllFinishDcm(pi);
		
		return "";
	}
	
	//완료문서-기안한문서
	@RequestMapping("showWriteDcm.ap")
	public String showWriteDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showWriteDcm(pi);
		
		return "";
	}
	
	//완료문서-결재문서
	@RequestMapping("showFinApprovaldDcm.ap")
	public String showFinApprovaldDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showFinApprovaldDcm(pi);
		
		return "";
	}
	
	//완료문서-수신문서
	@RequestMapping("showReceptionDcm.ap")
	public String showReceptionDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showReceptionDcm(pi);
		
		return "";
	}
	
	//완료문서-회람/참조 문서
	@RequestMapping("showCirculationDcm.ap")
	public String showCirculationDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showCirculationDcm(pi);
		
		return "";
	}
	
	//완료문서-반려문서
	@RequestMapping("showRefuseDcm.ap")
	public String showRefuseDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showRefuseDcm(pi);
		
		return "";
	}
	
	//완료문서-임시저장문서
	@RequestMapping("showSaveDcm.ap")
	public String showSaveDcm(HttpServletRequest request, Model model) {
		
		Employee e = (Employee)request.getSession().getAttribute("loginUser");
		
		PageInfo pi = new PageInfo();
		pi.setSortInfo(request.getParameter("sortInfo"));
		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
		pi.setEid(e.getEid());
		
		// ArrayList<HashMap<String, Object>> list = as.showSaveDcm(pi);
		
		return "";
	}
	
	//------------------------관리자설정-----------------------------
	//전자결재 관리자
	@RequestMapping("showAppManager.ap")
	public String showAppManager(Model model) {
		
		// ArrayList<Employee> list = as.showAppManager();
		
		return "";
	}
	//관리자 추가
	@RequestMapping("insertApprovalMng.ap")
	public String insertApprovalMng(int eid) {
		
		// int result = as.insertApprovalMng(eid);
		
		return "";
	}
	//기본설정
	@RequestMapping("showOption.ap")
	public String showOption() {
		return "";
	}
	//옵션 변경
	@RequestMapping("updateOption.ap")
	public String updateOption() {
		return "";
	}
	
	//양식관리
	@RequestMapping("showFormManagement.ap")
	public String showFormManagement(Model model) {
		
		// ArrayList<AppForm> list = as.showFormManagement();
		
		return "";
	}
	
	//양식생성
	@RequestMapping("insertAppForm.ap")
	public String insertAppForm(AppForm form) {
		
		// int result = as.insertAppForm(form);
		
		return "";
	}
	
	//양식 삭제
	@RequestMapping("delteAppForm.ap")
	public String delteAppForm(AppForm form) {
		
		// int result = as.delteAppForm(form);
		
		return "";
	}
	
	//양식 수정
	@RequestMapping("updateAppForm.ap")
	public String updateAppForm(AppForm form) {
		
		// int result = as.updateAppForm(form);
		
		return "";
	}
	
	//사용 전환
	@RequestMapping("updateUseForm.ap")
	public String updateUseForm(AppForm form) {
		
		// int result = as.updateUseForm(form);
		
		return "";
	}
	
	//미사용 전환
	@RequestMapping("updateNotUserForm.ap")
	public String updateNotUserForm(AppForm form) {
		
		// int result = as.updateNotUserForm(form);
		
		return "";
	}
	//제공양식 보기
	@RequestMapping("selectOfferDcm.ap")
	public String selectOfferDcm(Model model) {
		
		// ArrayList<AppForm> list = as.selectOfferDcm();
		
		return "";
	}
	//양식상세
	@RequestMapping("selectOneOfferDcm.ap")
	public String selectOneOfferDcm(Model model, int afNo) {
		
		// AppForm form = as.selectOneOfferDcm(afNo);
		
		return "";
	}
	//제공양식저장
	@RequestMapping("saveOfferDcm.ap")
	public String saveOfferDcm(Model model, int[] afNo) {
		
		// int result = as.saveOfferDcm(afNo);
		
		return "";
	}
	
	//전체문서목록
	@RequestMapping("showAllDcm.ap")
	public String showAllDcm(Model model) {
		
		// ArrayList<HashMap<String, Object>> list = as.showAllDcm();
		
		return "";
	}
	
	//삭제문서 전체
	@RequestMapping("showDeleteDcm.ap")
	public String showDeleteDcm(Model model) {
		
		//ArrayList<HashMap<String, Object>> list = as.showDeleteDcm();
		
		return "";
	}
	
	//-----------------------------문서 상세보기 및 결재기능--------------------------------------
	//문서 상세보기
	@RequestMapping("showDetailDcm.ap")
	public String showDetailDcm(Model model, String adNo) {
		
		// HashMap<String, Object> hmap = as.showDetailDcm(adNo);
		
		return "";
	}
	
	//문서결재
	@RequestMapping("approvalDcm.ap")
	public String approvalDcm(String adNo, int eid) {
		
		// int result = as.approvalDcm(adNo, eid);
		
		return "";
	}
	
	//회람 or 수신 확인
	@RequestMapping("confirmDcm.ap")
	public String confirmDcm(String adNo, int eid) {
		
		// int result = as.confirmDcm(adNo, eid);
		
		return "";
	}
	
	//수신, 회람추가
	@RequestMapping("updateDcm.ap")
	public String updateDcm(String adNo, int eid) {
		
		// int result = as.updateDcm(adNo, eid);
		
		return "";
	}
	
	//--------------------------------작성하기-------------------------------------
	//작성하기 폼 이동
	@RequestMapping("showWriteForm.ap")
	public String showWriteForm(Model model) {
		
		// int[] afNoArr = as.showWriteForm();
		
		return "approval/writeApprovalPage";
	}
	//문서양식 불러오기
	@RequestMapping("selectDcmForm.ap")
	public String selectDcmForm(int afNo) {
		
		// AppForm form = as.selectDcmForm(afNo);
		
		return "";
	}
	//결재선 불러오기
	@RequestMapping("selectApprovalLine.ap")
	public String selectApprovalLine(HttpSession session, Model model) {
		
		Employee e = (Employee)session.getAttribute("loginUser");
		
		int eid = e.getEid();
		
		// ArrayList<SignLine> list = as.selectApprovalLine(eid);
		
		return "";
	}
	
	//참조자 설정
	@RequestMapping("selectReferenceEmp.ap")
	public String selectReferenceEmp(String name) {
		
		// ArrayList<Employee> list = as.selectReferenceEmp(name);
		
		return "";
	}
	//문서 저장
	@RequestMapping("saveApprovalDcm.ap")
	public String saveApprovalDcm(AppDocument ad,HttpSession session) {

		// int result = as.saveApprovalDcm(ad);
		
		return "";
	}
	//결재문서 작성완료
	@RequestMapping("insertApprovalDcm.ap")
	public String insertApprovalDcm(AppDocument ad, int[] eid) {

		// int result = as.insertApprovalDcm(ad, eid);
		
		return "";
	}

}


























