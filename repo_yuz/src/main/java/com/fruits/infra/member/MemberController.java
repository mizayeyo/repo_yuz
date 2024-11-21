package com.fruits.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruits.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value="xdm/v1/infra/member/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo memberVo, Model model) {
		
		
		memberVo.setShDateStart(memberVo.getShDateStart() == null || memberVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(memberVo.getShDateStart()));
		memberVo.setShDateEnd(memberVo.getShDateEnd() == null || memberVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(memberVo.getShDateEnd()));
		
		
		// paging
				memberVo.setParamsPaging(memberService.selectOneCount(memberVo));
				
				if (memberVo.getTotalRows() > 0) {
					model.addAttribute("list", memberService.selectList(memberVo));
					model.addAttribute("vo", memberVo);
				}	
		
		return "xdm/v1/infra/member/memberXdmList";
	}
	
	@RequestMapping(value="xdm/v1/infra/member/memberXdmForm")
	public String memberXdmForm() {
		return "xdm/v1/infra/member/memberXdmForm";
	}
	
	
	
	
	//유저 메인 페이지
	@RequestMapping(value="/usr/v1/infra/member/memberUsrMain")
	public String memberUsrMain() {
		return "usr/v1/infra/member/memberUsrMain";
	}
	
	//유저 프로필
	@RequestMapping(value="usr/v1/infra/member/memberUsrProfile")
	public String memberUsrProfile() {
		return "usr/v1/infra/member/memberUsrProfile";
	}
	
	
	//INSERT
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		
		System.out.println(memberDto.getIfmmName());
		
		memberService.insert(memberDto);
		
		//==회원가입시 비밀번호 암호화==
