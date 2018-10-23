package org.sc.service.myb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.sc.service.myb.entity.Student;
import org.sc.service.myb.services.StudentService;
import org.sc.service.myb.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import lombok.extern.slf4j.Slf4j;


@Api(value ="student接口")
@RestController
@RequestMapping("/sc-mybatis/student")
@Slf4j
public class TestController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "获取所有student信息")
    @RequestMapping(value="/findAllStudent",method = RequestMethod.GET)
    public PageList test1(){
        PageList result = new PageList();
        List<Student> student = studentService.findAllStudent();
        result.setData(student);
        return result;
    }
    

    @ApiOperation(value = "保存student信息")
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public PageList Register(@RequestBody Student student){
        studentService.insert(student);
        return new PageList(PageList.OK,"保存成功");
    }

    @ApiOperation(value = "获取student列表信息")
    @RequestMapping(value="/findSomeColumn",method = RequestMethod.GET)
    public PageList test2(){
        PageList result = new PageList();
        List<Student> stu = studentService.findSomeColumn();
        result.setData(stu);
        return result;
    }

    @ApiOperation(value = "根据id删除student信息")
    @RequestMapping(value="deleteById/{id}",method = RequestMethod.POST)
    public PageList test3(@PathVariable  Integer id){
        PageList result = new PageList();
        studentService.deleteById(id);
        result.setMsg("删除成功");
        return result;
    }

    @ApiOperation(value = "修改student信息")
    @RequestMapping(value="updateByPrimarKeySelective",method = RequestMethod.POST)
    public PageList test4(@RequestBody Student student){
        PageList result = new PageList();
        EntityWrapper<Student> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("stu_mobile", student.getStuMobile());
        Student stu = studentService.selectOne(entityWrapper);
        if (null != stu) {
            stu.setParName("my hero");
            stu.setStuName("zxs");
        }
        studentService.updateByPrimarKeySelective(stu);
        result.setData(stu);
        return result;
    }

    @ApiOperation(value = "")
    @RequestMapping(value="/saveStudent",method = RequestMethod.POST)   
    public PageList<Student> test5(@RequestBody Student student){
        PageList<Student> result = new PageList<Student>();
        studentService.saveStudent(student);
        result.setData(student);

        return result;

    }
/**
     * 分页的方法
     * @param pageNumber
     * @param pageSize
     * @return*/
    @ApiOperation(value = "分页")
    @RequestMapping(value="page/{pageNumber}",method = RequestMethod.POST)
    public PageList findAllStuPage(@PathVariable Integer pageNumber,
                                   @RequestParam(defaultValue="6") Integer pageSize){
        PageList result = new PageList();
        Page page = new Page(pageNumber,pageSize);
        Page<Student> pageStu = studentService.findAllStudentPage(page);
        result.setData(pageStu.getRecords());
        return result;

    }

    @ApiOperation(value = "")
    @RequestMapping(value="pageByGender/{pageNumber}",method = RequestMethod.POST)
    public PageList findStuByGender(@PathVariable Integer pageNumber,
                                    @RequestParam(defaultValue="6") Integer pageSize){
        PageList result = new PageList<>();

        EntityWrapper<Student> wrapper = new EntityWrapper<>();
        wrapper.eq("gender", 1);
        Page<Student> page = getPage(pageNumber, pageSize);
        Page<Student> stuPage = studentService.selectPage(page, wrapper);
        result.setData(stuPage.getRecords());

        return result;
    }



/**
     * 获取分页对象
     * 每页显示数量*/



    private <T> Page<T> getPage(int pageNum,int pageSize){

        return new Page<T>(pageNum,pageSize);
    }


}
