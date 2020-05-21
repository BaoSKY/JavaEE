package servlet;

import dao.SubmitDao;
import daoImpl.SubmitDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit")
public class HomeworkSubmitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int sid = Integer.parseInt(req.getParameter("sid"));
        int hid = Integer.parseInt(req.getParameter("hid"));
        String content = req.getParameter("content");

        SubmitDao submitDao = new SubmitDaoImpl();
        submitDao.submit(sid, hid, content);

        req.getRequestDispatcher("/successful.jsp").forward(req, resp);
    }
}
