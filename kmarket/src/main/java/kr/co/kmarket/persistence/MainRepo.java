package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.Category1Vo;

public interface MainRepo extends JpaRepository<Category1Vo, Integer> {

}
