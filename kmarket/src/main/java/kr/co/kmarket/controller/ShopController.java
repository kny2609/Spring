package kr.co.kmarket.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.persistence.ProductsOrderRepo;
import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.OrderTotalInfoVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductsCartVo;
import kr.co.kmarket.vo.ProductsOrderVo;
import kr.co.kmarket.vo.ProductsVo;
import kr.co.kmarket.vo.ResultVo;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	@Autowired
	private ProductsOrderRepo productsOrderRepo;
	
	@GetMapping("/shop/search")
	public String search() {
		return "/shop/search";
	}
	
	@GetMapping("/shop/list")
	public String list(int cate1, int cate2, int sort, String pg, Model model, HttpSession sess) {
		
		int start = service.getLimitStart(pg);
		int total = service.selectCountProducts(cate1, cate2);
		int pageEnd = service.getPageEnd(total);
		
		List<ProductsVo> items = service.selectProducts(cate1, cate2, sort, start);
		service.setTitles(sess, cate1, cate2);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("items", items);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("currentPg", pg);
		
		return "/shop/list";
	}
	
	@GetMapping("/shop/view")
	public String view(int code, Model model, HttpSession sess) {
		
		MemberVo member = (MemberVo) sess.getAttribute("member");
		ProductsVo vo = service.selectProduct(code);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute(vo);
		model.addAttribute("member", member);
		
		return "/shop/view";
	}
	
	@GetMapping("/shop/cart")
	public String cart(Model model, HttpSession sess) {
		
		MemberVo member = (MemberVo) sess.getAttribute("member");

		if(member != null) {
			List<ProductsCartVo> items = service.selectCart(member.getUid());
			model.addAttribute("items", items);
			
			// 전체합계에 출력할 데이터
			//CartTotalInfoVo totalInfo = service.orderTotalInfo(items);
			//model.addAttribute("totalInfo", totalInfo);
			
			return "/shop/cart";
		}else {
			return "redirect:/member/login?success=cart";
		}
	}
	
	@ResponseBody
	@PostMapping("/shop/cart")
	public ResultVo cart(ProductsCartVo vo) {
		
		int result = service.insertCart(vo);
		return new ResultVo(result);
	}
	
	@ResponseBody
	@PostMapping("/shop/cartDel")
	public int cartDel(int[] seqs) {
		return service.deleteCart(seqs);
	}
	
	@GetMapping("/shop/order")
	public String order(int[] seqs, Model model) {
		
		List<ProductsCartVo> items = service.selectOrder(seqs);
		model.addAttribute("items", items);
		
		OrderTotalInfoVo totalInfo = service.orderTotalInfo(items);
		model.addAttribute("totalInfo", totalInfo);
		
		return "/shop/order";
	}
	
	@PostMapping("/shop/order")
	public String order(ProductsOrderVo vo, int[] cartSeqs) {
		
		vo.setRdate(LocalDateTime.now().toString());	
		
		// 주문 테이블에 주문상품 입력
		// ProductsOrderVo에 @GeneratedValue 붙여야지 ID값인 seq값을 얻을 수 있다.
		ProductsOrderVo ordered = productsOrderRepo.save(vo);
		
		// 주문한 상품은 장바구니에서 삭제
		service.deleteCart(cartSeqs);
		
		return "redirect:/shop/order-complete?seq="+ordered.getSeq();
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete(int seq, Model model) {
		
		ProductsOrderVo vo = productsOrderRepo.findById(seq).get();
		
		String products = vo.getProducts();
		
		
		
		
		model.addAttribute(vo);
		
		return "/shop/order-complete";
	}
	
	
}
