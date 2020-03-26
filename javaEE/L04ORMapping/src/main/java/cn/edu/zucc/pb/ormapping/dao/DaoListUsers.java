package cn.edu.zucc.pb.ormapping.dao;

import cn.edu.zucc.pb.ormapping.db.DataBaseManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class DaoListUsers<T> implements IDaoListUsers<T> {

    @Override
    public List<T> getEntity(String key, String clazz) {
        List<String> cols = new ArrayList<String>();
        String sql = createSQLFromConfig("orm.properties", key, cols);

        Connection conn = null;
        List<T> list = new ArrayList<T>();
        T entity = null;
        try {
            conn = DataBaseManager.getConnection();
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " SQL:" + sql);
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                try {
                    entity = (T) Class.forName(clazz).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                for (String col : cols) {
                    String value = rs.getString(col);
                    String setMethod = "set" + col.toUpperCase().substring(0, 1) + col.substring(1);
                    try {
                        entity.getClass().getMethod(setMethod, String.class).invoke(entity, value);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                list.add(entity);
            }
            return list;
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
        return null;
    }
    private String createSQLFromConfig(String config, String key, List<String> cols) {
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
                if (name.startsWith("table.listuser.key")) {
                    pk = properties.getProperty(name);
                } else if (name.startsWith("table.listuser.name")) {
                    table = properties.getProperty(name);
                } else if (name.startsWith("table.listuser.col")) {
                    cols.add(properties.getProperty(name));
                }
            }

            String sql = "select 1";
            for (String col : cols) {
                sql = sql + "," + col;
            }

            sql = sql + " from " + table + " where " + pk + "='" + key + "'";
            return sql;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
