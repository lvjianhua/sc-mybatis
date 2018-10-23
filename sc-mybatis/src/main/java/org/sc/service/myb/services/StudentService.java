package org.sc.service.myb.services;


import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import org.sc.service.myb.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends IService<Student> {

    List<Student> findAllStudent();
    List<Student> findSomeColumn();

    void deleteById(Integer id);

    void updateByPrimarKeySelective(Student student);

    void saveStudent(Student student);

    Page<Student> findAllStudentPage(Page<Student> page);

    List<Student> findStuByGender(Integer gender);
}
