package com.loafer.stu.service;

import com.loafer.stu.beans.entity.Student;
import com.loafer.stu.beans.vo.Page;

public interface StuService {

	/**
	 * 登录
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public Student getStuByUsername(String userName) throws Exception;

	public Page<Student> getStuListByPage(Page<Student> page, Student stu) throws Exception;

	public void deleteStu(Long studentId);

}
