package edu.bjtu.javaee.homework.controller;

import edu.bjtu.javaee.homework.model.Homework;
import edu.bjtu.javaee.homework.service.AssignService;
import edu.bjtu.javaee.homework.service.HomeworkService;
import edu.bjtu.javaee.homework.service.SubmitService;
import edu.bjtu.javaee.homework.serviceImpl.AssignServiceImpl;
import edu.bjtu.javaee.homework.serviceImpl.HomeworkServiceImpl;
import edu.bjtu.javaee.homework.serviceImpl.SubmitServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeworkController {

    @RequestMapping("/assign")
    public String assign(int hid, String students){
        String[] studentIDs = students.split(";");

        SubmitService submitDao = new SubmitServiceImpl();
        for(String studentId:studentIDs){
            int sid = Integer.parseInt(studentId);

            submitDao.addSubmit(sid, hid);
        }

        return "successful";
    }

    @RequestMapping("/createHomework")
    public String assign(Model model, int tid, String title, String requirement){
        HomeworkService homeworkDao = new HomeworkServiceImpl();
        if(homeworkDao.addHomework(title, requirement)){
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            AssignService assignDao = new AssignServiceImpl();
            assignDao.assign(tid, hid);

            List<Homework> homeworkList = homeworkDao.getHomeworkOfTeacher(tid);
            model.addAttribute("homeworkList", homeworkDao.getHomeworkOfTeacher(tid));

            return "assign_homework";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/submit")
    public String assign(int hid, int sid, String content){
        SubmitService submitDao = new SubmitServiceImpl();
        submitDao.submit(sid, hid, content);

        return "successful";
    }
}
