package com.fruits.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruits.common.util.UtilDateTime;

@Controller
public class CodeGroupController {

//	@Autowired
//	CodeGroupService codegroupService = new CodeGroupService();
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo codeGroupVo, Model model) {
		
		//날짜 필드에 시간 추가
//		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart()+" 00:00:00");
//		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd()+" 23:59:59");
		
		// 초기값 세팅이 없는 경우 사용
		codeGroupVo.setShDateStart(codeGroupVo.getShDateStart() == null || codeGroupVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(codeGroupVo.getShDateStart()));
		codeGroupVo.setShDateEnd(codeGroupVo.getShDateEnd() == null || codeGroupVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(codeGroupVo.getShDateEnd()));
	
		
		
		
		// paging
		codeGroupVo.setParamsPaging(codeGroupService.selectOneCount(codeGroupVo));
		
		if (codeGroupVo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(codeGroupVo));
			model.addAttribute("vo", codeGroupVo);
		}	

				
		return "/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "/xdm/v1/infra/codegroup/codeGroupXdmForm";
	}
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
		System.out.println(codeGroupDto.getIfcgName());
		
		codeGroupService.insert(codeGroupDto);
		
		return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
	}
	
	//UPDATE
//    @RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMfom")
//    public String codeGroupXdmMfom() {
//    	return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
//    }
    
    //UPDATE
//    @RequestMapping(value="/xdm/v1/codegroup/codeGroupXdmMfom")
//    public String codeGroupXdmMfom(CodeGroupDto codeGroupDto, Model model) {
//    	CodeGroupDto dto = codeGroupService.selectOne(codeGroupDto);
//    	model.addAttribute("item", dto); //"html에서 쓸 변수명"
//    	return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
//    }
    
    //UPDATE 축약형
      @RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmMfom")
      public String codeGroupxdmMfom(CodeGroupDto codeGroupDto,Model model) {
    	  model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
    	  System.out.println("selectOne 잘 넘어감");
    	  return "/xdm/v1/infra/codegroup/codeGroupXdmMfom";
      }
      
      //UPDATE
      @RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmUpdt")
      public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
    	  codeGroupService.update(codeGroupDto);
    	  System.out.println("update 실행했다~!");
    	  return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
      }
      
      //UELETE
      @RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmUelete")
      public String codeGroupXdmUdelete(CodeGroupDto codeGroupDto) {
          codeGroupService.uelete(codeGroupDto);
          return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
      }

      
      //DELETE
      @RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmDelete")
      public String codeGroupXdmDelete(CodeGroupDto codeGroupDto) {
    	  codeGroupService.delete(codeGroupDto);
    	  return "redirect:/xdm/v1/infra/codegroup/codeGroupXdmList";
      }
      
      

}
