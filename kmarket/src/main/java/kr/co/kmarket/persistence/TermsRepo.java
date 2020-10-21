package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.TermsVo;


@Repository
public interface TermsRepo extends JpaRepository<TermsVo, Integer>{

}
