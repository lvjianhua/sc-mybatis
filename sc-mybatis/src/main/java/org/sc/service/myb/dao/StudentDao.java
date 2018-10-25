package org.sc.service.myb.dao;


import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.sc.service.myb.entity.Student;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;



@Repository
public interface StudentDao extends BaseMapper<Student> {


    List<Student> findAllStudent();

    List<Student> findSomeColumn();

    void deleteById(Integer id);

    void updateByPrimarKeySelective(Student student);

    void saveStudent(Student student);

    List<Student> findAllStudentPage(Pagination page);


    @Select("select * from tb_student where gender = #{gender}")
    @Results({
            @Result(column="stu_name",property="stuName"),
            @Result(column="stu_mobile",property="stuMobile"),
            @Result(column="stu_number",property="stuNumber"),
            @Result(column="par_name",property="parName"),
            @Result(column="par_mobile",property="parMobile"),
            @Result(column="create_time",property="createTime")
    })
    List<Student> findStuByGender(Integer gender);
}
