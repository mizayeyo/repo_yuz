package com.fruits.infra.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductDto {
	
	private String ifpdSeq;
	private String ifpdName;
	private String ifpdDesc;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date ifpdUpdate;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date ifpdReg;
	private Integer ifpdUseNy;
	private Integer ifpdDelNy;
	private Integer member_ifmmSeq;
	
	
	private Integer xifpdSeqCount;
	
	//cache
	public static List<ProductDto> cachedProductArrayList = new ArrayList<ProductDto>();

	public String getIfpdSeq() {
		return ifpdSeq;
	}

	public String getIfpdName() {
		return ifpdName;
	}

	public String getIfpdDesc() {
		return ifpdDesc;
	}

	public Date getIfpdUpdate() {
		return ifpdUpdate;
	}

	public Date getIfpdReg() {
		return ifpdReg;
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

	public void setIfpdUpdate(Date ifpdUpdate) {
		this.ifpdUpdate = ifpdUpdate;
	}

	public void setIfpdReg(Date ifpdReg) {
		this.ifpdReg = ifpdReg;
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

	public void setXifpdSeqCount(Integer xifpdSeqCount) {
		this.xifpdSeqCount = xifpdSeqCount;
	}

	public static void setCachedProductArrayList(List<ProductDto> cachedProductArrayList) {
		ProductDto.cachedProductArrayList = cachedProductArrayList;
	}


	
}
