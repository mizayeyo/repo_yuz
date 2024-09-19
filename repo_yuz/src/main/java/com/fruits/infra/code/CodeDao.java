package com.fruits.infra.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	//추상메소드
	//selectList
	public List<CodeDto> selectList();
	
	//selectListCodeGroup
	public List<CodeDto> selectListCodeGroup();
	
	//insert
	public int insert(CodeDto codeDto);
	
	//selectOne
	public CodeDto selectOne(CodeDto codeDto);
	
	//update
	public int update(CodeDto codeDto);
	
	//uelete
	public int uelete(CodeDto codeDto);
	
	//delete
	public int delete(CodeDto codeDto);
	

}
