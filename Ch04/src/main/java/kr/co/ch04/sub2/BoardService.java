package kr.co.ch04.sub2;

import org.springframework.stereotype.Component;

@Component("bs2")
public class BoardService {
	
	public void insert() {
		System.out.println("ÇÙ½É°ü½É - insert ...");
		return;
	}
	
	public void select() {
		System.out.println("ÇÙ½É°ü½É - select ...");
	}
	
	public void update(int seq) {
		System.out.println("ÇÙ½É°ü½É - update ...");
	}
	
	public void delete(int seq, String uid) {
		System.out.println("ÇÙ½É°ü½É - delete ...");
		
		char ch = uid.charAt(5);
	}
}
