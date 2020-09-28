package kr.co.ch11.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch11.vo.UserVO;

@Repository
public interface UserDao {

	public void insertUser(UserVO vo);
	public UserVO selectUser();
	public List<UserVO> selectUsers();
	public void updateUser(UserVO vo);
	public void deleteUser(String uid);
	
}
