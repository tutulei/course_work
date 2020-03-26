package cn.edu.zucc.pb.ormapping.dao;

import cn.edu.zucc.pb.ormapping.db.DataBaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class DaoUpdate implements IDAOUpdate{
    @Override
    public boolean updateEntity(String udmsg, String pk) {
        String sql = createSQLFromConfig("orm.properties", udmsg,pk);
        Connection conn = null;
        try {
            conn = DataBaseManager.getConnection();
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " SQL:" + sql);
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("更新成功(*￣︶￣)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return true;
    }
    /*
        udmsg:需要更新的值
        pk:主键参数，确定行
        cconfig:配置文档
         */
    private String createSQLFromConfig(String config, String udmsg,String pk){
        Properties properties = new Properties();
        URL url = this.getClass().getClassLoader().getResource("/" + config);
        try {
            properties.load(new FileReader(new File(url.getPath())));
            Enumeration<String> tokens = (Enumeration<String>) properties.propertyNames();

            String table = "";
            String UDmsg = "";
            String PK = "";
            while (tokens.hasMoreElements()) {
                String name = tokens.nextElement();
                System.out.println(name);
                if (name.startsWith("table.update.name")) {
                    table = properties.getProperty(name);
                }else if(name.startsWith("table.update.reference")){
                    PK = properties.getProperty(name);
                }else if(name.startsWith("table.update.CHAR")){
                    UDmsg = properties.getProperty(name);
                }
            }
            String sql = "UPDATE "+table+" SET "+UDmsg+" = '"+ udmsg +"' WHERE "+PK+" = '"+ pk +"'";

            return sql;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
