package com.fruits.infra.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruits.common.util.UtilDateTime;

@Controller
public class ProductController {
	
	
	@Autowired
	public ProductService productService;
	
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
	
	@RequestMapping(value="xdm/v1/infra/product/productXdmForm")
	public String productXdmForm() {
		return "xdm/v1/infra/product/productXdmForm";
	}
	
	
	@RequestMapping(value="/xdm/v1/infra/product/productXdmInst")
	public String productXdmInst(ProductDto productDto) {
		
		System.out.println(productDto.getIfpdName());
		
		productService.insert(productDto);
		
		return "redirect:/xdm/v1/infra/product/productXdmList";
	}
	
	
	//Login
//	@RequestMapping(value="/xdm/v1/infra/product/productXdmLogin")
//	public String productXdmLogin(ProductDto productDto) {
//		productService.productSelectOneLogin(productDto);
//		return "/xdm/v1/infra/product/productXdmLogin";
//	}
	
	@RequestMapping(value="xdm/v1/infra/product/productXdmIndex")
	public String productXdmIndex() {
		return "xdm/v1/infra/product/productXdmIndex";
	}
	
	
	
//	@ResponseBody
//	@RequestMapping(value="/xdm/v1/infra/product/productXdmLoginProc")
//	public Map<String, Object> productXdmLoginProc(ProductDto productDto){
//		
//		Map<String, Object> returnMap = new HashMap<String, Object>(); //결과를 담기 위한 맵 생성
//		
//		ProductDto rtMember = productService.productSelectOneLogin(productDto); //사용자 정보 조회
//		
//		if(rtMember !=null) {
//			returnMap.put("rt", "success"); //성공 응답 설정
//		} else {
//			returnMap.put("rt", "fail"); //실패 응답 설정
//		}
//		
//		return returnMap;
//	}
	
	
	
	
	
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
  	  System.out.println("update 실행했다~!");
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
