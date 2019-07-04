package com.kh.lgtw.scheduler.model.service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.lgtw.scheduler.model.dao.SchedulerDao;
import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired private SchedulerDao sd;
	@Autowired SqlSession sqlSession;
	
	//개인캘린더 추가용 메소드
	@Override
	public int insertMemberScheduler(Scheduler sc) {
		return sd.insertMemberScheduler(sqlSession, sc);
	}

  @Override
	public ArrayList<Scheduler> selectSchedulerList(int empNo) {
		return sd.selectSchedulerList(sqlSession, empNo);
	}

  	//전체 조회용 메소드
	@Override
	public HashMap<String, ArrayList<Object>> allSelectSchedule(int empNo) {
		
		return sd.allSelectSchedule(sqlSession, empNo);
	}

	@Override
	public int updateEmpScheduler(Scheduler scheduler) {
		return sd.updateEmpScheduler(sqlSession, scheduler);
	}

	@Override
	public int deleteEmpScheduler(Scheduler scheduler) {
		return sd.deleteEmpScheduler(sqlSession, scheduler);
	}

	@Override
	public int insertGroupScheduler(Scheduler scheduler, List<String> setEmpList, List<String> readEmpList) {
		return sd.insertGroupScheduler(sqlSession, scheduler, setEmpList, readEmpList);
	}

	@Override
	public int updateGroupScheduler(Scheduler scheduler, List<String> setEmpList, List<String> readEmpList) {
		return sd.updateGroupScheduler(sqlSession, scheduler, setEmpList, readEmpList);
	}

	@Override
	public int deleteGroupScheduler(String schedulerNo) {
		return sd.deleteGroupScheduler(sqlSession, schedulerNo);
	}

	//일정 추가용 메소드
	@Override
	public int insertSchedule(Schedule schedule) {
		return sd.insertSchedule(sqlSession, schedule);
	}

	//일정 상세보기용 메소드
	@Override
	public Schedule selectScheduleDetail(Schedule schedule) {
		return sd.selectScheduleDetail(sqlSession, schedule);
	}

	@Override
	public int updateSchedule(Schedule schedule) {
		return sd.updateSchedule(sqlSession, schedule);
	}

	@Override
	public int deleteSchedule(Schedule schedule) {
		return sd.deleteSchedule(sqlSession, schedule);
	}

	@Override
	public int changeStatusN(Scheduler scheduler) {
		return sd.changeStatusN(sqlSession, scheduler);
	}

	@Override
	public int changeStatusY(Scheduler scheduler) {
		return sd.changeStatusY(sqlSession, scheduler);
	}

	@Override
	public int changeGscrStatusN(Scheduler scheduler) {
		
		return sd.changeGscrStatusN(sqlSession, scheduler);
	}

	@Override
	public int changeGscrStatusY(Scheduler scheduler) {
		
		return sd.changeGscrStatusY(sqlSession, scheduler);
	}

	@Override
	public HashMap<String, ArrayList<Object>> selectGMList(int no) {
		
		return sd.selectGMList(sqlSession, no);
	}

}
