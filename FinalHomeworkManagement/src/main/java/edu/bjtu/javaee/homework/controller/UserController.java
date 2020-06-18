package edu.bjtu.javaee.homework.controller;

import edu.bjtu.javaee.homework.mapper.TeacherMapper;
import edu.bjtu.javaee.homework.model.Homework;
import edu.bjtu.javaee.homework.model.Student;
import edu.bjtu.javaee.homework.model.Submit;
import edu.bjtu.javaee.homework.model.Teacher;
import edu.bjtu.javaee.homework.service.*;
import edu.bjtu.javaee.homework.serviceImpl.*;
import edu.bjtu.javaee.homework.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
            session.commit();
            session.close();
            if(password.equals(teacher.getPassword())){

                model.addAttribute("teacher", teacher);
                return "teacher_actions";
            }
        }else if(user_type.equals("student")){
            StudentService studentDao = new StudentServiceImpl();

            Student student = studentDao.getStudent(name);
            if(password.equals(student.getPassword())){
                model.addAttribute("sid", student.getId());
                List<Homework> homeworkList = new HomeworkServiceImpl().getHomeworkOfStudent(student.getId());

                SubmitService submitService = new SubmitServiceImpl();
                List<String> contentList = new ArrayList<>();
                for (Homework homework: homeworkList){
                    int hid = homework.getId();

                    contentList.add(submitService.getContent(student.getId(), hid));
                }
                model.addAttribute("homeworkList", homeworkList);
                model.addAttribute("contentList", contentList);

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

            System.out.println("name:" + name + "  password:" + password);

            if(teacherMapper.addTeacher(name, password)){
                session.commit();
                session.close();
                return "successful";
            }
        }else{
            StudentService studentDao = new StudentServiceImpl();

            if(studentDao.addStudent(name, password)){
                return "successful";
            }
        }

        return "fail";
    }

    @RequestMapping("/teacherActions")
    public String teacherActions(Model model, @RequestParam int tid, @RequestParam String action){
        TeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = teacherService.getTeacherById(tid);
        model.addAttribute("teacher", teacher);

        if(action.equals("create")){
            return "create_homework";
        }else if(action.equals("look")){
            AssignService assignService = new AssignServiceImpl();
            List<Integer> homeworkIdList = assignService.getHomeworkIdList(tid);

            SubmitService submitService = new SubmitServiceImpl();

            List<Submit> submitList = new ArrayList<>();
            for(int hid : homeworkIdList){
                submitList.addAll(submitService.getSubmitByHid(hid));
            }

            model.addAttribute("submitList", submitList);

            return "look_homework";
        }

        return "fail";
    }
}
