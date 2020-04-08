package com.daoImpl;

import com.dao.HomeworkDao;
import com.model.Homework;
import com.util.JDBCUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class HomeworkDaoImpl implements HomeworkDao {

    private Connection connection = JDBCUtil.getConnection();

    @Override
    public boolean addHomework(String title, String requirement) {

        String sql = "INSERT INTO homework (title, requirement) VALUES (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, title);
            pst.setString(2, requirement);

            pst.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Homework> getAllHomework() {
        List<Homework> homeworkList = new ArrayList<>();

        String sql = "SELECT * FROM homework";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                Homework homework = new Homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Homework getHomeworkByTitle(String title) {

        String sql = "SELECT * FROM homework WHERE title = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, title);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()){
                return new Homework(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("requirement"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Homework> getHomeworkOfTeacher(int tid) {
        List<Homework> homeworkList = new ArrayList<>();

        String sql = "SELECT h.id, h.title, h.requirement FROM homework h, assign a WHERE h.id = a.hid AND tid = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, tid);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                Homework homework = new Homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public List<Homework> getHomeworkOfStudent(int sid) {
        List<Homework> homeworkList = new ArrayList<>();

        String sql = "SELECT h.id, h.title, h.requirement FROM homework h, submit s WHERE status = 0 AND h.id = s.hid AND sid = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, sid);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                Homework homework = new Homework();
                homework.setId(resultSet.getInt("id"));
                homework.setTitle(resultSet.getString("title"));
                homework.setRequirement(resultSet.getString("requirement"));

                homeworkList.add(homework);
            }

            return homeworkList;
        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
    }
}
