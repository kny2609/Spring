package kr.co.ch04.sub1;

import org.springframework.stereotype.Service;

@Service
public class LogAdvice {

	public void beforeLog() {
		System.out.println("=======================");
		System.out.println("È¾´Ü°ü½É - beforeLog...");
	}
	
	public void afterLog() {
		System.out.println("È¾´Ü°ü½É - afterLog...");
		System.out.println("-----------------------");
	}
}
