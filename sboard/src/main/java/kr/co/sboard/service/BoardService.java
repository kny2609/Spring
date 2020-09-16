package kr.co.sboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Service
public class BoardService {
	
	@Inject
	private BoardDao dao;

	public int insertArticle(BoardVO vo) {
		int seq = dao.insertArticle(vo);
		return seq;
	}
	
	public void insertFile(FileVO fvo) {
		dao.insertFile(fvo);
	}
	
	public BoardVO selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	
	public List<BoardVO> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	
	public void updateHit(BoardVO vo) {
		dao.updateHit(vo);
	}
	
	// Limit start ���
	public int getLimitStart(String pg) {
		if(pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
		
	}
	
	// ��ü �Խù� ����
	public int selectCountArticle() {
		return dao.selectCountArticle();
	}
	
	// ������ ��ȣ ���
	public int getPageEnd(int total) {
		
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		} else {
			pageEnd = (total / 10) + 1; 
		}
		
		return pageEnd;
	}
	
	// list count ���
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	// ���� ������ ���
	public int getCurrentPg(String pg) {
		int currentPg = 0;
		
		if(pg == null) {
			currentPg = 1;
		} else {
			currentPg = Integer.parseInt(pg);
		}
		
		return currentPg;
	}
	
	// ���� ���ε�
	public FileVO fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
		String path = req.getSession().getServletContext().getRealPath("/resources/files/");
		
		if(!file.isEmpty()) {
			// ���� ÷�� ������
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// �������ϸ� ����
			String uName = UUID.randomUUID().toString()+ext;
			
			// ���� ����
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVO vo = new FileVO();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
			
		}else {
			// ���� ÷�� �������� 
			return null;
		}
	}
	
	// ���� �ٿ�ε�
	public void fileDownload() {}
	
	
}
