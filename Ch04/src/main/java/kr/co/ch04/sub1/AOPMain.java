package kr.co.ch04.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2020.09.01
 * 이름 : 김나연
 * 내용 : AOP 실습하기
 * 
 * 스프링 AOP
 *  - 핵심관심과 공통관심(횡단관심)을 분리해서 프로그래밍하는 방식
 *  
 * 주요용어
 *  1) JoinPoint
 *    - 실행하는 모든 핵심관심 메서드(모든 Pointcut)

 *  2) Pointcut
 *    - 조인포인트 가운데 AOP가 설정된 핵심관심 메서드
 *    
 *  3) Advice
 *    - 횡단관심에 해당하는 공통의 부가기능 메서드
 *    
 *  4) Aspect
 *    - 포인트컷과 어드바이스의 결합된 모듈형태
 *    
 *  5) Weaving
 *    - 포인트컷(핵심관심)이 실행될때 어드바이스가 포인트컷에 결합되는 과정
 * 
 */

public class AOPMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		BoardService bs = (BoardService) ctx.getBean("boardService");
		
		bs.insert();
		bs.select();
		bs.update(1);
		bs.delete(1, "abcd");
		
	}
	
}
