package com.fruits.infra.code;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CodeDto {
	
	private String ifcdSeq;
	private String ifcdName;
	private Integer ifcdUseNy;
	private Integer ifcdOrder;
	private String ifcdDesc;
	private Integer ifcdDelNy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcdRegist;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date ifcdEdit;
	private String codegroup_ifcgSeq;
	//codegroup에서 가져올 데이터 추가 &getter/setter 다시 하기

	private String ifcgSeq;
	private String ifcgName;
	
	//count추가
	private Integer xifcdSeqCount;
	
	
	//------getter / setter --------

	public String getIfcdSeq() {
		return ifcdSeq;
	}

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public String getIfcdName() {
		return ifcdName;
	}

	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}

	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}

	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}

	public Integer getIfcdOrder() {
		return ifcdOrder;
	}

	public void setIfcdOrder(Integer ifcdOrder) {
		this.ifcdOrder = ifcdOrder;
	}

	public String getIfcdDesc() {
		return ifcdDesc;
	}

	public void setIfcdDesc(String ifcdDesc) {
		this.ifcdDesc = ifcdDesc;
	}

	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}

	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}

	public Date getIfcdRegist() {
		return ifcdRegist;
	}

	public void setIfcdRegist(Date ifcdRegist) {
		this.ifcdRegist = ifcdRegist;
	}

	public Date getIfcdEdit() {
		return ifcdEdit;
	}

	public void setIfcdEdit(Date ifcdEdit) {
		this.ifcdEdit = ifcdEdit;
	}

	public String getCodegroup_ifcgSeq() {
		return codegroup_ifcgSeq;
	}

	public void setCodegroup_ifcgSeq(String codegroup_ifcgSeq) {
		this.codegroup_ifcgSeq = codegroup_ifcgSeq;
	}

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public String getIfcgName() {
		return ifcgName;
	}

	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}

	public Integer getXifcdSeqCount() {
		return xifcdSeqCount;
	}

	public void setXifcdSeqCount(Integer xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	
	
	
	
	

	
	
	
	
}
