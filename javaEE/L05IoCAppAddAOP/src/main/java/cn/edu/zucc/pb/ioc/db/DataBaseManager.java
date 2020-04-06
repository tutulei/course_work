package cn.edu.zucc.pb.ioc.db;

import java.sql.Connection;

public class DataBaseManager {
    private static final String jdbcUrl="jdbc:mysql://101.132.157.72:3306/E04-DATA?useUnicode=true&characterEncoding=utf-8";
    private static final String dbUser="root";
    private static final String dbPwd="123456";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws java.sql.SQLException{
        return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
    }
}
