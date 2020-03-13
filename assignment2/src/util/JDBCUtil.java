package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    //单实例Connection
    private static Connection connection;

    //JDBC驱动名
    private static final String driverName = "com.mysql.cj.jdbc.Driver";

    //连接数据库的url
    private static final String url = "jdbc:mysql://127.0.0.1:3306/homework?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

    //数据库用户名
    private static final String user = "user";

    //数据库用户的密码
    private static final String password = "password";

    //私有constructor，防止实例化
    private JDBCUtil(){ }

    public static Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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
