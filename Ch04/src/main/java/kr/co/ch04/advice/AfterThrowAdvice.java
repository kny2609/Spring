package kr.co.ch04.advice;

import org.springframework.stereotype.Component;

@Component
public class AfterThrowAdvice {

	public void afterThrow1() {
		System.out.println("È¾´Ü°ü½É - afterThrow1...");
	}
	
	public void afterThrow2() {
		System.out.println("È¾´Ü°ü½É - afterThrow2...");
	}
	
	public void afterThrow3() {
		System.out.println("È¾´Ü°ü½É - afterThrow3...");
	}
	
}