//		memberDto.setIfmmPassword(encodeBcrypt(memberDto.getIfmmPassword(),10));
//		memberService.usrInsert(memberDto);
		return "redirect:/xdm/v1/infra/member/memberXdmList";
	}
	
	
	// Xdm Login
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmLogin")
	public String memberXdmLogin(MemberDto memberDto) {
		memberService.memberSelectOneLogin(memberDto);
		return "/xdm/v1/infra/member/memberXdmLogin";
	}
	
	
	// User Login
	@RequestMapping(value="/usr/v1/infra/member/memberUsrLogin")
	public String memberUsrLogin(MemberDto memberDto) {
		memberService.memberSelectOneLogin(memberDto);
		return "/usr/v1/infra/member/memberUsrLogin";
	}
	
	//관리자 메인(index)
	@RequestMapping(value="xdm/v1/infra/member/memberXdmIndex")
	public String memberXdmIndex() {
		return "xdm/v1/infra/member/memberXdmIndex";
	}
	
	//유저 회원가입
	@RequestMapping(value="usr/v1/infra/member/memberUsrRegist")
	public String memberUsrRegist() {
		return "usr/v1/infra/member/memberUsrRegist";
	}
	
	@RequestMapping(value="/usr/v1/infra/member/memberUsrInst")
	public String memberUsrInst(MemberDto memberDto) {
		memberDto.setIfmmPassword(encodeBcrypt(memberDto.getIfmmPassword(), 10));
		memberService.insert(memberDto);
	
		return "/usr/v1/infra/member/memberUsrLogin";
	}
	
	
	//관리자 로그인
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmLoginProc")
	public Map<String, Object> memberXdmLoginProc(MemberDto memberDto, HttpSession httpSession){
		
		Map<String, Object> returnMap = new HashMap<String, Object>(); //결과를 담기 위한 맵 생성
		
		MemberDto rtMember = memberService.memberSelectOneLogin(memberDto); //사용자 정보 조회
		
		if(rtMember !=null) { //객체를 대상으로 null을 검사
			
			MemberDto rtMember2 = memberService.memberSlectOneId(memberDto); //로그인 후 세션 정보 저장
			
			if(rtMember2 !=null) {
				//세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM);
				httpSession.setAttribute("sessSeqXdm", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getIfmmName());
			}
			returnMap.put("rt", "success"); //성공 응답 설정
			
				// 저장된 세션값 확인
				System.out.println("sessSeqXdm:" + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm:" + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm:" + httpSession.getAttribute("sessNameXdm"));
				
		} else {
			returnMap.put("rt", "fail"); //실패 응답 설정
		}
		
		return returnMap;
	}
	
	//유저 로그인
	@ResponseBody
	@RequestMapping(value="/usr/v1/infra/member/memberUsrLoginProc")
	public Map<String, Object> memberUsrLoginProc(MemberDto memberDto, HttpSession httpSession){
		
		Map<String, Object> returnMap = new HashMap<String, Object>(); //결과를 담기 위한 맵 생성
		
		MemberDto rtMember = memberService.memberSelectOneLogin(memberDto); //사용자 정보 조회
		
		if(rtMember !=null) { //객체를 대상으로 null을 검사
			
			if(matchesBcrypt(memberDto.getIfmmPassword(), rtMember.getIfmmPassword(), 10)) {
			
			MemberDto rtMember2 = memberService.memberSlectOneId(memberDto); //로그인 후 세션 정보 저장
			
			
			
			if(rtMember2 !=null) {
				//세션값 저장
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM);
				httpSession.setAttribute("sessSeqXdm", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getIfmmName());
			}
			returnMap.put("rt", "success"); //성공 응답 설정
			
				// 저장된 세션값 확인
				System.out.println("???????????????????:" + memberDto.getIfmmPassword());
				System.out.println("sessSeqXdm:" + httpSession.getAttribute("sessSeqXdm"));
				System.out.println("sessIdXdm:" + httpSession.getAttribute("sessIdXdm"));
				System.out.println("sessNameXdm:" + httpSession.getAttribute("sessNameXdm"));
				
		} else {
			returnMap.put("rt", "fail"); //실패 응답 설정
		}
		}
		return returnMap;
	}
	

	
	
	// LogoutProc
	
		@ResponseBody
		@RequestMapping(value="/xdm/v1/infra/member/memberXdmLogoutProc")
		public Map<String, Object> signoutXdmProc(HttpSession httpSession) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			httpSession.invalidate();
			returnMap.put("rt", "success");
			return returnMap;
		}


	
	 //UPDATE 축약형
    @RequestMapping(value="/xdm/v1/infra/member/memberXdmMfom")
    public String memberXdmMfom(MemberDto memberDto,Model model) {
  	  model.addAttribute("item", memberService.selectOne(memberDto));
  	  System.out.println("selectOne 잘 넘어감");
  	  return "/xdm/v1/infra/member/memberXdmMfom";
    }
    
    //UPDATE
    @RequestMapping(value="/xdm/v1/infra/member/memberXdmUpdt")
    public String memberXdmUpdt(MemberDto memberDto) {
  	  memberService.update(memberDto);
  	  System.out.println("update 실행했다~!");
  	  return "redirect:/xdm/v1/infra/member/memberXdmList";
    }
    
    //UELETE
    @RequestMapping(value="/xdm/v1/infra/member/memberXdmUelete")
    public String memberXdmUelete(MemberDto memberDto) {
        memberService.uelete(memberDto);
        return "redirect:/xdm/v1/infra/member/memberXdmList";
    }

    
    //DELETE
    @RequestMapping(value="/xdm/v1/infra/member/memberXdmDelete")
    public String memberXdmDelete(MemberDto memberDto) {
  	  memberService.delete(memberDto);
  	  return "redirect:/xdm/v1/infra/member/memberXdmList";
    }
    
 // ===== 암호화 ===== //
 	// encodeBcrypt
 	public String encodeBcrypt(String planeText, int strength) {
 		return new BCryptPasswordEncoder(strength).encode(planeText);
 	}
 	
 	// matchesBcrypt
 	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
 		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
 		return passwordEncoder.matches(planeText, hashValue);
 	}


}
