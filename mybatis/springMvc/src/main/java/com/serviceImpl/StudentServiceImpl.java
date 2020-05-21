package com.serviceImpl;

import com.service.StudentService;
import com.mapper.StudentMapper;
import com.model.Student;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private SqlSession session = MybatisUtil.getSession();
    private StudentMapper studentMapper = session.getMapper(StudentMapper.class);

    @Override
    public boolean addStudent(String name, String password) {
        return studentMapper.addStudent(name, password);
    }

    @Override
    public Student getStudent(String name) {
        return studentMapper.getStudent(name);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}
