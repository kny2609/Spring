package kr.co.ch05.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowAdvice {
	
	@Pointcut("execution(* kr.co.ch05.sub2.BoardService.delete(..))")
	public void deletePointcut() {} // ������ ���� �����޼���
	
	@AfterThrowing("deletePointcut()")
	public void afterThrow1() {
		System.out.println("Ⱦ�ܰ��� - afterThrow1...");
	}
	
	public void afterThrow2() {
		System.out.println("Ⱦ�ܰ��� - afterThrow2...");
	}
	
	public void afterThrow3() {
		System.out.println("Ⱦ�ܰ��� - afterThrow3...");
	}
	
}
