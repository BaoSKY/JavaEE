package com.controller;

import com.dao.AssignDao;
import com.dao.HomeworkDao;
import com.dao.SubmitDao;
import com.daoImpl.AssignDaoImpl;
import com.daoImpl.HomeworkDaoImpl;
import com.daoImpl.SubmitDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/assign")
    public String assign(int hid, String students){
        ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
        SubmitDao submitDao = (SubmitDao) context.getBean("submitDao");
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
        ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
        HomeworkDao homeworkDao = (HomeworkDao) context.getBean("homeworkDao");

        if(homeworkDao.addHomework(title, requirement)){
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            AssignDao assignDao = (AssignDao) context.getBean("assignDao");
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
        ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
        SubmitDao submitDao = (SubmitDao) context.getBean("submitDao");
        submitDao = new SubmitDaoImpl();
        submitDao.submit(sid, hid, content);

        return "successful";
    }
}
