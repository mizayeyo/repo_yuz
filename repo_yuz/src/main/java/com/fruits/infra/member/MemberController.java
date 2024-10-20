package com.fruits.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruits.common.util.UtilDateTime;

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
	
	
	@RequestMapping(value="/xdm/v1/infra/member/memberXdmInst")
	public String memberXdmInst(MemberDto memberDto) {
		
		System.out.println(memberDto.getIfmmName());
		
		memberService.insert(memberDto);
		
		return "redirect:/xdm/v1/infra/member/memberXdmList";
	}
	
	 //UPDATE 축약형
    @RequestMapping(value="/xdm/v1/infra/member/memberXdmMfom")
    public String memberxdmMfom(MemberDto memberDto,Model model) {
  	  model.addAttribute("item", memberService.selectOne(memberDto));
  	  System.out.println("selectOne 잘 넘어감");
  	  return "/xdm/v1/infra/member/codememberXdmMfom";
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
    public String memberXdmUdelete(MemberDto memberDto) {
        memberService.uelete(memberDto);
        return "redirect:/xdm/v1/infra/member/memberXdmList";
    }

    
    //DELETE
    @RequestMapping(value="/xdm/v1/infra/codemember/memberXdmDelete")
    public String memberXdmDelete(MemberDto memberDto) {
  	  memberService.delete(memberDto);
  	  return "redirect:/xdm/v1/infra/member/memberXdmList";
    }
    
    

}
