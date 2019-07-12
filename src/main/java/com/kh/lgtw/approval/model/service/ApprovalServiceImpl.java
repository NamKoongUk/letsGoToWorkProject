package com.kh.lgtw.approval.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.approval.model.dao.ApprovalDao;
import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.Security;
import com.kh.lgtw.approval.model.vo.SignForm;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.common.model.vo.Attachment;
import com.kh.lgtw.employee.model.vo.Employee;

@Service
public class ApprovalServiceImpl implements ApprovalService{
	@Autowired
	private ApprovalDao ad;
	@Autowired
	private SqlSession session;
	
	//진행중인 전체문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showAllPrograssDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showAllPrograssDocument(pi, session);
	}
	@Override
	public int selectAllPrograssDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectAllPrograssDcm(empNo, session);
	}
	@Override
	public int selectAllPrograssDcm(int empNo, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		map.put("empNo", empNo);
		
		return ad.selectAllPrograssDcm(map, session);
	}

	
	//결재대기문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitDcm(pi, session);
	}
	@Override
	public int selectWaitDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectWaitDcm(empNo, session);
	}
	//처리예정문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showIntendedDcm(pi, session);
	}
	@Override
	public int selectIntendedDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectIntendedDcm(empNo, session);
	}
	//처리중인문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showProgressgDcm(pi, session);
	}
	@Override
	public int selectProgressDcm(int empNo, String string) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empNo", empNo);
		map.put("type", string);
		
		return ad.selectProgressDcm(map, session);
	}
	//내가 기안한 문서
	@Override
	public int selectMyWriteDcm(int empNo, String string) {
		// TODO Auto-generated method stub
		return ad.selectMyWriteDcm(empNo, session);
	}
	//내가 기안한 문서
	@Override
	public ArrayList<HashMap<String, Object>> showMyWriteDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showMyWriteDcm(pi, session);
	}

	//수신대기 문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitReceptionDcm(pi, session);
	}
	@Override
	public int selectWaitRecptionDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectWaitReceptionDcm(empNo, session);
	}
//	//회람대기 문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitCirculationDcm(pi, session);
	}
	@Override
	public int selectWaitCircleDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectWaitCircleDcm(empNo, session);
	}
//	//-------------------------완료문서-----------------------------
	//완료문서 - 전체보기
	@Override
	public ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi, String jobCode) {
		// TODO Auto-generated method stub
		return ad.showAllFinishDcm(pi, session, jobCode);
	}
	@Override
	public int selecAllFinishDcm(String jobCode, int empNo) {
		// TODO Auto-generated method stub
		return ad.selecAllFinishDcm(empNo, jobCode, session);
	}

//	//완료문서-기안한문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi) {
//		// TODO Auto-generated method stub
//		return ad.showWriteDcm(pi, session);
//	}
//	//완료문서-결재문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi) {
//		// TODO Auto-generated method stub
//		return ad.showFinApprovaldDcm(pi, session);
//	}
//	//완료문서-수신문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi) {
//		// TODO Auto-generated method stub
//		return ad.showReceptionDcm(pi, session);
//	}
	//완료문서-회람/참조 문서
	@Override
	public ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showCirculationDcm(pi, session);
	}
	@Override
	public int selectCircleDcm(int empNo, String s) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empNo", empNo);
		map.put("sort", s);
		
		return ad.selectCircleDcm(map, session);
	}
//	//완료문서-반려문서
//	@Override
//	public ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi) {
//		// TODO Auto-generated method stub
//		return ad.showRefuseDcm(pi, session);
//	}
//
	@Override
	public int selectSaveDcm(int empNo) {
		// TODO Auto-generated method stub
		return ad.selectSaveDcm(empNo, session);
	}
	@Override
	public ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showSaveDcm(pi, session);
	}
