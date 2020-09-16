package kr.co.ch05.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.insert(..))")
	public void insertPointcut() {} // 내용이 없는 참조메서드
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.select(..))")
	public void selectPointcut() {} // 내용이 없는 참조메서드
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.update(..))")
	public void updatePointcut() {} // 내용이 없는 참조메서드
	
	@After("insertPointcut()")
	public void after1() {
		System.out.println("횡단관심 - after1...");
	}
	
	@After("selectPointcut()")
	public void after2() {
		System.out.println("횡단관심 - after2...");
	}
	
	@After("updatePointcut()")
	public void after3() {
		System.out.println("횡단관심 - after3...");
	}
}
