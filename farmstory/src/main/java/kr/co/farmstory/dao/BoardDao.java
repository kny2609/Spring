package kr.co.farmstory.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


import kr.co.farmstory.vo.BoardVO;

@Repository
public class BoardDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertBoard() {}
	public void selectBoard() {}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		
		Map<String, Object> values = new HashMap<>();
		values.put("start", start);
		values.put("cate", cate);
		
		return mybatis.selectList("mapper.board.SELECT_BOARDS", values);
	}
	
	public int selectCountBoard(String cate) {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD", cate);
	}
	
	public void updateBoard() {}
	public void deleteBoard() {}
	
	
	
	public List<BoardVO> selectLatest(String cate) {
		return mybatis.selectList("mapper.board.SELECT_LATEST", cate);
	}
	
}
