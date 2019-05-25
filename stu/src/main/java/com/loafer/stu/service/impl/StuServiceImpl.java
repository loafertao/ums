package com.loafer.stu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.loafer.stu.beans.entity.Student;
import com.loafer.stu.beans.vo.Page;
import com.loafer.stu.dao.StuDao;
import com.loafer.stu.service.StuService;

@Service("stuService")
@Transactional
public class StuServiceImpl implements StuService{
	@Resource(name = "stuDao")
	private StuDao stuDao;

	/**
	 * 登录
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public Student getStuByUsername(String userName) throws Exception {
		
		return stuDao.findStuByUsername(userName);
	}


	public Page<Student> getStuListByPage(Page<Student> page, Student stu) throws Exception {
		//封装分页信息
		Map< String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("begin", (page.getPageNum() - 1) * page.getPageSize());
		paramMap.put("size", page.getPageSize());
		paramMap.put("stu", stu);
		//开始分页查询
		List<Student> stuList = stuDao.findAppListByPageQuery(paramMap);
		//查询总数量
		List<Student> list = stuDao.findAll();
		Integer totalSize = list.size();
		//总页数
		Integer totalPage = (totalSize % page.getPageSize() == 0) ? totalSize / page.getPageSize() : (totalSize / page.getPageSize() + 1);
		//将结果放入分页对象
		page.setList(stuList);
		page.setTotalSize(totalSize);
		page.setTotalPage(totalPage);
		return page;
		
	}


	
	public void deleteStu(Long studentId) {
		stuDao.deleteStuById(studentId);
	}

}
