package kr.co.sboard;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.controller.BoardController;
import kr.co.sboard.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class BoardControllerTest {

	@Inject
	private BoardController controller;
	
	public void write() {
		BoardVO vo = new BoardVO();
		
	}
	
}
