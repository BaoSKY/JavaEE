package com.daoImpl;

import com.dao.SubmitDao;
import com.model.Homework;
import com.util.JDBCUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SubmitDaoImpl implements SubmitDao {

    Connection connection = JDBCUtil.getConnection();

    @Override
    public void addSubmit(int sid, int hid) {

        String sql = "INSERT INTO submit (sid, hid, status) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, sid);
            pst.setInt(2, hid);
            pst.setInt(3, Homework.SUBMIT_STATUS_DOING);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void submit(int sid, int hid, String content) {

        String sql = "UPDATE submit SET status = ?, content = ?, submit_time = now() WHERE sid = ? AND hid = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            Date d = new Date(); // 注意是util包下的Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
            String date = sdf.format(d);
            date = date.substring(0, date.length() - 1);

            pst.setInt(1, Homework.SUBMIT_STATUS_SUBMITTED);
            pst.setString(2, content);
//            pst.setString(3, date);
            pst.setInt(3, sid);
            pst.setInt(4, hid);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
