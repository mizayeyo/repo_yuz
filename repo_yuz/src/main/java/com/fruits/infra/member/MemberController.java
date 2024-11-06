package com.fruits.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/usr/v1/infra/member/memberXdmLogin")
	public String memberXdmLogin() {
		return "usr/v1/infra/member/memberXdmLogin";
	}
	
	
	
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		
		System.out.println(memberDto.getIfmmName());
		
		memberService.insert(memberDto);
		
		return "redirect:/xdm/v1/infra/member/memberXdmList";
	}
	
	
	//Login
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmLogin")
	public String memberXdmLogin(MemberDto memberDto) {
		memberService.memberSelectOneLogin(memberDto);
		return "/xdm/v1/infra/member/memberXdmLogin";
	}
	
	@RequestMapping(value="xdm/v1/infra/member/memberXdmIndex")
	public String memberXdmIndex() {
		return "xdm/v1/infra/member/memberXdmIndex";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmLoginProc")
	public Map<String, Object> memberXdmLoginProc(MemberDto memberDto){
		
		Map<String, Object> returnMap = new HashMap<String, Object>(); //결과를 담기 위한 맵 생성
		
		MemberDto rtMember = memberService.memberSelectOneLogin(memberDto); //사용자 정보 조회
		
		if(rtMember !=null) {
			returnMap.put("rt", "success"); //성공 응답 설정
		} else {
			returnMap.put("rt", "fail"); //실패 응답 설정
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
    
    

}
