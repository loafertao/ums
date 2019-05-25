package com.loafer.stu.dao;

import java.util.List;
import java.util.Map;

import com.loafer.stu.beans.entity.Student;

public interface StuDao {

	public Student findStuByUsername(String userName);

	public List<Student> findAppListByPageQuery(Map<String, Object> paramMap);

	public void deleteStuById(Long studentId);

	public List<Student> findAll();



}
