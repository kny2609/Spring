package kr.co.ch04.advice;

import org.springframework.stereotype.Component;

@Component
public class AfterReturnAdvice {

	public void afterReturn1() {
		System.out.println("È¾´Ü°ü½É - afterReturn1...");
	}
	
	public void afterReturn2() {
		System.out.println("È¾´Ü°ü½É - afterReturn2...");
	}
	
	public void afterReturn3() {
		System.out.println("È¾´Ü°ü½É - afterReturn3...");
	}
	
}
