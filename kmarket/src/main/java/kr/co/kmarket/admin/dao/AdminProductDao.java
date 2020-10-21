package kr.co.kmarket.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface AdminProductDao {
		
	public void insertProduct(ProductsVo vo); 
	
	public ProductsVo selectProduct(); 
	public List<ProductsVo> selectProducts(int start);
	
	public int selectCountProducts();
	public List<ProductsVo> selectProductsBySearch(int start, String opt, String keyword);
	
	public void updateProduct(); 
	
	public int deleteProduct(String[] codes); 
	
}