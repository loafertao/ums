package com.loafer.stu.beans.vo;

import java.io.Serializable;
import java.util.List;

import com.loafer.stu.util.ConstantUtil;

public class Page<E> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer pageNum;
	private Integer pageSize;
	private List<E> list;
	private Integer totalSize;
	private Integer totalPage;
	
	public Page(){}
	
	public Page(Integer pageNum,Integer pageSize){
		
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		}else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
	}
	
	
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
