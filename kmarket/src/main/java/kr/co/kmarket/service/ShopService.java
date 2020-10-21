package kr.co.kmarket.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDao;
import kr.co.kmarket.vo.OrderTotalInfoVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductsCartVo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class ShopService {
	
	@Autowired
	private ShopDao dao;
	
	public List<ProductsVo> selectProducts(int cate1, int cate2, int sort, int start){
		return dao.selectProducts(cate1, cate2, sort, start);
	}
	
	public ProductsVo selectProduct(int code) {
		return dao.selectProduct(code);
	}
	
	public int insertCart(ProductsCartVo vo) {
		return dao.insertCart(vo);
	}
	
	public List<ProductsCartVo> selectCart(String uid) {
		return dao.selectCart(uid);
	}
	
	public int deleteCart(int[] seqs) {
		return dao.deleteCart(seqs);
	}
	
	public List<ProductsCartVo> selectOrder(int[] seqs) {
		return dao.selectOrder(seqs);
	}
	
	public void setTitles(HttpSession sess, int cate1, int cate2) {
		List<CategoriesVo> categories = (List<CategoriesVo>) sess.getAttribute("cate1List");
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		sess.setAttribute("tit1", tit1);
		sess.setAttribute("tit2", tit2);
	}
	
	public String[] getTitles(HttpSession sess) {
		String tit1 = (String) sess.getAttribute("tit1");
		String tit2 = (String) sess.getAttribute("tit2");
		
		String tits[] = {tit1, tit2};
		return tits;
	}
	
	public OrderTotalInfoVo orderTotalInfo(List<ProductsCartVo> items) {
		
		int count = items.size();
		int price = 0;
		int sale = 0;
		int delivery = 0;
		int point = 0;
		int total = 0;
		
		for(ProductsCartVo item : items) {
			price    += item.getPrice() * item.getCount();
			sale     += (item.getPrice() * item.getDiscount()/100) * item.getCount();
			delivery += item.getDelivery();
			point    += item.getPoint();
			total    += item.getTotal();
		}
		
		// 배송비와 전체금액 최종합산
		total += delivery;
		
		return new OrderTotalInfoVo(count, price, sale, delivery, point, total);
		
	}
	
	// Limit start 계산
	public int getLimitStart(String pg) {
		if(pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
		
	}
	
	// 전체 게시물 갯수
	public int selectCountProducts(int cate1, int cate2){
		return dao.selectCountProducts(cate1, cate2);
	}
	
	// 페이지 번호 계산
	public int getPageEnd(int total) {
		
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		} else {
			pageEnd = (total / 10) + 1; 
		}
		
		return pageEnd;
	}
	
	// list count 계산
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}

}
