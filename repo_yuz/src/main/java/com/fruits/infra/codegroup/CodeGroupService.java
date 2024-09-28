package com.fruits.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
//	CodeGroupDao codeGroupDao = new CodeGroupDao();
//	CodeGroupDao dao;
	
	@Autowired
	private CodeGroupDao codeGroupDao;
	
//	public List<CodeGroupDto> selectList(){
//		List<CodeGroupDto> codeGroups = codeGroupDao.selectList();
//		return codeGroups;
//	}
	
	//함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo){
		return codeGroupDao.selectList(codeGroupVo);
	}
	
	//insert
//	public int insert(CodeGroupDto codeGroupDto) {
//		int result = codeGroupDao.insert(codeGroupDto);
//		return result;
//	}

	// 함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
	//update - selectOne
//	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
//		CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto);
//		return dto;
//	}
	
	//축약형
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto);
	}
	
	//update - update
//	public int update(CodeGroupDto codeGroupDto) {
//		int a = codeGroupDao.update(codeGroupDto);
//		return a;
//	}

	//축약형
	public int update(CodeGroupDto codeGroupDto) {
		System.out.println(codeGroupDto.getIfcgSeq());
		return codeGroupDao.update(codeGroupDto);
	}
	
	//uelete
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}                                                                                                                                                                                   
	
	//delete
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	
	
	// paging
	public int selectOneCount(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectOneCount(codeGroupVo);
	}
	

}	



	
