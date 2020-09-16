package kr.co.ch05.sub1;


import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	public void insert() {
		System.out.println("ÇÙ½É°ü½É - insert ...");
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
