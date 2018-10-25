package org.sc.service.myb.services.impl;


import java.util.List;

import org.sc.service.myb.dao.StudentDao;
import org.sc.service.myb.entity.Student;
import org.sc.service.myb.services.StudentService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student>
        implements StudentService {

    @Override
    public List<Student> findAllStudent() {
        // TODO Auto-generated method stub
        return baseMapper.findAllStudent();
    }

    @Override
    public List<Student> findSomeColumn() {
        // TODO Auto-generated method stub
        return baseMapper.findSomeColumn();
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);

    }

    @Override
    public void updateByPrimarKeySelective(Student student) {
        baseMapper.updateById(student);

    }

    @Override
    public void saveStudent(Student student) {
        baseMapper.saveStudent(student);

    }

    @Override
    public Page<Student> findAllStudentPage(Page<Student> page) {
        // TODO Auto-generated method stub
        page.setRecords(baseMapper.findAllStudentPage(page));
        return page;
    }

    @Override
    public List<Student> findStuByGender(Integer gender) {
        // TODO Auto-generated method stub
        return baseMapper.findStuByGender(gender);
    }

}
