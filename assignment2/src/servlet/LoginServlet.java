package servlet;

import dao.HomeworkDao;
import dao.StudentDao;
import dao.TeacherDao;
import daoImpl.HomeworkDaoImpl;
import daoImpl.StudentDaoImpl;
import daoImpl.TeacherDaoImpl;
import model.Homework;
import model.Student;
import model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userType = req.getParameter("user_type");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(userType.equals("teacher")){
            TeacherDao teacherDao = new TeacherDaoImpl();

            Teacher teacher = teacherDao.getTeacher(name);
            if(password.equals(teacher.getPassword())){

                req.setAttribute("teacher", teacher);
                req.getRequestDispatcher("create_homework.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("用户名或密码错误");
            }
        }else if(userType.equals("student")){
            StudentDao studentDao = new StudentDaoImpl();

            Student student = studentDao.getStudent(name);
            if(password.equals(student.getPassword())){
                req.setAttribute("sid", student.getId());

                List<Homework> homeworkList = new HomeworkDaoImpl().getHomeworkOfStudent(student.getId());
                req.setAttribute("homeworkList", homeworkList);

                req.getRequestDispatcher("submit_homework.jsp").forward(req, resp);
            }else{
                resp.getWriter().println("用户名或密码错误");
            }
        }
    }
}
