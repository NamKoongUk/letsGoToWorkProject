package com.kh.lgtw.scheduler.model.service;

import java.util.ArrayList;
import java.util.HashMap;

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

	@Override
	public HashMap<String, ArrayList<Object>> allSelectSchedule(int empNo) {
		return null;
	}

	@Override
	public int updateMemberScheduler() {
		return 0;
	}

	@Override
	public int deleteMemberScheduler() {
		return 0;
	}

	@Override
	public int insertGroupScheduler() {
		return 0;
	}

	@Override
	public int updateGroupScheduler() {
		return 0;
	}

	@Override
	public int deleteGroupScheduler() {
		return 0;
	}

	@Override
	public int insertSchedule() {
		return 0;
	}

	@Override
	public Schedule selectScheduleDetail() {
		return null;
	}

	@Override
	public int updateSchedule() {
		return 0;
	}

	@Override
	public int deleteSchedule() {
		return 0;
	}
}
