package edu.bjtu.javaee.homework.serviceImpl;

import edu.bjtu.javaee.homework.mapper.StudentMapper;
import edu.bjtu.javaee.homework.model.Student;
import edu.bjtu.javaee.homework.service.StudentService;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public boolean addStudent(String name, String password) {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        boolean b = studentMapper.addStudent(name, password);

        session.commit();
        session.close();
        return b;
    }

    @Override
    public Student getStudent(String name) {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudent(name);
        session.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getAllStudents();
        session.commit();
        session.close();
        return studentList;
    }
}
