package com.fruits.infra.member;

import com.fruits.infra.codegroup.Constants;

public class MemberVo {
	
	//search
	private Integer shDelNy;
	private Integer shUseNy;
	private Integer shOption;
	private String shValue;
	private Integer shOptionDate;
	private String shDateStart;
	private String shDateEnd;
	
	
	private int thisPage = 1; 
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;     //한화면에 보여줄 리스트갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;
	private int totalRows;
	private int totalPages;
	private int startPage;
	private int endPage;
	private int startRnumForMysql; //페이징리스트시작넘버
	
	
public void setParamsPaging(int totalRows) {
		
//		setThisPage(3);

		setTotalRows(totalRows);

		if (getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}

		if (getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}

		if (getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
	

	

}


public Integer getShDelNy() {
	return shDelNy;
}


public Integer getShUseNy() {
	return shUseNy;
}


public Integer getShOption() {
	return shOption;
}


public String getShValue() {
	return shValue;
}


public Integer getShOptionDate() {
	return shOptionDate;
}


public String getShDateStart() {
	return shDateStart;
}


public String getShDateEnd() {
	return shDateEnd;
}


public int getThisPage() {
	return thisPage;
}


public int getRowNumToShow() {
	return rowNumToShow;
}


public int getPageNumToShow() {
	return pageNumToShow;
}


public int getTotalRows() {
	return totalRows;
}


public int getTotalPages() {
	return totalPages;
}


public int getStartPage() {
	return startPage;
}


public int getEndPage() {
	return endPage;
}


public int getStartRnumForMysql() {
	return startRnumForMysql;
}


public void setShDelNy(Integer shDelNy) {
	this.shDelNy = shDelNy;
}


public void setShUseNy(Integer shUseNy) {
	this.shUseNy = shUseNy;
}


public void setShOption(Integer shOption) {
	this.shOption = shOption;
}


public void setShValue(String shValue) {
	this.shValue = shValue;
}


public void setShOptionDate(Integer shOptionDate) {
	this.shOptionDate = shOptionDate;
}


public void setShDateStart(String shDateStart) {
	this.shDateStart = shDateStart;
}


public void setShDateEnd(String shDateEnd) {
	this.shDateEnd = shDateEnd;
}


public void setThisPage(int thisPage) {
	this.thisPage = thisPage;
}


public void setRowNumToShow(int rowNumToShow) {
	this.rowNumToShow = rowNumToShow;
}


public void setPageNumToShow(int pageNumToShow) {
	this.pageNumToShow = pageNumToShow;
}


public void setTotalRows(int totalRows) {
	this.totalRows = totalRows;
}


public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}


public void setStartPage(int startPage) {
	this.startPage = startPage;
}


public void setEndPage(int endPage) {
	this.endPage = endPage;
}


public void setStartRnumForMysql(int startRnumForMysql) {
	this.startRnumForMysql = startRnumForMysql;
}

}








