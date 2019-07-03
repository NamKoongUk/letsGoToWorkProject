package com.kh.lgtw.common;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kh.lgtw.employee.model.vo.Employee;

@Component
@Aspect
public class LoginLogging {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogging.class);
	
	@Pointcut("execution(* com.kh.lgtw..*ServiceImpl.*(..))")
	public void loginPointcut() {}
	
	@AfterReturning(pointcut="loginPointcut()", returning="returnObj")
	public void loginLog(JoinPoint jp, Object returnObj) {	
		
		System.out.println("login ReturnObject : " + returnObj);
		
		if(returnObj instanceof Employee) {
			Employee employee = (Employee) returnObj;
			
			logger.info(new Date() + " : $" + employee.getEmpId() + "$ 님이 접속했습니다.");
			
		}
	}
}
