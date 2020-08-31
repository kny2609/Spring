package kr.co.ch02.sub4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥ : 2020.08.31
 * �̸� : �質��
 * ���� : DI �����ڸ� �̿��� ������ IoC ����
 */

public class IoCTest {
	public static void main(String[] args) {
		
		// IoC��  ������ ��� 
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