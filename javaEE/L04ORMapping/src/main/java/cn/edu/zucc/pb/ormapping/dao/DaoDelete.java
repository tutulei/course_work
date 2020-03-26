package cn.edu.zucc.pb.ormapping.dao;

import cn.edu.zucc.pb.ormapping.db.DataBaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class DaoDelete implements IDaoDelete {
    @Override
    public boolean deleteEntity(String PK, String clazz) {
        String sql = createSQLFromConfig("orm.properties", PK);
        Connection conn = null;
        try {
            conn = DataBaseManager.getConnection();
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " SQL:" + sql);
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("删除成功(*￣︶￣)");
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
     ID:需要删除的的行的PK值（循序要按照数据库中的顺序）
     cconfig:配置文档
      */
    private String createSQLFromConfig(String config, String PK){
        Properties properties = new Properties();
        URL url = this.getClass().getClassLoader().getResource("/" + config);
        try {
            properties.load(new FileReader(new File(url.getPath())));
            Enumeration<String> tokens = (Enumeration<String>) properties.propertyNames();

            String table = "";
            String pk = "";
            while (tokens.hasMoreElements()) {
                String name = tokens.nextElement();
                System.out.println(name);
                if (name.startsWith("table.dep.name")) {
                    table = properties.getProperty(name);
                }else if(name.startsWith("table.dep.key")){
                    pk = properties.getProperty(name);
                }
            }
            String sql = "DELETE FROM " +table+ " WHERE " +pk+ " = '" +PK+ "'";

            return sql;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
