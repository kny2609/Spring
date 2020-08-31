package kr.co.ch02.sub4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2020.08.31
 * 이름 : 김나연
 * 내용 : DI 생성자를 이용한 스프링 IoC 구현
 */

public class IoCTest {
	public static void main(String[] args) {
		
		// IoC를  적용할 경우 
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		TV lgTV 	 = (TV) ctx.getBean("sub4LgTV");
		TV samsungTV = (TV) ctx.getBean("sub4SamsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
	}
}
