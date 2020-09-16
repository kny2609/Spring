package kr.co.ch10.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch10.vo.UserVO;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/index"})
	public String index(Model model) {
		
		String tit = "Hello 타임리프!";
		UserVO member = new UserVO("", "", 21, "");
		
		List<UserVO> users = new ArrayList<>();
		users.add(new UserVO("A101", "김유신", 21, "2020-09-16 13:00"));
		users.add(new UserVO("A102", "김춘추", 22, "2020-09-17 13:00"));
		users.add(new UserVO("A103", "장보고", 23, "2020-09-18 13:00"));
		users.add(new UserVO("A104", "강감찬", 24, "2020-09-19 13:00"));
		users.add(new UserVO("A105", "이순신", 25, "2020-09-20 13:00"));
		
		model.addAttribute("tit", tit);
		model.addAttribute("member", member);
		model.addAttribute("users", users);
		model.addAttribute("now", new Date());
		model.addAttribute("price", 1000000);
		model.addAttribute("cities", "서울,대전,대구,부산,광주");
		
		return "/index";
	}
	
	@GetMapping("/layout1")
	public String layout1() {
		return "/layout1";
	}
	
	@GetMapping("/layout2")
	public String layout2() {
		return "/layout2";
	}
}
