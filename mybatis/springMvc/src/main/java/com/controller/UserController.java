package com.controller;

import com.service.StudentService;
import com.serviceImpl.HomeworkServiceImpl;
import com.serviceImpl.StudentServiceImpl;
import com.mapper.TeacherMapper;
import com.model.Homework;
import com.model.Student;
import com.model.Teacher;
import com.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @RequestMapping("login")
    public String login(Model model, @RequestParam String user_type, @RequestParam String name, @RequestParam String password){

        if(user_type.equals("teacher")){
            SqlSession session = MybatisUtil.getSession();
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
//            TeacherDao teacherDao = new TeacherDaoImpl();

            Teacher teacher = teacherMapper.getTeacher(name);
            if(password.equals(teacher.getPassword())){

                model.addAttribute("teacher", teacher);
                return "create_homework";
            }
        }else if(user_type.equals("student")){
            StudentService studentDao = new StudentServiceImpl();

            Student student = studentDao.getStudent(name);
            if(password.equals(student.getPassword())){
                model.addAttribute("sid", student.getId());

                List<Homework> homeworkList = new HomeworkServiceImpl().getHomeworkOfStudent(student.getId());
                model.addAttribute("homeworkList", homeworkList);

                return "submit_homework";
            }
        }

        return "fail";
    }

    @RequestMapping("register")
    public String register(Model model, @RequestParam String user_type, @RequestParam String name, @RequestParam String password){
        if(user_type.equals("teacher")){
            SqlSession session = MybatisUtil.getSession();
            TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
//            TeacherDao teacherDao = new TeacherDaoImpl();

            if(teacherMapper.addTeacher(name, password)){
                return "index";
            }
        }else{
            StudentService studentDao = new StudentServiceImpl();

            if(studentDao.addStudent(name, password)){
                return "index";
            }
        }

        return "fail";
    }
}
