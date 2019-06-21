package com.kh.lgtw.scheduler.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import com.kh.lgtw.scheduler.model.vo.Schedule;
import com.kh.lgtw.scheduler.model.vo.Scheduler;

public interface SchedulerService {
	int insertMemberScheduler(Scheduler sc);

  HashMap<String, ArrayList<Object>> allSelectSchedule(int empNo);

	int updateMemberScheduler();

	int deleteMemberScheduler();

	int insertGroupScheduler();

	int updateGroupScheduler();

	int deleteGroupScheduler();

	int insertSchedule();

	Schedule selectScheduleDetail();

	int updateSchedule();

	int deleteSchedule();
  
	ArrayList<Scheduler> selectSchedulerList(int empNo);

}
