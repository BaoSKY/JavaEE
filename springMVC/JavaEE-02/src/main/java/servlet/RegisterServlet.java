package servlet;

import dao.StudentDao;
import dao.TeacherDao;
import daoImpl.StudentDaoImpl;
import daoImpl.TeacherDaoImpl;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userType = req.getParameter("user_type");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(userType.equals("teacher")){
            TeacherDao teacherDao = new TeacherDaoImpl();

            if(teacherDao.addTeacher(name, password)){
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("注册失败");
            }
        }else{
            StudentDao studentDao = new StudentDaoImpl();

            if(studentDao.addStudent(name, password)){
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("注册失败");
            }
        }
    }
}
