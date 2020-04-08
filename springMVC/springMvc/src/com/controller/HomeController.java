package com.controller;

import com.dao.AssignDao;
import com.dao.HomeworkDao;
import com.dao.SubmitDao;
import com.daoImpl.AssignDaoImpl;
import com.daoImpl.HomeworkDaoImpl;
import com.daoImpl.SubmitDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/assign")
    public String assign(int hid, String students){
        String[] studentIDs = students.split(";");

        SubmitDao submitDao = new SubmitDaoImpl();
        for(String studentId:studentIDs){
            int sid = Integer.parseInt(studentId);

            submitDao.addSubmit(sid, hid);
        }

        return "successful";
    }

    @RequestMapping("/createHomework")
    public String assign(Model model, int tid, String title, String requirement){
        HomeworkDao homeworkDao = new HomeworkDaoImpl();
        if(homeworkDao.addHomework(title, requirement)){
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            AssignDao assignDao = new AssignDaoImpl();
            assignDao.assign(tid, hid);

            model.addAttribute("homeworkList", homeworkDao.getHomeworkOfTeacher(tid));

            return "assign_homework";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/submit")
    public String assign(int hid, int sid, String content){
        SubmitDao submitDao = new SubmitDaoImpl();
        submitDao.submit(sid, hid, content);

        return "successful";
    }
}
