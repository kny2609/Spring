package kr.co.ch05.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturnAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.insert(..))")
	public void insertPointcut() {} // 내용이 없는 참조메서드
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.select(..))")
	public void selectPointcut() {} // 내용이 없는 참조메서드
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.update(..))")
	public void updatePointcut() {} // 내용이 없는 참조메서드

	@AfterReturning("insertPointcut()")
	public void afterReturn1() {
		System.out.println("횡단관심 - afterReturn1...");
	}
	
	@AfterReturning("selectPointcut()")
	public void afterReturn2() {
		System.out.println("횡단관심 - afterReturn2...");
	}
	
	@AfterReturning("updatePointcut()")
	public void afterReturn3() {
		System.out.println("횡단관심 - afterReturn3...");
	}
	
}
