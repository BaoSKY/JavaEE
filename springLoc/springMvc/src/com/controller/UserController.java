package com.controller;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.daoImpl.HomeworkDaoImpl;
import com.daoImpl.StudentDaoImpl;
import com.daoImpl.TeacherDaoImpl;
import com.model.Homework;
import com.model.Student;
import com.model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @RequestMapping("login")
    public String login(Model model, @RequestParam String user_type, @RequestParam String name, @RequestParam String password){
        ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");

        if(user_type.equals("teacher")){
            TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");

            Teacher teacher = teacherDao.getTeacher(name);
            if(password.equals(teacher.getPassword())){

                model.addAttribute("teacher", teacher);
                return "create_homework";
            }
        }else if(user_type.equals("student")){
            StudentDao studentDao = (StudentDao) context.getBean("studentDao");

            Student student = studentDao.getStudent(name);
            if(password.equals(student.getPassword())){
                model.addAttribute("sid", student.getId());

                List<Homework> homeworkList = new HomeworkDaoImpl().getHomeworkOfStudent(student.getId());
                model.addAttribute("homeworkList", homeworkList);

                return "submit_homework";
            }
        }

        return "fail";
    }

    @RequestMapping("register")
    public String register(Model model, @RequestParam String user_type, @RequestParam String name, @RequestParam String password){
        ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");

        if(user_type.equals("teacher")){
            TeacherDao teacherDao = (TeacherDao) context.getBean("teacherDao");

            if(teacherDao.addTeacher(name, password)){
                return "index";
            }
        }else{
            StudentDao studentDao = (StudentDao) context.getBean("studentDao");

            if(studentDao.addStudent(name, password)){
                return "index";
            }
        }

        return "fail";
    }
}
