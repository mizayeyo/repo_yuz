package com.fruits.infra.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
//	public List<MemberDto> selectList(){
//		List<MemberDto> members = MemberDao.selectList();
//		return members;
//		
//	}


	
	
	//함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
		public List<MemberDto> selectList(MemberVo memberVo){
			return memberDao.selectList(memberVo);
		}
		
	

		// 함수 안에 내용이 없을 경우 아래와 같이 줄여서 쓴다.
		public int insert(MemberDto memberDto) {
			return memberDao.insert(memberDto);
		}
		

		
		//축약형
		public MemberDto selectOne(MemberDto memberDto) {
			return memberDao.selectOne(memberDto);
		}
		

		//축약형
		public int update(MemberDto memberDto) {
			System.out.println(memberDto.getIfmmSeq());
			return memberDao.update(memberDto);
		}
		
		//uelete
		public int uelete(MemberDto memberDto) {
			return memberDao.uelete(memberDto);
		}                                                                                                                                                                                   
		
		//delete
		public int delete(MemberDto memberDto) {
			return memberDao.delete(memberDto);
		}
		
		
		// paging
		public int selectOneCount(MemberVo memberVo) {
			return memberDao.selectOneCount(memberVo);
		}
		
		// for cache
			@PostConstruct
			public void selectListCachedMemberArrayList() {
				System.out.println("selectListCachedMemberArrayList 함수 실행");
				List<MemberDto> memberListFromDb = (ArrayList<MemberDto>) memberDao.selectListCachedMemberArrayList();
				MemberDto.cachedMemberArrayList.clear();
				MemberDto.cachedMemberArrayList.addAll(memberListFromDb);
				System.out.println("cachedMemberArrayList: " + MemberDto.cachedMemberArrayList.size() + "chached!!");
			}
		
			//캐싱 삭제	
			public static void clear() {
			MemberDto.cachedMemberArrayList.clear();
		}
		
			
			// code의 정보를 받아서 문자열로 반환
			public static String selectOneCachedMember(int member){
				System.out.println("member: " + member);
				String rt = "";
				for(MemberDto memberRow : MemberDto.cachedMemberArrayList) {
					if (memberRow.getIfmmSeq().equals(Integer.toString(member))) {
						rt = memberRow.getIfmmName();
					} else {
						// by pass
					}
				}
				return rt;
			}
			
			
}
