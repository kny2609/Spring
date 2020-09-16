package kr.co.farmstory.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;


@Repository
public class UserDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public UserVO selectUser(UserVO vo) {
		return mybatis.selectOne("mapper.user.SELECT_USER", vo);
	}
	
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	
	public int selectUserCount(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER_COUNT");
	}
	
}
