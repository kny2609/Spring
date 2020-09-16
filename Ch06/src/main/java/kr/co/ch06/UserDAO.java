package kr.co.ch06;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // DAO에 사용되는 repository
public class UserDAO {

	@Inject
	private JdbcTemplate jdbc;
	
	public void insertUser() {
		
		Object[] values = {"S101", "홍길동", "010-1123-1234", 40};
		
		jdbc.update("INSERT INTO `USER1` VALUES (?,?,?,?)", values);
		
	}
	
	public void updateUser() {
		String sql = "UPDATE `USER1` SET `name`=? "
					+ "WHERE `uid`=?";
		Object[] values = {"김유신", "S101"};
		
		jdbc.update(sql, values);
	}
	
	public void deleteUser() {
		jdbc.update("DELETE FROM `USER1` WHERE `uid`=?", "ankew");
	}
	
	public UserVO selectUser(String uid) {
		String sql = "SELECT * FROM `USER1` WHERE `uid`=?";
		UserVO vo = jdbc.queryForObject(sql, new UserRowMapper(), uid);
		
		return vo;
	}
	
	public List<UserVO> selectUsers() {
		String sql = "SELECT * FROM `USER1`";
		List<UserVO> users = jdbc.query(sql, new UserRowMapper());
		
		return users;
	}
	
}
