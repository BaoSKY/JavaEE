package com.service;

import com.dao.AssignDao;
import com.dao.HomeworkDao;
import com.dao.SubmitDao;
import com.daoImpl.SubmitDaoImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class HomeworkService {

    @Autowired
    SubmitDao submitDao;

    public void point(){

    }

    @Before(value = "assign(int, String)")
    public void beforeAssign(){
        System.out.println("Before assign");
    }

    @Pointcut(value="execution(* com.service.HomeworkService.assign(int, String)) && args(hid, students)", argNames = "hid,students")
    public boolean assign(int hid, String students){
        String[] studentIDs = students.split(";");

        submitDao = new SubmitDaoImpl();
        for (String studentId : studentIDs) {
            int sid = Integer.parseInt(studentId);

            submitDao.addSubmit(sid, hid);
        }

        return true;
    }

    @After(value = "assign(int, String)")
    public void afterAssign(){
        System.out.println("After assign");
    }
}
