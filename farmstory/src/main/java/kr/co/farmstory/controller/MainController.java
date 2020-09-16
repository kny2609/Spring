package kr.co.farmstory.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.BoardVO;

@Controller
public class MainController {
	
	@Inject
	private BoardService service;

	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		//List<BoardVO> latest1 = service.selectLatest("grow");
		//List<BoardVO> latest2 = service.selectLatest("school");
		//List<BoardVO> latest3 = service.selectLatest("croptalk");
		
		//model.addAttribute("latest1", latest1);
		//model.addAttribute("latest2", latest2);
		//model.addAttribute("latest3", latest3);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/index/latest")
	public List<BoardVO> getLatest(String cate) {
		
		List<BoardVO> latests = service.selectLatest(cate);
		
		return latests;
		
	}
	
}
