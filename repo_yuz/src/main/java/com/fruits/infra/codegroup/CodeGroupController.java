package com.fruits.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {

//	@Autowired
//	CodeGroupService codegroupService = new CodeGroupService();
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/xdm/v1/infra/codegroup/codeGroupXdmList")
	public String codeGroupXdmList(CodeGroupVo codeGroupVo, Model model) {
		
		model.addAttribute("list",codeGroupService.selectList(codeGroupVo));
		//""안에 html에 넘겨줄 이름 = 변수명
		
//		System.out.println("codeGroups.size() : " + codeGroups.size());
				
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
