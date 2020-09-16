package kr.co.sboard.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Controller
public class UserController {
	
	@Inject
	private UserService service;
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(HttpSession sess, UserVO vo) {
		
		UserVO user = service.selectUser(vo);
		
		if(user == null) {
			return "redirect:/user/login?success=fail";
		}else {
			sess.setAttribute("member", user);
			return "redirect:/list";
		}
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {
		
		TermsVO vo = service.selectTerms();
		model.addAttribute(vo);
		
		return "/user/terms";
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVO vo, HttpServletRequest req) {
		
		vo.setRegip(req.getRemoteAddr());
		
		service.insertUser(vo);
		
		return "redirect:/user/login";
	}
	
	@ResponseBody // --> 자바 객체(JSON)를 HTTP 응답 몸체로 전송함
	@GetMapping("/user/uidCheck")
	public String uidCheck(String uid) {
		
		int result = service.selectUserCount(uid);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody // --> 자바 객체(JSON)를 HTTP 응답 몸체로 전송함
	@GetMapping("/user/nickCheck")
	public String nickCheck(String nick) {
		
		int result = service.selectCheckNick(nick);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody // --> 자바 객체(JSON)를 HTTP 응답 몸체로 전송함
	@GetMapping("/user/emailCheck")
	public String emailCheck(String email) {
		
		int result = service.selectCheckEmail(email);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody // --> 자바 객체(JSON)를 HTTP 응답 몸체로 전송함
	@GetMapping("/user/hpCheck")
	public String hpCheck(String hp) {
		
		int result = service.selectCheckHp(hp);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
}
