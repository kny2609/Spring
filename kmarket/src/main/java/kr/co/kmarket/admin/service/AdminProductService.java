package kr.co.kmarket.admin.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.admin.persistence.AdminProductsRepo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductDao dao;
	@Autowired
	private AdminProductsRepo repo;
	
	public void insertProduct(ProductsVo vo) {
		repo.save(vo);
	}
	
	public ProductsVo selectProduct() {
		return dao.selectProduct();
	}
	
	public List<ProductsVo> selectProductsBySearch(int start, String opt, String keyword) {
		return dao.selectProductsBySearch(start, opt, keyword);
	}
	
	public List<ProductsVo> selectProducts(int start) {
		return dao.selectProducts(start);
	}
	
	public void updateProduct() {
		dao.updateProduct();
	}
	
	public int deleteProduct(String[] codes) {
		return dao.deleteProduct(codes);
	}
	
	// Limit start 계산
	public int getLimitStart(String pg) {
		if(pg == null) {
			return 0;
		}else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
		
	}
	
	// 전체 게시물 갯수
	public int selectCountProducts(){
		return dao.selectCountProducts();
	}
	
	// 페이지 번호 계산
	public int getPageEnd(int total) {
		
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		} else {
			pageEnd = (total / 10) + 1; 
		}
		
		return pageEnd;
	}
	
	// list count 계산
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	@Value("${upload.path}")
	private String uploadPath;
	
	public ProductsVo uploadThumb(ProductsVo vo) {
		
		// 썸네일 업로드
		String path = new File(uploadPath).getAbsolutePath();
		
		MultipartFile[] files = {vo.getFile1(), vo.getFile2(), vo.getFile3(), vo.getFile4()};
		
		for(int i=0; i<4; i++) {
			
			MultipartFile file = files[i];
			
			if(!file.isEmpty()) {
				// 확장자 추출
				String name = file.getOriginalFilename();  
				String ext = name.substring(name.lastIndexOf("."));
				// 고유파일명 생성
				String uName = UUID.randomUUID().toString()+ext;
				String fullPath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";
				
				try {
					Path root = Paths.get(fullPath);
					Files.createDirectories(root);
					
					file.transferTo(new File(fullPath+uName));
					
					if(i==0) vo.setThumb1(uName);
					if(i==1) vo.setThumb2(uName);
					if(i==2) vo.setThumb3(uName);
					if(i==3) vo.setDetail(uName);
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return vo;
		
		
	}

}
