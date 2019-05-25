package com.loafer.stu.beans.entity;

import java.io.Serializable;

public class Clazz implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long clazzId;
	private String clazzNo;
	private String classroom;
	public Long getClazzId() {
		return clazzId;
	}
	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}
	public String getClazzNo() {
		return clazzNo;
	}
	public void setClazzNo(String clazzNo) {
		this.clazzNo = clazzNo;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	
}
