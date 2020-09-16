package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroductionController {

	
	@GetMapping("/introduction/greeting")
	public String greeting() {
		return "/introduction/greeting";
	}
	
	@GetMapping("/introduction/direction")
	public String direction() {
		return "/introduction/direction";
	}
	
}
