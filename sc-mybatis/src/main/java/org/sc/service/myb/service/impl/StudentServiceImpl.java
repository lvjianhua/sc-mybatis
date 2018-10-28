/**
 * @filename:StudentServiceImpl 2018年10月28日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.entity.Student;
import org.sc.service.myb.dao.StudentDao;
import org.sc.service.myb.service.StudentService;

/**   
 *  
 * @Description:  学生——SERVICEIMPL
 * @Author:       lv   
 * @CreateDate:   2018年10月28日
 * @Version:      V1.0
 *    
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentDao studentDao;
	
	//查询对象
	@Override
	public Student selectByPrimaryKey(Integer id) {
		return studentDao.selectByPrimaryKey(id);
	}
	
	//删除对象
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return studentDao.deleteByPrimaryKey(id);
	}
	
	//添加对象
	@Override
	public int insertSelective(Student student) {
		return studentDao.insertSelective(student);
	}
	
	//修改对象
	@Override
	public int updateByPrimaryKeySelective(Student student) {
		return studentDao.updateByPrimaryKeySelective(student);
	}
	
	//查询集合
	@Override
	public List<Student> queryStudentList(Student student) {
		return studentDao.queryStudentList(student);
	}
	
	//分页查询
	@Override
	public PageInfo<Student> getStudentBySearch(AppPage<Student> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<Student> list=studentDao.queryStudentList(page.getParam());
		PageInfo<Student> pageInfo = new PageInfo<Student>(list);
		return pageInfo;
	}
}