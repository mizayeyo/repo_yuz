package com.fruits.infra.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruits.common.util.UtilDateTime;

@Controller
public class ProductController {
	
	
	@Autowired
	public ProductService productService;
	
	
	//어드민 프로덕트 List
	@RequestMapping(value="/xdm/v1/infra/product/productXdmList")
	public String productXdmList(@ModelAttribute("vo") ProductVo productVo, Model model) {
		
		
		productVo.setShDateStart(productVo.getShDateStart() == null || productVo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(productVo.getShDateStart()));
		productVo.setShDateEnd(productVo.getShDateEnd() == null || productVo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(productVo.getShDateEnd()));
		
		
		// paging
				productVo.setParamsPaging(productService.selectOneCount(productVo));
				
				if (productVo.getTotalRows() > 0) {
					model.addAttribute("list", productService.selectList(productVo));
					model.addAttribute("vo", productVo);
				}	
		
		return "/xdm/v1/infra/product/productXdmList";
	}
	
	//INSERT
	@RequestMapping(value="/xdm/v1/infra/product/productXdmInst")
	public String productXdmInst(ProductDto productDto) {
		
		System.out.println(productDto.getIfpdName());
		
		productService.insert(productDto);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		//==회원가입시 비밀번호 암호화==
//		memberDto.setIfmmPassword(encodeBcrypt(memberDto.getIfmmPassword(),10));
//		memberService.usrInsert(memberDto);
		return "redirect:/xdm/v1/infra/product/productXdmList";
	}
	
	//어드민 프로덕트 Form
	@RequestMapping(value="xdm/v1/infra/product/productXdmForm")
	public String productXdmForm() {
		return "xdm/v1/infra/product/productXdmForm";
	}
	
	
	//유저 프로덕트 List
	@RequestMapping(value="usr/v1/infra/product/productUsrList")
	public String productUsrList() {
		return "usr/v1/infra/product/productUsrList";
	}
	
	//유저 프로덕트 Detail
	@RequestMapping(value="usr/v1/infra/product/productUsrDetail")
	public String productUsrDetail() {
		return "usr/v1/infra/product/productUsrDetail";
	}
	
	
	

	
	 //UPDATE 축약형
    @RequestMapping(value="/xdm/v1/infra/product/productXdmMfom")
    public String productXdmMfom(ProductDto productDto,Model model) {
  	  model.addAttribute("item", productService.selectOne(productDto));
  	  System.out.println("selectOne 잘 넘어감");
  	  return "/xdm/v1/infra/product/productXdmMfom";
    }
    
    //UPDATE
    @RequestMapping(value="/xdm/v1/infra/product/productXdmUpdt")
    public String productXdmUpdt(ProductDto productDto) {
    	productService.update(productDto);
  	  System.out.println("ifpdSeq = " + productDto.getIfpdSeq());
  	  return "redirect:/xdm/v1/infra/product/productXdmList";
    }
    
    //UELETE
    @RequestMapping(value="/xdm/v1/infra/product/productXdmUelete")
    public String productXdmUelete(ProductDto productDto) {
    	productService.uelete(productDto);
        return "redirect:/xdm/v1/infra/product/productXdmList";
    }

    
    //DELETE
    @RequestMapping(value="/xdm/v1/infra/product/productXdmDelete")
    public String productXdmDelete(ProductDto productDto) {
    	productService.delete(productDto);
  	  return "redirect:/xdm/v1/infra/product/productXdmList";
    }
    
    


}
