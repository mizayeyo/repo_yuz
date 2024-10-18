package com.fruits.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping(value="xdm/v1/infra/member/memberXdmList")
	public String memberXdmList() {
		
		List<MemberDto> members = memberService.selectList();
		
		return "xdm/v1/infra/member/memberXdmList";
	}

}
