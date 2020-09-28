package kr.co.ch12.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ch12.vo.UserVO;

@Repository
public interface UserRepo extends JpaRepository<UserVO, String>{

	// JPA 쿼리 메서드 정의
	// select * from USER3 order by age asc; 수행
	public List<UserVO> findUserVOByOrderByAgeAsc();
	
	// select * from USER3 order by age desc; 수행
	public List<UserVO> findUserVOByOrderByAgeDesc();
	
}
