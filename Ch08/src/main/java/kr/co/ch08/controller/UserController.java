package kr.co.ch08.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch08.service.UserService;
import kr.co.ch08.vo.UserVO;

@Controller
public class UserController {
	
	@Inject
	private UserService service;

	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVO vo) {
		service.insertUser(vo);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/list")
	public String list(Model model) {
		
		List<UserVO> users = service.selectUsers();
		
		model.addAttribute("users", users);
		
		return "/user/list";
	}
	
	@RequestMapping("/user/modify")
	public String modify(String uid, Model model) {
		
		UserVO user = service.selectUser(uid);
		model.addAttribute("user", user);
		
		return "/user/modify";
	}
	
	@RequestMapping(value = "/user/modify", method = RequestMethod.POST)
	public String modify(UserVO vo) {
		
		service.updateUser(vo);
		
		return "redirect:/user/list";
	}
	
	
	@RequestMapping("/user/delete")
	public String delete(String uid) {
		
		service.deleteUser(uid);
				
		return "redirect:/user/list";
	}
	
}
