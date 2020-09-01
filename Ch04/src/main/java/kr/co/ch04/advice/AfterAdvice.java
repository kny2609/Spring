package kr.co.ch04.advice;

import org.springframework.stereotype.Component;

@Component
public class AfterAdvice {
	
	public void after1() {
		System.out.println("È¾´Ü°ü½É - after1...");
	}
	
	public void after2() {
		System.out.println("È¾´Ü°ü½É - after2...");
	}
	
	public void after3() {
		System.out.println("È¾´Ü°ü½É - after3...");
	}
}
