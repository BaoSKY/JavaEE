package com.controller;

import com.dao.AssignDao;
import com.dao.HomeworkDao;
import com.dao.SubmitDao;
import com.daoImpl.AssignDaoImpl;
import com.daoImpl.HomeworkDaoImpl;
import com.daoImpl.SubmitDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    SubmitDao submitDao;

    @Autowired
    AssignDao assignDao;

    @Autowired
    HomeworkDao homeworkDao;

    @RequestMapping("/assign")
    public String assign(int hid, String students){
       String[] studentIDs = students.split(";");

        submitDao = new SubmitDaoImpl();
        for(String studentId:studentIDs){
            int sid = Integer.parseInt(studentId);

            submitDao.addSubmit(sid, hid);
        }

        return "successful";
    }

    @RequestMapping("/createHomework")
    public String assign(Model model, int tid, String title, String requirement){
     if(homeworkDao.addHomework(title, requirement)){
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            assignDao = new AssignDaoImpl();
            assignDao.assign(tid, hid);

            model.addAttribute("homeworkList", homeworkDao.getHomeworkOfTeacher(tid));

            return "assign_homework";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/submit")
    public String assign(int hid, int sid, String content){
        submitDao = new SubmitDaoImpl();
        submitDao.submit(sid, hid, content);

        return "successful";
    }
}
