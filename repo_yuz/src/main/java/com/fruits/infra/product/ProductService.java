package com.fruits.infra.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
		@Autowired
		private ProductDao productDao;
		
		//selectList
		public List<ProductDto> selectList(ProductVo productVo){
			return productDao.selectList(productVo);
				
		}
		

		//insert
		public int insert(ProductDto productDto) {
			return productDao.insert(productDto);
		}
		
		//selectOne
		public ProductDto selectOne(ProductDto productDto) {
			return productDao.selectOne(productDto);
		}
		
		//update
//		public int update(ProductDto productdto) {
//			return productDao.update(productdto);
//		}
		
		//update축약형
		public int update(ProductDto productDto) {
			System.out.println(productDto.getIfpdSeq());
			return productDao.update(productDto);
		}
//		
		//uelete
		public int uelete(ProductDto productDto) {
			return productDao.uelete(productDto);
		}
		
		//delete
		public int delete(ProductDto productDto) {
			return productDao.delete(productDto);
		}
		
		// paging
		public int selectOneCount(ProductVo productVo) {
			return productDao.selectOneCount(productVo);
		}
		
		// for cache
			@PostConstruct
			public void selectListCachedProductArrayList() {
				System.out.println("selectListCachedProductArrayList 함수 실행");
				List<ProductDto> productListFromDb = (ArrayList<ProductDto>) productDao.selectListCachedProductArrayList();
				ProductDto.cachedProductArrayList.clear();
				ProductDto.cachedProductArrayList.addAll(productListFromDb);
				System.out.println("cachedProductArrayList: " + ProductDto.cachedProductArrayList.size() + "chached!!");
			}

			public static void clear() {
				ProductDto.cachedProductArrayList.clear();
			}
			
			// codeGroup의 seq 번호를 받고 해당하는 code의 내용을 List로 출력
//			public static List<ProductDto> selectListCachedProduct(String B_codegroup_ifcgSeq){
//				List<CodeDto> rt = new ArrayList<CodeDto>();
//				for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
//					if (codeRow.getIfcgSeq().equals(B_codegroup_ifcgSeq)) {
//						rt.add(codeRow);
//					} else {
//						// by pass
//					}
//				}
//				return rt;
//			}
//		
//			// code의 정보를 받아서 문자열로 반환
//			public static String selectOneCachedCode(int code){
//				System.out.println("code: " + code);
//				String rt = "";
//				for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
//					if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
//						rt = codeRow.getIfcdName();
//					} else {
//						// by pass
//					}
//				}
//				return rt;
//			}



}
