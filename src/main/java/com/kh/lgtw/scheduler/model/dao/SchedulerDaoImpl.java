package com.kh.lgtw.scheduler.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.lgtw.scheduler.model.vo.Scheduler;

@Repository
public class SchedulerDaoImpl implements SchedulerDao{

	@Override
	public int insertMemberScheduler(SqlSession sqlSession, Scheduler sc) {
		
		return sqlSession.insert("Scheduler.insertMemberScheduler", sc);
	}

}
