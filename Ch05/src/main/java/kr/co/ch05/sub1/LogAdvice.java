package kr.co.ch05.sub1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub1.BoardService.insert(..))")
	public void insertPointcut() {} // 내용이 없는 참조메서드
	
	@Pointcut("execution(* kr.co.ch05.sub1.BoardService.select(..))")
	public void selectPointcut() {} // 내용이 없는 참조메서드

	@Before("insertPointcut()")
	public void beforeLog() {
		System.out.println("횡단관심 - beforeLog...");
	}
	
	@After("selectPointcut()")
	public void afterLog() {
		System.out.println("횡단관심 - afterLog...");
	}
}
