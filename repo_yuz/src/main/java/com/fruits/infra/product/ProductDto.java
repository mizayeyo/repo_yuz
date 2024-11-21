package com.fruits.infra.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductDto {
	
	private String ifpdSeq;
	private String ifpdName;
	private String ifpdDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifpdReg;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifpdUpdate;
	private Integer ifpdUseNy;
	private Integer ifpdDelNy;
	private Integer member_ifmmSeq;
	private Integer ifpdPrice;
	private Integer ifpdQt;
	private Integer ifpdCart;
	private String ifpdWish;
	
	
	private Integer xifpdSeqCount;
	
	
	



	public String getIfpdSeq() {
		return ifpdSeq;
	}


	public String getIfpdName() {
		return ifpdName;
	}


	public String getIfpdDesc() {
		return ifpdDesc;
	}


	public Date getIfpdReg() {
		return ifpdReg;
	}


	public Date getIfpdUpdate() {
		return ifpdUpdate;
	}


	public Integer getIfpdUseNy() {
		return ifpdUseNy;
	}


	public Integer getIfpdDelNy() {
		return ifpdDelNy;
	}


	public Integer getMember_ifmmSeq() {
		return member_ifmmSeq;
	}


	public Integer getIfpdPrice() {
		return ifpdPrice;
	}


	public Integer getIfpdQt() {
		return ifpdQt;
	}


	public Integer getIfpdCart() {
		return ifpdCart;
	}


	public String getIfpdWish() {
		return ifpdWish;
	}


	public Integer getXifpdSeqCount() {
		return xifpdSeqCount;
	}


	public static List<ProductDto> getCachedProductArrayList() {
		return cachedProductArrayList;
	}


	public void setIfpdSeq(String ifpdSeq) {
		this.ifpdSeq = ifpdSeq;
	}


	public void setIfpdName(String ifpdName) {
		this.ifpdName = ifpdName;
	}


	public void setIfpdDesc(String ifpdDesc) {
		this.ifpdDesc = ifpdDesc;
	}


	public void setIfpdReg(Date ifpdReg) {
		this.ifpdReg = ifpdReg;
	}


	public void setIfpdUpdate(Date ifpdUpdate) {
		this.ifpdUpdate = ifpdUpdate;
	}


	public void setIfpdUseNy(Integer ifpdUseNy) {
		this.ifpdUseNy = ifpdUseNy;
	}


	public void setIfpdDelNy(Integer ifpdDelNy) {
		this.ifpdDelNy = ifpdDelNy;
	}


	public void setMember_ifmmSeq(Integer member_ifmmSeq) {
		this.member_ifmmSeq = member_ifmmSeq;
	}


	public void setIfpdPrice(Integer ifpdPrice) {
		this.ifpdPrice = ifpdPrice;
	}


	public void setIfpdQt(Integer ifpdQt) {
		this.ifpdQt = ifpdQt;
	}


	public void setIfpdCart(Integer ifpdCart) {
		this.ifpdCart = ifpdCart;
	}


	public void setIfpdWish(String ifpdWish) {
		this.ifpdWish = ifpdWish;
	}


	public void setXifpdSeqCount(Integer xifpdSeqCount) {
		this.xifpdSeqCount = xifpdSeqCount;
	}


	//cache
	public static List<ProductDto> cachedProductArrayList = new ArrayList<ProductDto>();


	public static void setCachedProductArrayList(List<ProductDto> cachedProductArrayList) {
		ProductDto.cachedProductArrayList = cachedProductArrayList;
	}


	
}
