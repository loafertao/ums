package com.loafer.stu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loafer.stu.base.controller.BaseController;
import com.loafer.stu.beans.entity.Student;
import com.loafer.stu.beans.vo.Page;
import com.loafer.stu.service.StuService;
@Controller("stuController")
@RequestMapping("/stu")
public class StuController extends BaseController{
	@Resource(name = "stuService")
	private StuService stuService;
	
	/**
	 * 加载登录页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String getLoginPage() throws Exception {
		return "login_form";
	}
	/**
	 * 进行登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginUser(String userName,String password) throws Exception{
		//判断用户输入的内容是否有效
		if (userName != null && !"".equals(userName.trim()) &&
				password != null && !"".equals(password.trim()) ) {
			Student stu = stuService.getStuByUsername(userName);
			if (stu != null && password.equals(stu.getPassword())) {
				//登录成功
				session.setAttribute("stu", stu);
				return "redirect:list";
			}
		}
		return "redirect:login";
	}
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ModelAndView getList(Integer pageNum,Integer pageSize)throws Exception{
		Page<Student> page = new Page<Student>(pageNum, pageSize);
		Student stu = (Student) session.getAttribute("stu");
		page = stuService.getStuListByPage(page,stu);
		return new ModelAndView("list_form","page",page);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteStu(Long studentId) throws Exception {
		stuService.deleteStu(studentId);
		return "redirect:list";
	}
}
