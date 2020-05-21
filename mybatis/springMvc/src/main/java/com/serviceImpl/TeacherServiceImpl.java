package com.serviceImpl;

import com.service.TeacherService;
import com.mapper.TeacherMapper;
import com.model.Teacher;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private SqlSession session = MybatisUtil.getSession();
    private TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

    @Override
    public boolean addTeacher(String name, String password) {
        return teacherMapper.addTeacher(name, password);
    }

    @Override
    public Teacher getTeacher(String name) {
        return teacherMapper.getTeacher(name);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }
}
