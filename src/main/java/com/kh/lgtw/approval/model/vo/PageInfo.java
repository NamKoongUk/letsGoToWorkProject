package com.kh.lgtw.approval.model.vo;

import java.io.Serializable;

public class PageInfo implements Serializable{
	private int currentPage;
	private int listCount;
	private int limit;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int buttonCount = 5;
	private String sortInfo;
	private String sort;
	private String filterInfo;
	private String sfCode;
	private int empNo;
	
	public PageInfo() {}
	
	

	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage, int buttonCount,
			String sortInfo, String sort, String filterInfo, String sfCode, int empNo) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.buttonCount = buttonCount;
		this.sortInfo = sortInfo;
		this.sort = sort;
		this.filterInfo = filterInfo;
		this.sfCode = sfCode;
		this.empNo = empNo;
	}





	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public PageInfo(int currentPage, int listCount, int limit, int maxPage, int startPage, int endPage,
			int buttonCount) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.buttonCount = buttonCount;
	}

	public int getButtonCount() {
		return buttonCount;
	}

	public void setButtonCount(int buttonCount) {
		this.buttonCount = buttonCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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

	public String getSortInfo() {
		return sortInfo;
	}

	public void setSortInfo(String sortInfo) {
		this.sortInfo = sortInfo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getFilterInfo() {
		return filterInfo;
	}

	public void setFilterInfo(String filterInfo) {
		this.filterInfo = filterInfo;
	}

	public int getEmpNo() {
		return empNo;
	}



	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	

	public String getSfCode() {
		return sfCode;
	}



	public void setSfCode(String sfCode) {
		this.sfCode = sfCode;
	}



	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit + ", maxPage="
				+ maxPage + ", startPage=" + startPage + ", endPage=" + endPage + ", buttonCount=" + buttonCount
				+ ", sortInfo=" + sortInfo + ", sort=" + sort + ", filterInfo=" + filterInfo + ", sfCode=" + sfCode
				+ ", empNo=" + empNo + "]";
	}


	
}
