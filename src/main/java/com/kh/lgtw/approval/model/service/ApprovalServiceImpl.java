package com.kh.lgtw.approval.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.approval.model.dao.ApprovalDao;
import com.kh.lgtw.approval.model.vo.AppDocument;
import com.kh.lgtw.approval.model.vo.AppForm;
import com.kh.lgtw.approval.model.vo.PageInfo;
import com.kh.lgtw.approval.model.vo.SignLine;
import com.kh.lgtw.employee.model.vo.Employee;

@Service
public class ApprovalServiceImpl implements ApprovalService{
	@Autowired
	private ApprovalDao ad;
	@Autowired
	private SqlSession session;
	
	//진행중인 전체문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showAllPrograssDocument(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showAllPrograssDocument(pi, session);
	}
	//결재대기문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitDcm(pi, session);
	}
	//처리예정문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showIntendedDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showIntendedDcm(pi, session);
	}
	//처리중인문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showProgressgDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showProgressgDcm(pi, session);
	}
	//완료문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showFinishDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showFinishDcm(pi, session);
	}
	//수신대기 문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitReceptionDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitReceptionDcm(pi, session);
	}
	//회람대기 문서 이동
	@Override
	public ArrayList<HashMap<String, Object>> showWaitCirculationDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWaitCirculationDcm(pi, session);
	}
	//-------------------------완료문서-----------------------------
	//완료문서 - 전체보기
	@Override
	public ArrayList<HashMap<String, Object>> showAllFinishDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showAllFinishDcm(pi, session);
	}
	//완료문서-기안한문서
	@Override
	public ArrayList<HashMap<String, Object>> showWriteDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showWriteDcm(pi, session);
	}
	//완료문서-결재문서
	@Override
	public ArrayList<HashMap<String, Object>> showFinApprovaldDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showFinApprovaldDcm(pi, session);
	}
	//완료문서-수신문서
	@Override
	public ArrayList<HashMap<String, Object>> showReceptionDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showReceptionDcm(pi, session);
	}
	//완료문서-회람/참조 문서
	@Override
	public ArrayList<HashMap<String, Object>> showCirculationDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showCirculationDcm(pi, session);
	}
	//완료문서-반려문서
	@Override
	public ArrayList<HashMap<String, Object>> showRefuseDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showRefuseDcm(pi, session);
	}

	//완료문서-임시저장문서
	@Override
	public ArrayList<HashMap<String, Object>> showSaveDcm(PageInfo pi) {
		// TODO Auto-generated method stub
		return ad.showSaveDcm(pi, session);
	}
	//------------------------관리자설정-----------------------------
	//전자결재 관리자
	@Override
	public ArrayList<Employee> showAppManager() {
		// TODO Auto-generated method stub
		return ad.showAppManager(session);
	}
	//관리자 추가
	@Override
	public int insertApprovalMng(int eid) {
		// TODO Auto-generated method stub
		return ad.insertApprovalMng(session, eid);
	}
	//양식관리
	@Override
	public ArrayList<AppForm> showFormManagement() {
		// TODO Auto-generated method stub
		return ad.showFormManagement(session);
	}
	//양식생성
	@Override
	public int insertAppForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.insertAppForm(session, form);
	}
	//양식 삭제
	@Override
	public int delteAppForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.delteAppForm(session, form);
	}
	//양식 수정
	@Override
	public int updateAppForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.updateAppForm(session, form);
	}
	//사용 전환
	@Override
	public int updateUseForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.updateUseForm(session, form);
	}
	//미사용 전환
	@Override
	public int updateNotUserForm(AppForm form) {
		// TODO Auto-generated method stub
		return ad.updateNotUserForm(session, form);
	}
	//제공양식 보기
	@Override
	public ArrayList<AppForm> selectOfferDcm() {
		// TODO Auto-generated method stub
		return ad.selectOfferDcm(session);
	}
	//양식상세
	@Override
	public AppForm selectOneOfferDcm(int afNo) {
		// TODO Auto-generated method stub
		return ad.selectOneOfferDcm(session, afNo);
	}
	//제공양식저장
	@Override
	public int saveOfferDcm(int[] afNo) {
		// TODO Auto-generated method stub
		return ad.saveOfferDcm(session, afNo);
	}
	//전체문서목록
	@Override
	public ArrayList<HashMap<String, Object>> showAllDcm() {
		// TODO Auto-generated method stub
		return ad.showAllDcm(session);
	}
	//삭제문서 전체
	@Override
	public ArrayList<HashMap<String, Object>> showDeleteDcm() {
		// TODO Auto-generated method stub
		return ad.showDeleteDcm(session);
	}
	//-----------------------------문서 상세보기 및 결재기능--------------------------------------
	//문서 상세보기
	@Override
	public HashMap<String, Object> showDetailDcm(String adNo) {
		// TODO Auto-generated method stub
		return ad.showDetailDcm(session, adNo);
	}
	//문서결재
	@Override
	public int approvalDcm(String adNo, int eid) {
		// TODO Auto-generated method stub
		return ad.approvalDcm(session, eid, adNo);
	}
	//회람 or 수신 확인
	@Override
	public int confirmDcm(String adNo, int eid) {
		// TODO Auto-generated method stub
		return ad.confirmDcm(session, eid, adNo);
	}
	//수신, 회람추가
	@Override
	public int updateDcm(String adNo, int eid) {
		// TODO Auto-generated method stub
		return ad.updateDcm(session, eid, adNo);
	}
	//작성하기 폼 이동
	@Override
	public int[] showWriteForm() {
		// TODO Auto-generated method stub
		return ad.showWriteForm(session);
	}
	//문서양식 불러오기
	@Override
	public AppForm selectDcmForm(int afNo) {
		// TODO Auto-generated method stub
		return ad.selectDcmForm(session, afNo);
	}
	//결재선 불러오기
	@Override
	public ArrayList<SignLine> selectApprovalLine(int eid) {
		// TODO Auto-generated method stub
		return ad.selectApprovalLine(session, eid);
	}
	//참조자 설정
	@Override
	public ArrayList<Employee> selectReferenceEmp(String name) {
		// TODO Auto-generated method stub
		return ad.selectReferenceEmp(session, name);
	}
	//문서 저장
	@Override
	public int saveApprovalDcm(AppDocument aDcm) {
		// TODO Auto-generated method stub
		return ad.saveApprovalDcm(session, aDcm);
	}
	//결재문서 작성완료
	@Override
	public int insertApprovalDcm(AppDocument aDcm, int []eid) {
		// TODO Auto-generated method stub
		int result = 0;
		
		int result1 = ad.insertApprovalDcm(session, aDcm);
		int result2 = ad.insertApprovalList(session, aDcm, eid);
		
		if(result1 > 0 && result2 > 0) {
			result = 1;
		}
		
		return result;
	}
	
}
