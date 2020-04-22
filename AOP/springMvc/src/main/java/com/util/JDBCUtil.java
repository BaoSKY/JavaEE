package com.util;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {

    //单实例Connection
    private static Connection connection;

    //私有constructor，防止实例化
    private JDBCUtil(){ }

    synchronized public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = DatabasePool.getHikariDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e.printStackTrace();
                }
            }
        }

        return connection;
    }

    //测试获取connection是否成功
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        if (connection != null)
            System.out.println("连接成功");
        else
            System.out.println("连接失败");
    }
}