//	//------------------------관리자설정-----------------------------
//	//전자결재 관리자
//	@Override
//	public ArrayList<Employee> showAppManager() {
//		// TODO Auto-generated method stub
//		return ad.showAppManager(session);
//	}
	//관리자 추가
	@Override
	public int insertApprovalMng(ArrayList<Object> empList) {
		// TODO Auto-generated method stub
		return ad.insertApprovalMng(session, empList);
	}
	//관리자삭제
	@Override
	public int deleteManager(ArrayList<Object> empList) {
		// TODO Auto-generated method stub
		return ad.deleteManager(session, empList);
	}
	
	
	//양식관리
	@Override
	public ArrayList<AppForm> showFormManagement(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showFormManagement(session, pi);
	}
	//양식관리 페이징
	@Override
	public int getFormManagementListCount() {
		// TODO Auto-generated method stub
		return ad.getFormManagementListCount(session);
	}
	
	//결재 양식 가져오기
	@Override
	public SignForm selectSignForm(SignForm sf) {
		
		return ad.selectSignForm(session, sf);
	}
	
//	//양식생성
	@Override
	public int insertAppForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.insertAppForm(session, form);
	}
	//
	
	//양식 삭제
	@Override
	public int deleteAppForm(List<String> afNo) {
		// TODO Auto-generated method stub
		return ad.deleteAppForm(session, afNo);
	}
	//양식 수정
	@Override
	public int updateAppForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.updateAppForm(session, form);		
	}
	//사용 미사용 전환
	@Override
	public int statusUpdateAppForm(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ad.statusUpdateAppForm(session, map);
	}
	

//	//제공양식 보기
//	@Override
//	public ArrayList<AppForm> selectOfferDcm() {
//		// TODO Auto-generated method stub
//		return ad.selectOfferDcm(session);
//	}
	//양식상세
	@Override
	public AppForm selectOneAppFormDcm(int afNo) {
		// TODO Auto-generated method stub
		return ad.selectOneAppFormDcm(session, afNo);
	}
//	//제공양식저장
//	@Override
//	public int saveOfferDcm(int[] afNo) {
//		// TODO Auto-generated method stub
//		return ad.saveOfferDcm(session, afNo);
//	}
	//전체문서목록
	@Override
	public ArrayList<HashMap<String, Object>> showAllDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showAllDcm(session, pi);
	}
	@Override
	public int countAllDcm() {
		// TODO Auto-generated method stub
		return ad.countAllDcm(session);
	}
	
	//삭제문서 전체
	@Override
	public ArrayList<HashMap<String, Object>> showDeleteDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showDeleteDcm(session, pi);
	}
	//완전삭제
	@Override
	public int permanentlyDeleteDcm(String[] adNoArr) {
		
		int result = ad.deleteAppList(adNoArr, session);
		int result2 = 0;
		
		if(result > 0) {
			result2 = ad.permanentlyDeleteDcm(adNoArr, session);
		}
		
		return result2;
	}
	
	@Override
	public int countDeleteDcm() {
		// TODO Auto-generated method stub
		return ad.countDeleteDcm(session);
	}

	//옵션 보안등급 조회
	@Override
	public ArrayList<Security> selectSecurity() {
		// TODO Auto-generated method stub
		ArrayList<Security> list = ad.selectSecurity(session);

		return ad.selectSecurity(session);
	}
