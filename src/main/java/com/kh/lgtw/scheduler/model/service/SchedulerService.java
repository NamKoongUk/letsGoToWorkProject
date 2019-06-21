package com.kh.lgtw.scheduler.model.service;

import java.util.ArrayList;

import com.kh.lgtw.scheduler.model.vo.Scheduler;

public interface SchedulerService {

	int insertMemberScheduler(Scheduler sc);

	ArrayList<Scheduler> selectSchedulerList(int empNo);

	

}
