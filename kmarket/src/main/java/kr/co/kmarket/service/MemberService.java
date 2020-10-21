package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MemberDao;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ResultVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public ResultVo selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	};
	
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	};

}
