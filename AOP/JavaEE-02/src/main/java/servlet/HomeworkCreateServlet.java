package servlet;

import dao.AssignDao;
import dao.HomeworkDao;
import daoImpl.AssignDaoImpl;
import daoImpl.HomeworkDaoImpl;
import model.Homework;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createHomework")
public class HomeworkCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int tid = Integer.parseInt(req.getParameter("tid"));
        String title = req.getParameter("title");
        String requirement = req.getParameter("requirement");

        HomeworkDao homeworkDao = new HomeworkDaoImpl();
        if(homeworkDao.addHomework(title, requirement)){
            int hid = homeworkDao.getHomeworkByTitle(title).getId();

            AssignDao assignDao = new AssignDaoImpl();
            assignDao.assign(tid, hid);

            req.setAttribute("homeworkList", homeworkDao.getHomeworkOfTeacher(tid));

            req.getRequestDispatcher("/assign_homework.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/fail.jsp").forward(req, resp);
        }
    }
}
