package com.fruits.infra.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	List<MemberDto> selectList();
	
	

}
