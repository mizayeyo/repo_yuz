package com.fruits.infra.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDto {
	
	private String ifmmSeq;
	private String ifmmName;
	private String ifmmId;
	private String ifmmPassword;
	private String ifmmPassword2;
	private String ifmmNickName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ifmmBirthday;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date ifmmRegistDate;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date ifmmDeleteDate;
	private Integer ifmmDelNy;
	private String ifmmEmail;
	private Integer ifmmGender;
	private String ifmmAddress1;
	private String ifmmAddress2;
	private Integer ifmmPostCode;
	private String ifmmTel;
	private String ifmmMemo;
	private String codegroup_ifcgSeq;
	
	private Integer xifmmSeqCount;
	
	private String xdmId;
	private String xdmPw;
	private String ifmmTelCom;
	
	
//cache
	public static List<MemberDto> cachedMemberArrayList = new ArrayList<MemberDto>();

	public static void setCachedMemberArrayList(List<MemberDto> cachedMemberArrayList) {
		MemberDto.cachedMemberArrayList = cachedMemberArrayList;
	}

	public String getIfmmSeq() {
		return ifmmSeq;
	}

	public String getIfmmName() {
		return ifmmName;
	}

	public String getIfmmId() {
		return ifmmId;
	}

	public String getIfmmPassword() {
		return ifmmPassword;
	}

	public String getIfmmPassword2() {
		return ifmmPassword2;
	}

	public String getIfmmNickName() {
		return ifmmNickName;
	}

	public Date getIfmmBirthday() {
		return ifmmBirthday;
	}

	public Date getIfmmRegistDate() {
		return ifmmRegistDate;
	}

	public Date getIfmmDeleteDate() {
		return ifmmDeleteDate;
	}

	public Integer getIfmmDelNy() {
		return ifmmDelNy;
	}

	public String getIfmmEmail() {
		return ifmmEmail;
	}

	public Integer getIfmmGender() {
		return ifmmGender;
	}

	public String getIfmmAddress1() {
		return ifmmAddress1;
	}

	public String getIfmmAddress2() {
		return ifmmAddress2;
	}

	public Integer getIfmmPostCode() {
		return ifmmPostCode;
	}

	public String getIfmmTel() {
		return ifmmTel;
	}

	public String getIfmmMemo() {
		return ifmmMemo;
	}

	public String getCodegroup_ifcgSeq() {
		return codegroup_ifcgSeq;
	}

	public Integer getXifmmSeqCount() {
		return xifmmSeqCount;
	}

	public String getXdmId() {
		return xdmId;
	}

	public String getXdmPw() {
		return xdmPw;
	}

	public String getIfmmTelCom() {
		return ifmmTelCom;
	}

	public static List<MemberDto> getCachedMemberArrayList() {
		return cachedMemberArrayList;
	}

	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}

	public void setIfmmName(String ifmmName) {
		this.ifmmName = ifmmName;
	}

	public void setIfmmId(String ifmmId) {
		this.ifmmId = ifmmId;
	}

	public void setIfmmPassword(String ifmmPassword) {
		this.ifmmPassword = ifmmPassword;
	}

	public void setIfmmPassword2(String ifmmPassword2) {
		this.ifmmPassword2 = ifmmPassword2;
	}

	public void setIfmmNickName(String ifmmNickName) {
		this.ifmmNickName = ifmmNickName;
	}

	public void setIfmmBirthday(Date ifmmBirthday) {
		this.ifmmBirthday = ifmmBirthday;
	}

	public void setIfmmRegistDate(Date ifmmRegistDate) {
		this.ifmmRegistDate = ifmmRegistDate;
	}

	public void setIfmmDeleteDate(Date ifmmDeleteDate) {
		this.ifmmDeleteDate = ifmmDeleteDate;
	}

	public void setIfmmDelNy(Integer ifmmDelNy) {
		this.ifmmDelNy = ifmmDelNy;
	}

	public void setIfmmEmail(String ifmmEmail) {
		this.ifmmEmail = ifmmEmail;
	}

	public void setIfmmGender(Integer ifmmGender) {
		this.ifmmGender = ifmmGender;
	}

	public void setIfmmAddress1(String ifmmAddress1) {
		this.ifmmAddress1 = ifmmAddress1;
	}

	public void setIfmmAddress2(String ifmmAddress2) {
		this.ifmmAddress2 = ifmmAddress2;
	}

	public void setIfmmPostCode(Integer ifmmPostCode) {
		this.ifmmPostCode = ifmmPostCode;
	}

	public void setIfmmTel(String ifmmTel) {
		this.ifmmTel = ifmmTel;
	}

	public void setIfmmMemo(String ifmmMemo) {
		this.ifmmMemo = ifmmMemo;
	}

	public void setCodegroup_ifcgSeq(String codegroup_ifcgSeq) {
		this.codegroup_ifcgSeq = codegroup_ifcgSeq;
	}

	public void setXifmmSeqCount(Integer xifmmSeqCount) {
		this.xifmmSeqCount = xifmmSeqCount;
	}

	public void setXdmId(String xdmId) {
		this.xdmId = xdmId;
	}

	public void setXdmPw(String xdmPw) {
		this.xdmPw = xdmPw;
	}

	public void setIfmmTelCom(String ifmmTelCom) {
		this.ifmmTelCom = ifmmTelCom;
	}

	

	
	
	

	

}
