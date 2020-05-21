package com.controller;

import com.service.AssignService;
import com.service.HomeworkService;
import com.service.SubmitService;
import com.serviceImpl.AssignServiceImpl;
import com.serviceImpl.HomeworkServiceImpl;
import com.serviceImpl.SubmitServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

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
