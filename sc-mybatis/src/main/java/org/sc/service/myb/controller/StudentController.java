/**
 * @filename:StudentController 2018年10月28日
 * @project sc-mybatis  V1.0
 * Copyright(c) 2018 lv Co. Ltd. 
 * All right reserved. 
 */
package org.sc.service.myb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import org.sc.service.myb.util.AppPage;
import org.sc.service.myb.util.JsonResult;
import org.sc.service.myb.entity.Student;
import org.sc.service.myb.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * @Description:  学生接口层
 * @Author:       lv   
 * @CreateDate:   2018年10月28日
 * @Version:      V1.0
 *    
 */
@Api(description = "学生",value="学生" )
@RestController
@RequestMapping("/student")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public StudentService studentServiceImpl;
	
	/**
	 * @explain 查询学生对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  student
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@GetMapping("/getStudentById/{id}")
	@ApiOperation(value = "获取学生信息", notes = "获取学生信息[student]，作者：lv")
	@ApiImplicitParam(paramType="path", name = "id", value = "学生id", required = true, dataType = "Integer")
	public JsonResult<Student> getStudentById(@PathVariable("id")Integer id){
		JsonResult<Student> result=new JsonResult<Student>();
		try {
			Student student=studentServiceImpl.selectByPrimaryKey(id);
			if (student!=null) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(student);
			} else {
				logger.error("获取学生失败ID："+id);
				result.setCode(-1);
				result.setMessage("你获取的学生不存在");
			}
		} catch (Exception e) {
			logger.error("获取学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 添加学生对象
	 * @param   对象参数：student
	 * @return  int
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加学生", notes = "添加学生[student],作者：lv")
	public JsonResult<Student> insertSelective(Student student){
		JsonResult<Student> result=new JsonResult<Student>();
		try {
			int rg=studentServiceImpl.insertSelective(student);
			if (rg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(student);
			} else {
				logger.error("添加学生执行失败："+student.toString());
				result.setCode(-1);
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 删除学生对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除学生", notes = "删除学生,作者：lv")
	@ApiImplicitParam(paramType="query", name = "id", value = "学生id", required = true, dataType = "Integer")
	public JsonResult<Object> deleteByPrimaryKey(Integer id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			int reg=studentServiceImpl.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除学生失败ID："+id);
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 修改学生对象
	 * @param   对象参数：student
	 * @return  student
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@ApiOperation(value = "修改学生", notes = "修改学生[student],作者：lv")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult<Student> updateByPrimaryKeySelective(Student student){
		JsonResult<Student> result=new JsonResult<Student>();
		try {
			int reg = studentServiceImpl.updateByPrimaryKeySelective(student);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(student);
			} else {
				logger.error("修改学生失败ID："+student.toString());
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("修改学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 获取匹配学生
	 * @param   对象参数：student
	 * @return  List<Student>
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@ApiOperation(value = "条件查询学生", notes = "条件查询[student],作者：lv")
	@PostMapping("/queryStudentList")
	public JsonResult<List<Student>> queryStudentList(Student student){
		JsonResult<List<Student>> result=new JsonResult<List<Student>>();
		try {
			List<Student> list = studentServiceImpl.queryStudentList(student);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(list);
		} catch (Exception e) {
			logger.error("获取学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询学生   
	 * @param   对象参数：AppPage<Student>
	 * @return  PageInfo<Student>
	 * @author  lv
	 * @time    2018年10月28日
	 */
	@GetMapping("/getPageStudent")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[PageInfo<Student>],作者：边鹏")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult<PageInfo<Student>> getStudentBySearch(Integer pageNum,Integer pageSize){
		JsonResult<PageInfo<Student>> result=new JsonResult<PageInfo<Student>>();
		AppPage<Student> page =new AppPage<Student>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		//其他参数
		Student student=new Student();
		page.setParam(student);
		//分页数据
		try {
			PageInfo<Student> pageInfo = studentServiceImpl.getStudentBySearch(page);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询学生执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
}