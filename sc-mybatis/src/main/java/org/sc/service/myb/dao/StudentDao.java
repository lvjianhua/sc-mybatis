/**
 * @filename:StudentDao 2018年10月28日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.sc.service.myb.entity.Student;

/**   
 *  
 * @Description:  学生——DAO
 * @Author:       lv   
 * @CreateDate:   2018年10月28日
 * @Version:      V1.0
 *    
 */
@Mapper
public interface StudentDao {
	
	public Student selectByPrimaryKey(Integer id);
	
	public int deleteByPrimaryKey(Integer id);
	
	public int insertSelective(Student student);
	
	public int updateByPrimaryKeySelective(Student student);
	
	public List<Student> queryStudentList(Student student);
}
