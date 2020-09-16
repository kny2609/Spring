package kr.co.ch05.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.delete(..))")
	public void deletePointcut() {} // 내용이 없는 참조메서드
	
	@AfterThrowing("deletePointcut()")
	public void afterThrow1() {
		System.out.println("횡단관심 - afterThrow1...");
	}
	
	public void afterThrow2() {
		System.out.println("횡단관심 - afterThrow2...");
	}
	
	public void afterThrow3() {
		System.out.println("횡단관심 - afterThrow3...");
	}
	
}
