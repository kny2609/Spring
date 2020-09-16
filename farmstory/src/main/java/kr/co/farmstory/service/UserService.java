package kr.co.farmstory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.UserDao;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	private UserDao dao;
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	
	public UserVO selectUser(UserVO vo) {
		return dao.selectUser(vo);
	}
	
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	public int selectUserCount(String uid) {
		return dao.selectUserCount(uid);
	}

}
