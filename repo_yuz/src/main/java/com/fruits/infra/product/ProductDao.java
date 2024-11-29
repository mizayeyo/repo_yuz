package com.fruits.infra.product;

import java.util.List;

import org.springframework.stereotype.Repository;




@Repository
public interface ProductDao {
	

	
	
	// 추상메서드
		// select
		public List<ProductDto> selectList(ProductVo ProductVo);
		
		//insert
		//int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
		public int insert(ProductDto ProductDto);
		
		// update - selectOne
		public ProductDto selectOne(ProductDto ProductDto);
		
		//update - update
		//int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
		public int update(ProductDto ProductDto);
		
		//uelete
		public int uelete(ProductDto ProductDto);
		
		//delete
		public int delete(ProductDto ProductDto);
		
		// paging
		public int selectOneCount(ProductVo ProductVo);
		
		//Log in 
	//	public ProductDto memberSelectOneLogin(ProductDto productDto);

		
		// for cache
		public List<ProductDto> selectListCachedProductArrayList();
		

}
