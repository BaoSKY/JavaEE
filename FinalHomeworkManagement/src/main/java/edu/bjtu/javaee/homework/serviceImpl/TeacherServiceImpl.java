package edu.bjtu.javaee.homework.serviceImpl;

import edu.bjtu.javaee.homework.mapper.TeacherMapper;
import edu.bjtu.javaee.homework.model.Teacher;
import edu.bjtu.javaee.homework.service.TeacherService;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    @Override
    public boolean addTeacher(String name, String password) {
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        boolean b = teacherMapper.addTeacher(name, password);
        session.commit();
        session.close();
        return b;
    }

    @Override
    public Teacher getTeacher(String name) {
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(name);
        session.commit();
        session.close();
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getAllTeachers();
        session.commit();
        session.close();
        return teacherList;
    }

    @Override
    public Teacher getTeacherById(int id) {
        SqlSession session = MybatisUtil.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(id);
        session.commit();
        session.close();
        return teacher;
    }
}
