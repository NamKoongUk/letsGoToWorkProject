package com.kh.lgtw.approval.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.lgtw.approval.model.service.ApprovalService;
import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.common.Pagination;

@Controller
public class AprprovalController {
	@Autowired
	private ApprovalService as;

	// ------------------------진행중인 문서------------------------------
	// 진행중인 전체문서 이동
//	@RequestMapping("approval.ap")
//	public String approvalHome() {
//		return "approval/approvalMain";
//	}

	@RequestMapping("showAllPrograssDcm.ap")
	public String showAllPrograssDocument(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showAllPrograssDocument(pi);

		return "progressDcm/allProgressDcm";
	}

	// 결재대기문서 이동
	@RequestMapping("showWaitDcm.ap")
	public String showWaitDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showWaitDcm(pi);

		return "progressDcm/approvalMain";
	}

	// 처리예정문서 이동
	@RequestMapping("showIntendedDcm.ap")
	public String showIntendedDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showIntendedDcm(pi);

		return "progressDcm/intendedDcm";
	}

	// 처리중인문서 이동
	@RequestMapping("showProgressgDcm.ap")
	public String showProgressgDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());
//		
		// ArrayList<HashMap<String, Object>> list = as.showProgressgDcm(pi);

		return "progressDcm/approvalProgressDcm";
	}

	// 완료문서 이동
	@RequestMapping("showFinishDcm.ap")
	public String showFinishDcm(HttpServletRequest request, Model model) {
//		
//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showFinishDcm(pi);

		return "progressDcm/finishDcm";
	}

	// 수신대기 문서 이동
	@RequestMapping("showWaitReceptionDcm.ap")
	public String showWaitReceptionDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showWaitReceptionDcm(pi);

		return "progressDcm/waitReceptionDcm";
	}

	// 회람대기 문서 이동
	@RequestMapping("showWaitCirculationDcm.ap")
	public String showWaitCirculationDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showWaitCirculationDcm(pi);

		return "progressDcm/waitCirculationDcm";
	}

	// -------------------------완료문서-----------------------------
	// 완료문서 - 전체보기
	@RequestMapping("showAllFinishDcm.ap")
	public String showAllFinishDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showAllFinishDcm(pi);

		return "finDcm/allFinishDcm";
	}

	// 완료문서-기안한문서
	@RequestMapping("showWriteDcm.ap")
	public String showWriteDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showWriteDcm(pi);

		return "finDcm/userWriteDcm";
	}

	// 완료문서-결재문서
	@RequestMapping("showFinApprovaldDcm.ap")
	public String showFinApprovaldDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showFinApprovaldDcm(pi);

		return "finDcm/finApprovalDcm";
	}

	// 완료문서-수신문서
	@RequestMapping("showReceptionDcm.ap")
	public String showReceptionDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showReceptionDcm(pi);

		return "finDcm/receptionDcm";
	}

	// 완료문서-회람/참조 문서
	@RequestMapping("showCirculationDcm.ap")
	public String showCirculationDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showCirculationDcm(pi);

		return "finDcm/circulationDcm";
	}

	// 완료문서-반려문서
	@RequestMapping("showRefuseDcm.ap")
	public String showRefuseDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showRefuseDcm(pi);

		return "finDcm/refuseDcm";
	}

	// 완료문서-임시저장문서
	@RequestMapping("showSaveDcm.ap")
	public String showSaveDcm(HttpServletRequest request, Model model) {

//		Employee e = (Employee)request.getSession().getAttribute("loginUser");
//		
//		PageInfo pi = new PageInfo();
//		pi.setSortInfo(request.getParameter("sortInfo"));
//		pi.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
//		pi.setEid(e.getEid());

		// ArrayList<HashMap<String, Object>> list = as.showSaveDcm(pi);

		return "finDcm/saveDcm";
	}

	// ------------------------관리자설정-----------------------------
	// 전자결재 관리자
	@RequestMapping("showAppManager.ap")
	public String showAppManager(Model model) {

		// ArrayList<Employee> list = as.showAppManager();

		return "";
	}

	// 관리자 추가
	@RequestMapping("insertApprovalMng.ap")
	public String insertApprovalMng(int eid) {

		// int result = as.insertApprovalMng(eid);

		return "";
	}

	// 기본설정 화면보기
	@RequestMapping("showOption.ap")
	public String showOption(Model model) {

		ArrayList<Security> list = as.selectSecurity();
		ArrayList<HashMap<String, Object>> jobList = as.selectJob();
//		System.out.println(list);
//		System.out.println(jobList);
		model.addAttribute("list", list);
		model.addAttribute("jobList", jobList);

		return "managerOption/selectOption";
	}

	// 옵션 변경
	@RequestMapping(value = "updateOption.ap", produces = "application/text; charset=utf8")
	public @ResponseBody String updateOption(@RequestBody Map<String, String> grade) {
		System.out.println(grade);
		int result = as.updateGrade(grade);

		System.out.println(result);

		if (result > 0) {
			return "수정이 완료되었습니다.";
		} else {
			return "수정에 실패했습니다.";
		}

	}
	// 등급별 권한 변경

	// 양식관리
	@RequestMapping("showFormManagement.ap")
	public String showFormManagement(Model model, HttpServletRequest request) {

		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount = as.getFormManagementListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

//		System.out.println(pi);

		ArrayList<AppForm> list = as.showFormManagement(pi);

		if (request.getParameter("result") != null) {
			model.addAttribute("result", Integer.parseInt(request.getParameter("result")));
			model.addAttribute("msg", "작성이 완료되었습니다.");
		} else {
			model.addAttribute("result", 0);
		}

//		System.out.println("showFormManagement : " + list);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "managerOption/formManagement";
	}

	// 양식상세
	@RequestMapping("selectOneAppFormDcm.ap")
	public String selectOneOfferDcm(Model model, int afNo) {
//		System.out.println(afNo);
		AppForm form = as.selectOneAppFormDcm(afNo);
//		System.out.println(form);

		model.addAttribute("form", form);

		return "managerOption/formDetail";
	}

	// 결재양식 선택
	@RequestMapping(value = "selectSignForm.ap", produces = "application/text; charset=utf8")
	public @ResponseBody String selectSignForm(HttpServletResponse response, SignForm sf) {

		// ObjectMapper mapper = new ObjectMapper();

		SignForm signForm = as.selectSignForm(sf);
		// System.out.println(signForm.getSignContent());

		return signForm.getSignContent();
	}

	// 양식생성으로 이동
	@RequestMapping("selectAppForm.ap")
	public String selectAppForm() {

		return "managerOption/insertAppForm";
	}

	// 양식생성
	@RequestMapping("insertAppForm.ap")
	public String insertAppForm(AppForm form, Model model) {

//		System.out.println(form);

		int result = as.insertAppForm(form);

		return "redirect:showFormManagement.ap?result=" + result;
	}

	// 양식 삭제
	@RequestMapping(value = "deleteAppForm.ap", produces = "application/text; charset=utf8")
	public @ResponseBody String deleteAppForm(@RequestParam(value = "afNoArr") List<String> afNo) {

//		System.out.println(afNo);

		int result = as.deleteAppForm(afNo);

		if (result > 0) {
			return afNo.size() + "개의 양식의 삭제가 완료되었습니다.";
		} else {
			return "삭제에 실패했습니다.";
		}
	}

	// 양식 수정 페이지로 이동
	@RequestMapping("showUpdateAppForm.ap")
	public String showUpdateAppForm(int afNo, Model model) {

		AppForm form = as.selectOneAppFormDcm(afNo);
		model.addAttribute("form", form);

		return "managerOption/updateAppForm";
	}

	// 양식 수정
	@RequestMapping("updateAppForm.ap")
	public String updateAppForm(AppForm form) {

//		System.out.println(form);
		int result = as.updateAppForm(form);

		if (result > 0) {
			return "redirect:showFormManagement.ap?result=" + result;
		} else {
			return "redirect:showFormManagement.ap?result=" + 0;
		}

	}

	// 사용 전환
	@RequestMapping(value = "statusUpdateAppForm.ap", produces = "application/text; charset=utf8")
	public @ResponseBody String statusUpdateAppForm(@RequestBody Map<String, Object> map) {
//		System.out.println(map);
		// System.out.println(choice);
		// System.out.println(afNo);

		int result = as.statusUpdateAppForm(map);
		System.out.println("result : " + result);
		return "성공";
	}

	// 제공양식 보기
	@RequestMapping("selectOfferDcm.ap")
	public String selectOfferDcm(Model model) {

		// ArrayList<AppForm> list = as.selectOfferDcm();

		return "";
	}

	// 제공양식저장
	@RequestMapping("saveOfferDcm.ap")
	public String saveOfferDcm(Model model, int[] afNo) {

		// int result = as.saveOfferDcm(afNo);

		return "";
	}

	// 전체문서목록
	@RequestMapping("showAllDcm.ap")
	public String showAllDcm(Model model) {

		// ArrayList<HashMap<String, Object>> list = as.showAllDcm();

		return "";
	}

	// 삭제문서 전체
	@RequestMapping("showDeleteDcm.ap")
	public String showDeleteDcm(Model model) {

		// ArrayList<HashMap<String, Object>> list = as.showDeleteDcm();

		return "";
	}

	// -----------------------------문서 상세보기 및
	// 결재기능--------------------------------------
	// 문서 상세보기
	@RequestMapping("showDetailDcm.ap")
	public String showDetailDcm(Model model, String adNo) {

		// HashMap<String, Object> hmap = as.showDetailDcm(adNo);

		return "";
	}

	// 문서결재
	@RequestMapping("approvalDcm.ap")
	public String approvalDcm(String adNo, int eid) {

		// int result = as.approvalDcm(adNo, eid);

		return "";
	}

	// 회람 or 수신 확인
	@RequestMapping("confirmDcm.ap")
	public String confirmDcm(String adNo, int eid) {

		// int result = as.confirmDcm(adNo, eid);

		return "";
	}

	// 수신, 회람추가
	@RequestMapping("updateDcm.ap")
	public String updateDcm(String adNo, int eid) {

		// int result = as.updateDcm(adNo, eid);

		return "";
	}

	// --------------------------------작성하기-------------------------------------
	// 작성하기 폼 이동
	@RequestMapping("showWriteForm.ap")
	public String showWriteForm(Model model) {

		ArrayList<HashMap<String, Object>> list = as.selectFormList();
		model.addAttribute("list", list);
//		System.out.println(list);	

		return "writeApprovalPage";
	}

	// 작성하기위한 폼 불러오기
	@RequestMapping(value = "/approval/selectWriteForm")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> selectWriteForm(@RequestParam(value = "afNo") int afNo) {
//		System.out.println(afNo);
		Map<String, Object> map = as.selectWriteForm(afNo);
//		System.out.println(map);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	//결재선 설정을 위한 사원 조회
	@RequestMapping(value = "/approval/selectEmp")
	@ResponseBody
	public Map<String, ArrayList<HashMap<String, Object>>> selectEmp(){
		
		Map<String, ArrayList<HashMap<String, Object>>> map = as.selectEmp();
//		System.out.println(map.get("empList"));
//		System.out.println(map.get("deptList"));
		
		return map;
	}
	
	//하위부서 및 하위부서 사원 조회
	@RequestMapping(value = "approval/selectUnderDept")
	@ResponseBody
	public Map<String, ArrayList<HashMap<String, Object>>> selectUnderDept(@RequestParam(value = "deptCode") String deptCode){
		
		Map<String, ArrayList<HashMap<String, Object>>> map = as.selectUnderDept(deptCode);
		System.out.println("하위부서 : " + map.get("deptList"));
		System.out.println("하위부서 : " + map.get("empList"));
		
		return map;
		
	}
	

	// 문서양식 불러오기
	@RequestMapping("selectDcmForm.ap")
	public String selectDcmForm(int afNo) {

		// AppForm form = as.selectDcmForm(afNo);

		return "";
	}

	// 결재선 불러오기
	@RequestMapping("selectApprovalLine.ap")
	public String selectApprovalLine(HttpSession session, Model model) {

//		Employee e = (Employee)session.getAttribute("loginUser");
//		
//		int eid = e.getEid();

		// ArrayList<SignLine> list = as.selectApprovalLine(eid);

		return "";
	}

	// 참조자 설정
	@RequestMapping("selectReferenceEmp.ap")
	public String selectReferenceEmp(String name) {

		// ArrayList<Employee> list = as.selectReferenceEmp(name);

		return "";
	}

	// 문서 저장
	@RequestMapping("saveApprovalDcm.ap")
	public String saveApprovalDcm(AppDocument ad, HttpSession session) {

		// int result = as.saveApprovalDcm(ad);

		return "";
	}

	// 결재문서 작성완료
	@RequestMapping("insertApprovalDcm.ap")
	public String insertApprovalDcm(AppDocument ad, int[] eid) {

		// int result = as.insertApprovalDcm(ad, eid);

		return "";
	}

	// 자동완성
	@RequestMapping("/approval/autocompleteCircle")
	@ResponseBody
	public List<HashMap<String, Object>> autocompleteCircle(@RequestParam String value){
//		System.out.println(value);
//		List<HashMap<String, String>> = new ArrayList<String>();
//		list.add("김채연");
//		list.add("조도연");
//		list.add("이지현");
//		list.add("남궁욱");
//		list.add("김규형");
//		list.add("강형석");
		
		List<HashMap<String, Object>> result = as.autocompleteCircle(value);
//		System.out.println(result);
//		for(String str : list) {
//			if(str.startsWith(value)) {
//				result.add(str);
//			}
//		}
		
		return result;
	}

}
