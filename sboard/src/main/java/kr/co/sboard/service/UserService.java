package kr.co.sboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {

	@Inject
	private UserDao dao;
	
	public UserVO selectUser(UserVO vo) {
		return dao.selectUser(vo);
		
	}
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	public int selectUserCount(String uid) {
		return dao.selectUserCount(uid);
	}
	
	public int selectCheckNick(String nick) {
		return dao.selectCheckNick(nick);
	}
	
	public int selectCheckEmail(String email) {
		return dao.selectCheckEmail(email);
	}
	
	public int selectCheckHp(String hp) {
		return dao.selectCheckHp(hp);
	}
	
}
