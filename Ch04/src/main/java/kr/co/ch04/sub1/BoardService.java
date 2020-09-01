package kr.co.ch04.sub1;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Inject
	private LogAdvice log;
	
	public void insert() {
		log.beforeLog();
		System.out.println("ÇÙ½É°ü½É - insert ...");
		log.afterLog();
	}
	
	public void select() {
		System.out.println("ÇÙ½É°ü½É - select ...");
	}
	
	public void update(int seq) {
		System.out.println("ÇÙ½É°ü½É - update ...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("ÇÙ½É°ü½É - delete ...");
	}
}
