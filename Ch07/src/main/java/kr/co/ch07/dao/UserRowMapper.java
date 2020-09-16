package kr.co.ch07.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.co.ch07.vo.UserVO;

public class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserVO vo = new UserVO();
		
		vo.setUid(rs.getString(1));
		vo.setName(rs.getString(2));
		vo.setHp(rs.getString(3));
		vo.setPos(rs.getString(4));
		vo.setDep(rs.getInt(5));
		vo.setRdate(rs.getString(6).substring(0, 10));
		
		return vo;
	}

}
