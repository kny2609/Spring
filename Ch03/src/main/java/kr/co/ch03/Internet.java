package kr.co.ch03;

import org.springframework.stereotype.Controller;

// 아무거나 사용가능
// @Component
// @Service
// @ Repository
@Controller
public class Internet {
	
	public void access() {
		System.out.println("인터넷 연결...");
	}
	
}
