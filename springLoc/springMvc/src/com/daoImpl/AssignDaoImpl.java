package com.daoImpl;

import com.dao.AssignDao;
import com.util.JDBCUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class AssignDaoImpl implements AssignDao {

    private Connection connection = JDBCUtil.getConnection();

    @Override
    public void assign(int tid, int hid) {

        String sql = "INSERT INTO assign (tid, hid) VALUES (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, tid);
            pst.setInt(2, hid);

            pst.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
