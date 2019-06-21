package com.kh.lgtw.scheduler.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.lgtw.scheduler.model.vo.Scheduler;

public interface SchedulerDao {

	int insertMemberScheduler(SqlSession sqlSession, Scheduler sc);

	ArrayList<Scheduler> selectSchedulerList(SqlSession sqlSession, int empNo);

	

}
