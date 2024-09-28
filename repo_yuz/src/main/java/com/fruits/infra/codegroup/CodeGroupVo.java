package com.fruits.infra.codegroup;

public class CodeGroupVo {
	
	// search
	private Integer shDelNy;          //삭제여부검색
	private Integer shUseNy;          //사용여부검색  
	private Integer shOption;         //검색옵션
	private String shValue;           //검색값
	private Integer shOptionDate;     //날짜검색옵션
	private String shDateStart;       //검색시작날짜
	private String shDateEnd;         //검색끝날짜
	
	
	
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
		
		//내용 출력
		System.out.println("thisPage : " + getThisPage());
		System.out.println("rowNumToShow : " + getRowNumToShow());
		System.out.println("pageNumToShow : " + getPageNumToShow());
		System.out.println("totalRows : " + getTotalRows());
		System.out.println("totalPages : " + getTotalPages());
		System.out.println("startPage : " + getStartPage());
		System.out.println("endPage : " + getEndPage());
		System.out.println("startRnumForMysql : " + getStartRnumForMysql());

			
		
	}


public Integer getShDelNy() {
	return shDelNy;
}


public void setShDelNy(Integer shDelNy) {
	this.shDelNy = shDelNy;
}


public Integer getShUseNy() {
	return shUseNy;
}


public void setShUseNy(Integer shUseNy) {
	this.shUseNy = shUseNy;
}


public Integer getShOption() {
	return shOption;
}


public void setShOption(Integer shOption) {
	this.shOption = shOption;
}


public String getShValue() {
	return shValue;
}


public void setShValue(String shValue) {
	this.shValue = shValue;
}


public Integer getShOptionDate() {
	return shOptionDate;
}


public void setShOptionDate(Integer shOptionDate) {
	this.shOptionDate = shOptionDate;
}


public String getShDateStart() {
	return shDateStart;
}


public void setShDateStart(String shDateStart) {
	this.shDateStart = shDateStart;
}


public String getShDateEnd() {
	return shDateEnd;
}


public void setShDateEnd(String shDateEnd) {
	this.shDateEnd = shDateEnd;
}


public int getThisPage() {
	return thisPage;
}


public void setThisPage(int thisPage) {
	this.thisPage = thisPage;
}


public int getRowNumToShow() {
	return rowNumToShow;
}


public void setRowNumToShow(int rowNumToShow) {
	this.rowNumToShow = rowNumToShow;
}


public int getPageNumToShow() {
	return pageNumToShow;
}


public void setPageNumToShow(int pageNumToShow) {
	this.pageNumToShow = pageNumToShow;
}


public int getTotalRows() {
	return totalRows;
}


public void setTotalRows(int totalRows) {
	this.totalRows = totalRows;
}


public int getTotalPages() {
	return totalPages;
}


public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}


public int getStartPage() {
	return startPage;
}


public void setStartPage(int startPage) {
	this.startPage = startPage;
}


public int getEndPage() {
	return endPage;
}


public void setEndPage(int endPage) {
	this.endPage = endPage;
}


public int getStartRnumForMysql() {
	return startRnumForMysql;
}


public void setStartRnumForMysql(int startRnumForMysql) {
	this.startRnumForMysql = startRnumForMysql;
}
	
	
	

	
	



	
	
		
	}
	
	





	
	