//	//-----------------------------문서 상세보기 및 결재기능--------------------------------------
	//문서 상세보기
	@Override
	public HashMap<String, Object> showDetailDcm(String adNo, int empNo) {
		
		HashMap<String, Object> map = ad.showDetailDcm(session, adNo);
		
		if(map != null) {
			int result = ad.readAppDcm(session, adNo, empNo);
		}
		
		return map;
	}
	public HashMap<String, Object> showDetailDcm(String adNo) {
		
		HashMap<String, Object> map = ad.showDetailDcm(session, adNo);
		
		return map;
	}
	//결재리스트 불러오기
	@Override
	public HashMap<String, ArrayList<HashMap<String, Object>>> selectAppList(String adNo) {
		
		HashMap<String, ArrayList<HashMap<String, Object>>> appList = new HashMap<String, ArrayList<HashMap<String,Object>>>();
		
		ArrayList<HashMap<String, Object>> approval = ad.selectApprovalList(session, adNo, "결재");
		ArrayList<HashMap<String, Object>> agree = ad.selectApprovalList(session, adNo, "합의");
		ArrayList<HashMap<String, Object>> ref = ad.selectApprovalList(session, adNo, "참조");
		ArrayList<HashMap<String, Object>> apply = ad.selectApprovalList(session, adNo, "신청");
		ArrayList<HashMap<String, Object>> process = ad.selectApprovalList(session, adNo, "처리");
		ArrayList<HashMap<String, Object>> payAgree = ad.selectApprovalList(session, adNo, "재무합의");
		ArrayList<HashMap<String, Object>> send = ad.selectApprovalList(session, adNo, "수신");
		ArrayList<HashMap<String, Object>> circle = ad.selectApprovalList(session, adNo, "회람");
		ArrayList<HashMap<String, Object>> reply = ad.selectAdReply(session, adNo);
		
		appList.put("approval", approval);
		appList.put("agree", agree);
		appList.put("ref", ref);
		appList.put("apply", apply);
		appList.put("apply", apply);
		appList.put("process", process);
		appList.put("payAgree", payAgree);
		appList.put("send", send);
		appList.put("circle", circle);
		appList.put("reply", reply);
		
		
		return appList;
	}
	//문서결재
	@Override
	public int updateApproval(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			int result2 = ad.updateAdLevel(session, map);
			if(result2 > 0) {
				String result3 = ad.selectNormalApprovalYN(session, map);
				if(result3.equals("Y")) {
					String result4 = ad.selectApprovalYN(session, map);
					if(result4.equals("Y")) {
						int result5 = ad.updateAdStatus(session, map, "완료");
					}else {
						int result6 = ad.countAgreeMember(session, map);
						int result7 = ad.countPayAgreeMember(session, map);
						if(result6 > 0) {
							int result8 = ad.updateAdStatusAndLevel(session, map, "합의대기");
						}else if(result7 > 0){
							int result9 = ad.updateAdStatusAndLevel(session, map, "재무합의대기");
						}
					}
				}
			}
		}else {
			int result5 = ad.updateAdStatus(session, map, "반려");
		}
		
		return result;
	}
	//문서합의
	@Override
	public int updateAgree(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			String result2 = ad.selectAgreeApprovalYN(session, map);
			if(result2.equals("Y")) {
				String result4 = ad.selectApprovalYN(session, map);
				if(result4.equals("Y")) {
					int result5 = ad.updateAdStatus(session, map, "완료");
				}else {
					int result6 = ad.updateAdStatusAndLevel(session, map, "재무합의대기");
				}
			}
		}else {
			int result5 = ad.updateAdStatus(session, map, "반려");
		}
		
		return result;
	}
	
	//재무합의
	@Override
	public int updatePayAgree(HashMap<String, Object> map) {
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			int result2 = ad.updateAdLevel(session, map);
			String result3 = ad.selectPayAgreeApprovalYN(session, map);
			if(result3.equals("Y")) {
				int resul4 = ad.updateAdStatus(session, map, "완료");
			}
		}else {
			int result5 = ad.updateAdStatus(session, map, "반려");
		}
		
		return result;
	}
	//신청결재
	@Override
	public int updateApply(HashMap<String, Object> map) {
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			int result2 = ad.updateAdLevel(session, map);
			String result3 = ad.selectApplyApprovalYN(session, map);
			if(result3.equals("Y")) {
				String result4 = ad.selectApprovalYN(session, map);
				if(result4.equals("Y")) {
					int result5 = ad.updateAdStatus(session, map, "완료");
				}else {
					int result6 = ad.updateAdStatusAndLevel(session, map, "처리대기");
				}
			}
		}else {
			int result5 = ad.updateAdStatus(session, map, "반려");
		}
		
		return result;
	}
	//처리결재
	@Override
	public int updateProcess(HashMap<String, Object> map) {
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			int result2 = ad.updateAdLevel(session, map);
			String result3 = ad.selectProcessApprovalYN(session, map);
			if(result3.equals("Y")) {
				int resul4 = ad.updateAdStatus(session, map, "완료");
			}
		}else {
			int result5 = ad.updateAdStatus(session, map, "반려");
		}
		
		return result;
	}
	//송신문서 결재
	@Override
	public int updateSendApproval(HashMap<String, Object> map) {
		int result = ad.updateApproval(session, map);
		
		if(result > 0 && ((String)map.get("status")).equals("결재")) {
			int result2 = ad.updateAdLevel(session, map);
			String result3 = ad.selectApprovalYN(session, map);
			if(result3.equals("Y")) {
				int result6 = ad.updateAdStatusAndLevel(session, map, "수신대기");
			}
		}
		
		return result;
	}

	
	//회람 or 수신 확인
	@Override
	public int confirmDcm(String adNo, int empNo) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adNo", adNo);
		map.put("empNo", empNo);
		
		int result = ad.confirmDcm(session, map);
		
		if(result > 0) {
			String result2 = ad.selectCircleEmp(session, map);
			String result3 = ad.selectSendEmp(session, map);
			if(result2.equals("Y")) {
				ad.updateAdStatus(session, map, "완료");
			}else if(result3.equals("Y")) {
				ad.updateAdStatus(session, map, "완료");
			}
				
		}
		
		return ad.confirmDcm(session, map);
	}
	
	@Override
	public int confirmSendDcm(String adNo, int empNo) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adNo", adNo);
		map.put("empNo", empNo);
		
		int result = ad.confirmDcm(session, map);
		
		if(result > 0) {
			String result2 = ad.selectSendEmp(session, map);
			if(result2.equals("Y")) {
				ad.updateAdStatus(session, map, "완료");
			}
				
		}
		
		return ad.confirmDcm(session, map);
	}
