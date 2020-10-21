package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface MainDao {

	public List<CategoriesVo> selectCategories();
	public List<ProductsVo> selectHitProduct();
	public List<ProductsVo> selectBestProduct();
	public List<ProductsVo> selectRecProduct();
	public List<ProductsVo> selectNewProduct();
	public List<ProductsVo> selectDiscountProduct();
	
}
