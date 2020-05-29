package com.xiaotu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 张晓
 * @create 2020-05-28 16:23
 */
public class JDBCUtils {


    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() throws Exception {
        //1.加载配置文件
        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        //2.读取配置信息
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //3.加载驱动
        Class.forName(driverClass);

        //4.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }



    public static void closeResource(Connection con, Statement sta){
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
