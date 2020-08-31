package kr.co.ch02.sub5;

import org.springframework.stereotype.Component;

@Component
public class Speaker {

	public void soundUp() {
		System.out.println("Sub5 Speaker soundUp...");
	}
	
	public void soundDown() {
		System.out.println("Sub5 Speaker soundDown...");
	}
	
}
