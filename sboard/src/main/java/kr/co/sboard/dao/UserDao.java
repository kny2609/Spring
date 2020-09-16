package kr.co.sboard.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;

	public UserVO selectUser(UserVO vo) {
		return mybatis.selectOne("mapper.user.SELECT_USER", vo);
		
	}
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	
	public int selectUserCount(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER_COUNT", uid);
	}
	
	public int selectCheckNick(String nick) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_NICK", nick);
	}
	
	public int selectCheckEmail(String email) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_EMAIL", email);
	}
	
	public int selectCheckHp(String hp) {
		return mybatis.selectOne("mapper.user.SELECT_CHECK_HP", hp);
	}
	
	
	
}
