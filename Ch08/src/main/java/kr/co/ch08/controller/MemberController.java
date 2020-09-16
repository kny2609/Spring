package kr.co.ch08.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch08.service.MemberService;
import kr.co.ch08.vo.MemberVO;

@Controller
public class MemberController {

	@Inject
	private MemberService service;
	
	@RequestMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVO vo) {
		
		service.insertMember(vo);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberVO> members = service.selectMembers();
		model.addAttribute("members", members);
		return "/member/list";
	}
	
	
	@GetMapping("/member/modify")
	public String modify(String uid, Model model) {
		
		MemberVO vo = service.selectMember(uid);
		model.addAttribute(vo);
		
		return "/member/modify";
	}
	
	@PostMapping("/member/modify")
	public String modify(MemberVO vo) {
		service.updateMember(vo);
		return "redirect:/member/list";
	}
	
	
	@GetMapping("/member/delete")
	public String delete(String uid) {
		
		service.deleteMember(uid);
		
		return "redirect:/member/list";
	}
}
