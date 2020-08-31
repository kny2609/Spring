package kr.co.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2020.08.31
 * 이름 : 김나연
 * 내용 : DI 어노테이션을 이용한 스프링 IoC 구현
 * 
 * 어노테이션 종류
 *  @Component
 *   - 스프링 컨테이너가 해당 어노테이션 선언 클래스를 등록, 관리
 *   - @Controller, @Service, @Repository로 세분화
 *   
 *  @Autowired
 *   - 참조변수(객체)에 객체를 주입하는 어노테이션
 *   - 스프링 전용 어노테이션
 *   
 *  @Inject
 *   - 참조변수(객체)에 객체를 주입하는 어노테이션
 *   - 자바 전용 어노테이션
 * 
 */

public class IoCTest {
	public static void main(String[] args) {
		
		// IoC를  적용할 경우 
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		TV lgTV 	 = (TV) ctx.getBean("lgTV");
		TV samsungTV = (TV) ctx.getBean("samsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
	}
}
