package com.fruits.infra.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
    // usrInsert 메서드 정의
    public int usrInsert(MemberDto memberDto) {
        // BCryptPasswordEncoder 객체 생성
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // 입력된 비밀번호 확인
        System.out.println("Original Password: " + memberDto.getIfmmPassword());

        // 비밀번호를 암호화하여 memberDto 객체에 설정
        String encodedPassword = encoder.encode(memberDto.getIfmmPassword());
        
        System.out.println("Encoded Password: " + encodedPassword);
        
        memberDto.setIfmmPassword(encodedPassword);

        // 암호화된 비밀번호를 포함하여 회원 정보를 저장
        return memberDao.insert(memberDto);
    }
	
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
		
		
		//Login
		public MemberDto memberSelectOneLogin(MemberDto memberDto) {
			return memberDao.memberSelectOneLogin(memberDto);
		}
		
		
		public MemberDto memberSlectOneId(MemberDto memberDto) {
			return memberDao.memberSelectOneId(memberDto);
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
