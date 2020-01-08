package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Around("execution(* *..*.*Controller.*(..))")
	public Object statLog(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("メソッド開始：" + joinPoint.getSignature());

		try {
			Object result = joinPoint.proceed();
			System.out.println("メソッド終了：" + joinPoint.getSignature());
			return result;
		}catch(Exception e) {
			System.out.println("メソッド異常終了：" + joinPoint.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	@Around("execution(* *..*.*UserDao*.*(..))")
	public Object userDaoLog(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Start *UserDao*：" + joinPoint.getSignature());

		try {
			Object result = joinPoint.proceed();
			System.out.println("End *UserDao*：" + joinPoint.getSignature());
			return result;
		}catch(Exception e) {
			System.out.println("Exception *UserDao*：" + joinPoint.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

}

