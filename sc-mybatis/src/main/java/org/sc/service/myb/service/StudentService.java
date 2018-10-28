/**
 * @filename:StudentService 2018年10月28日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.entity.Student;
/**   
 *  
 * @Description:  学生——SERVICE
 * @Author:       lv   
 * @CreateDate:   2018年10月28日
 * @Version:      V1.0
 *    
 */
public interface StudentService {
	
	/**
	 * @explain 查询学生对象
	 * @param   对象参数：id
	 * @return  Student
	 * @author  lv
	 */
	public Student selectByPrimaryKey(Integer id);
	
	/**
	 * @explain 删除学生对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  lv
	 */
	public int deleteByPrimaryKey(Integer id);
	
	/**
	 * @explain 添加学生对象
	 * @param   对象参数：Student
	 * @return  int
	 * @author  lv
	 */
	public int insertSelective(Student student);
	
	/**
	 * @explain 修改学生对象
	 * @param   对象参数：Student
	 * @return  int
	 * @author  lv
	 */
	public int updateByPrimaryKeySelective(Student student);
	
	/**
	 * @explain 查询学生集合
	 * @param   对象参数：Student
	 * @return  List<Student>
	 * @author  lv
	 */
	public List<Student> queryStudentList(Student student);
	
	/**
	 * @explain 分页查询学生
	 * @param   对象参数：Student
	 * @return  PageInfo<Student>
	 * @author  lv
	 */
	public PageInfo<Student> getStudentBySearch(AppPage<Student> page);
}