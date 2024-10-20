package com.fruits.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;




@Repository
public interface MemberDao {
	
	// 추상메서드
	// select
	public List<MemberDto> selectList(MemberVo MemberVo);
	
	//insert
	//int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
	public int insert(MemberDto MemberDto);
	
	// update - selectOne
	public MemberDto selectOne(MemberDto MemberDto);
	
	//update - update
	//int인 이유 : 데이터가 몇 건이 처리됐는지 확인하기 위해서
	public int update(MemberDto MemberDto);
	
	//uelete
	public int uelete(MemberDto MemberDto);
	
	//delete
	public int delete(MemberDto MemberDto);
	
	// paging
	public int selectOneCount(MemberVo MemberVo);

	
	// for cache
	public List<MemberDto> selectListCachedMemberArrayList();
	

}
