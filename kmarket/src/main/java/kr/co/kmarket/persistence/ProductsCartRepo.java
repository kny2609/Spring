package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsCartVo;

@Repository
public interface ProductsCartRepo extends JpaRepository<ProductsCartVo, Integer> {

}
