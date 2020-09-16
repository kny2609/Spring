package kr.co.sboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UnitDaoTest {

	@Inject
	private UserDao dao;
	
	
	public void selectTerms() {
		dao.selectTerms();
	}
	
	
	public void selectUserCount() {
		int result = dao.selectUserCount("abcd");
		System.out.println("result : "+result);
	}
	
	@Test
	public void insertUser() {
		UserVO vo = new UserVO();
		vo.setUid("algjeial");
		vo.setPass1("1234");
		vo.setName("¿”≤©¡§");
		vo.setNick("≤©¡§");
		vo.setEmail("asldkfj@naver.com");
		vo.setHp("010-1125-9654");
		vo.setRegip("192.168.57.59");
		
		dao.insertUser(vo);
	}
	
}