//	//수신, 회람추가
//	@Override
//	public int updateDcm(String adNo, int eid) {
//		// TODO Auto-generated method stub
//		return ad.updateDcm(session, eid, adNo);
//	}
//	//작성하기 폼 이동
	@Override
	public ArrayList<HashMap<String, Object>> selectFormList() {
		// TODO Auto-generated method stub
		return ad.selectFormList(session);
	}
	//사원 선택
	@Override
	public Map<String, ArrayList<HashMap<String, Object>>> selectEmp() {
		
		Map<String, ArrayList<HashMap<String, Object>>> map = new HashMap<String, ArrayList<HashMap<String,Object>>>();
		
		ArrayList<HashMap<String, Object>> empList =  ad.selectEmp(session);
		ArrayList<HashMap<String, Object>> deptList = ad.selectDept(session);
//		System.out.println(empList);
		if(empList != null && deptList != null) {
			map.put("empList", empList);
			map.put("deptList", deptList);
		}
		
		return map;
	}
	
	//하위부서 사원 및 부서선택
	@Override
	public Map<String, ArrayList<HashMap<String, Object>>> selectUnderDept(String deptCode) {
		
		Map<String, ArrayList<HashMap<String, Object>>> map = new HashMap<String, ArrayList<HashMap<String, Object>>>();
		
		ArrayList<HashMap<String, Object>> deptList = ad.selectDept(session, deptCode);
		ArrayList<HashMap<String, Object>> empList =  ad.selectEmp(session, deptCode);
		
		if(empList != null && deptList != null) {
			map.put("empList", empList);
			map.put("deptList", deptList);
		}
		
		return map;
	}
	
	@Override
	public int writeApproval(Map<String, Object> appDcm) {
		int result = 0;
		int count = 0;
		int result1 = ad.writeApproval((AppDocument)appDcm.get("ad"), session);

		if(result1 > 0) {
			
			switch((int)appDcm.get("type")) {
			case 1 : result += ad.insertCircleList(appDcm, session);
					count = 1;
				break;
			case 2 : result += ad.insertApprovalList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);						
					}
					 result += ad.insertSendList(appDcm, session);
					 count = 3;
				break;
			case 3 : result += ad.insertApprovalList(appDcm, session);
					result += ad.insertAgreeList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);						
					}
					count = 3;
				break;
			case 4 : result += ad.insertApprovalList(appDcm, session);
					result += ad.insertPayAgreeList(appDcm, session);
					result += ad.insertAgreeList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);						
					}
					count = 4;
				break;
			case 5 : result += ad.insertApplyList(appDcm, session);
					result += ad.insertProcessList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);						
					}
					count = 3;
				break;
			}

		}
		
		/*
		 * if(count != result ) { result = 0; }
		 */
		
		
		return result;
	}
	
	@Override
	public int writeApprovalAndFile(Map<String, Object> appDcm, HashMap<String, Object> file) {
		int result = 0;
		int count = 0;
		int result1 = ad.writeApproval((AppDocument)appDcm.get("ad"), session);

		if(result1 > 0) {
			
			switch((int)appDcm.get("type")) {
			case 1 : result += ad.insertCircleList(appDcm, session);
					count = 1;
				break;
			case 2 : result += ad.insertApprovalList(appDcm, session);
					count += 1;
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);
						count += 1;
					}
					 result += ad.insertSendList(appDcm, session);
					 count += 1;
				break;
			case 3 : result += ad.insertApprovalList(appDcm, session);
					result += ad.insertAgreeList(appDcm, session);
					count += 2;
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);	
						count += 1;
					}
				break;
			case 4 : result += ad.insertApprovalList(appDcm, session);
					result += ad.insertPayAgreeList(appDcm, session);
					result += ad.insertAgreeList(appDcm, session);
					count += 3;
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);	
						count += 1;
					}
				break;
			case 5 : result += ad.insertApplyList(appDcm, session);
					result += ad.insertProcessList(appDcm, session);
					count += 2;
					if(appDcm.get("reference") != null) {
						result += ad.insertReferenceList(appDcm, session);						
						count += 1;
					}
				break;
			}
			
			if(count == result) {
				System.out.println("작동?");
				int result3 = ad.uploadFile(file, session);
			}else {
				return result;
			}		
		}
		return result1;
	}
	//문서 업데이트
	@Override
	public int updateApprovalDcm(Map<String, Object> appDcm) {
		int result = 0;
		int count = 0;
		int result1 = ad.updateApprovalDcm((AppDocument)appDcm.get("ad"), session);
		
		int result2 = ad.deleteAppList(((AppDocument)appDcm.get("ad")).getAdNo(), session);
		
		if(result1 > 0) {
			
			switch((int)appDcm.get("type")) {
			case 1 : result += ad.updateCircleList(appDcm, session);
					count = 1;
				break;
			case 2 : result += ad.updateApprovalList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.updateReferenceList(appDcm, session);						
					}
					 result += ad.updateSendList(appDcm, session);
					 count = 3;
				break;
			case 3 : result += ad.updateApprovalList(appDcm, session);
					result += ad.updateAgreeList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.updateReferenceList(appDcm, session);						
					}
					count = 3;
				break;
			case 4 : result += ad.updateApprovalList(appDcm, session);
					result += ad.updatePayAgreeList(appDcm, session);
					result += ad.updateAgreeList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.updateReferenceList(appDcm, session);						
					}
					count = 4;
				break;
			case 5 : result += ad.updateApplyList(appDcm, session);
					result += ad.updateProcessList(appDcm, session);
					if(appDcm.get("reference") != null) {
						result += ad.updateReferenceList(appDcm, session);						
					}
					count = 3;
				break;
			}
		}
		
		return result;
	}


	
