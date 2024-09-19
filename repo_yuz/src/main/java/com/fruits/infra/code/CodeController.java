package com.fruits.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	//selectList
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(Model model){
		model.addAttribute("list",codeService.selectList());
		return "/xdm/v1/infra/code/codeXdmList";
		
		
//		for(CodeDto codedto : codeDto) {
//			System.out.print(codedto.getIfcdSeq() + " | ");
//			System.out.print(codedto.getIfcdName() + " | ");
//			System.out.print(codedto.getIfcdUseNy() + " | ");
//			System.out.print(codedto.getIfcdOrder() + " | ");
//			System.out.print(codedto.getIfcdDesc() + " | ");
//			System.out.print(codedto.getIfcdDelNy() + " | ");
//			System.out.print(codedto.getIfcdRegist() + " | ");
//			System.out.print(codedto.getIfcdEdit() + " | ");
//			System.out.println(codedto.getCodegroupIfcgSeq() + " | ");
//		}	
//		return "/xdm/v1/infra/code/codeXdmList";	
//			
		}
	
	// Form
	// code-codegroup 연결
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model) {
		
		//코드그룹 정보를 불러와야함
		List<CodeDto> codeGroups = codeService.selectListCodeGroup();
		
		//불러온 코드그룹 정보를 codeXdmForm에 전달해주어야함
		model.addAttribute("listCodeGroup", codeService.selectListCodeGroup());
		return "/xdm/v1/infra/code/codeXdmForm";
	}
	
	//Inst
	@RequestMapping(value="/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}
	
	//Mfom -selectOne
		@RequestMapping(value="/xdm/v1/infra/code/codeXdmMfom")
		public String codeXdmMfom(CodeDto codeDto, Model model) {
			
			//코드의 정보를 codeXdmForm.html에 전달함
			model.addAttribute("item", codeService.selectOne(codeDto));
			
			//코드그룹 정보를 불러와야함
			List<CodeDto> codeGroups = codeService.selectListCodeGroup();
			
			//불러온 코드그룹 정보를 codeXdmForm.html에 전달함
             model.addAttribute("listCodeGroup", codeService.selectListCodeGroup()); 			
		return "/xdm/v1/infra/code/codeXdmMfom";
		}
		
		//Updt - update
		@RequestMapping(value="xdm/v1/infra/code/codeXdmUpdt")
		public String codeXdmUpdt(CodeDto codeDto) {
			codeService.update(codeDto);
				return "redirect:/xdm/v1/infra/code/codeXdmList";
			}
		
		//uel-uelete
		@RequestMapping(value="/xdm/v1/infra/code/codeXdmUelete")
		public String codeXdmUelete(CodeDto codeDto) {
			codeService.uelete(codeDto);
			return "redirect:/xdm/v1/infra/code/codeXdmList";
		}
		
		//delete
		@RequestMapping(value="/xdm/v1/infra/code/codeXdmDelete")
		public String codeXdmDelete(CodeDto codeDto) {
			codeService.delete(codeDto);
			return "redirect:/xdm/v1/infra/code/codeXdmList";
		}
		
}