//	//문서양식 불러오기
//	@Override
//	public AppForm selectDcmForm(int afNo) {
//		// TODO Auto-generated method stub
//		return ad.selectDcmForm(session, afNo);
//	}
//	//결재선 불러오기
//	@Override
//	public ArrayList<SignLine> selectApprovalLine(int eid) {
//		// TODO Auto-generated method stub
//		return ad.selectApprovalLine(session, eid);
//	}
//	//참조자 설정
//	@Override
//	public ArrayList<Employee> selectReferenceEmp(String name) {
//		// TODO Auto-generated method stub
//		return ad.selectReferenceEmp(session, name);
//	}
//	//문서 저장
//	@Override
//	public int saveApprovalDcm(AppDocument aDcm) {
//		// TODO Auto-generated method stub
//		return ad.saveApprovalDcm(session, aDcm);
//	}
//	//결재문서 작성완료
//	@Override
//	public int insertApprovalDcm(AppDocument aDcm, int []eid) {
//		// TODO Auto-generated method stub
//		int result = 0;
//		
//		int result1 = ad.insertApprovalDcm(session, aDcm);
//		int result2 = ad.insertApprovalList(session, aDcm, eid);
//		
//		if(result1 > 0 && result2 > 0) {
//			result = 1;
//		}
//		
//		return result;
//	}
	@Override
	public ArrayList<HashMap<String, Object>> selectJob() {
		// TODO Auto-generated method stub
		return ad.selectJob(session);
	}
	@Override
	public int updateGrade(Map<String, String> grade) {
		// TODO Auto-generated method stub
		return ad.updateGrade(session, grade);
	}
	@Override
	public HashMap<String, Object> selectWriteForm(int afNo) {
		// TODO Auto-generated method stub
		return ad.selectWriteForm(afNo, session);
	}
	//자동완성
	@Override
	public List<HashMap<String, Object>> autocompleteCircle(String value) {
		// TODO Auto-generated method stub
		return ad.autocompleteCircle(value, session);
	}
	@Override
	public String selectEmpJobCode(Employee e) {
		// TODO Auto-generated method stub
		return ad.selectEmpJobCode(e, session);
	}
	//완료문서 (결재)
	@Override
	public int selectFinApprovaldDcm(String jobCode) {
		// TODO Auto-generated method stub
		return ad.selectFinApprovaldDcm(session, jobCode);
	}
	@Override
	public ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi, String jobCode) {
		// TODO Auto-generated method stub
		return ad.showFinApprovaldDcm(pi, jobCode, session);
	}
	
	//기안한 완료문서
	@Override
	public int selectWriteDcm(Employee e) {
		// TODO Auto-generated method stub
		return ad.selectWriteDcm(session, e);
	}
	@Override
	public ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWriteDcm(session, pi);
	}
	@Override
	public int selectRefuseDcm(String jobCode) {
		// TODO Auto-generated method stub
		return ad.selectRefuseDcm(session, jobCode);
	}
	@Override
	public ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi, String jobCode) {
		// TODO Auto-generated method stub
		return ad.showRefuseDcm(pi, jobCode, session);
	}
	@Override
	public HashMap<String, Object> selectDcmCount(int empNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("empNo", empNo);
		map.put("sort", "circle");
		
		int wait = ad.selectWaitDcm(empNo, session);
		int all = ad.selectAllPrograssDcm(empNo, session);
		int write = ad.selectMyWriteDcm(empNo, session);
		int progress = ad.selectProgressDcm(map, session);
		int intended = ad.selectIntendedDcm(empNo, session);
		int circle = ad.selectWaitCircleDcm(empNo, session);
		map.put("sort", "reception");
		int reception = ad.selectCircleDcm(map, session);
		
		map.put("wait", wait);
		map.put("all", all);
		map.put("write", write);
		map.put("progress", progress);
		map.put("intended", intended);
		map.put("circle", circle);
		map.put("reception", reception);
		
				
		
		return map;
	}
	@Override
	public int deleteDcm(String[] adNoArr) {
		// TODO Auto-generated method stub	
		return ad.deleteDcm(adNoArr, session);
	}
	//문서복구
	@Override
	public int recoveryDcm(String[] adNoArr) {
		
		return ad.recoveryDcm(session, adNoArr);
	}
	@Override
	public ArrayList<Employee> showApprovalManager() {
		// TODO Auto-generated method stub
		return ad.showApprovalManager(session);
	}
	//댓글작성
	@Override
	public int writeReply(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return ad.writeReply(map, session);
	}
	@Override
	public int updateReply(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return ad.updateReply(map, session);
	}
	@Override
	public int deleteReply(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return ad.deleteReply(map, session);
	}
	@Override
	public Attachment downloadFile(int adNo) {
		// TODO Auto-generated method stub
		return ad.downloadFile(adNo, session);
	}
	@Override
	public int cancleAppDcm(String adNo) {
		// TODO Auto-generated method stub
		return ad.cancleAppDcm(adNo, session);
	}



	
	
	

	
	

	
	
}
