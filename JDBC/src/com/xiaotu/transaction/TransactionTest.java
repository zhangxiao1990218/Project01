package com.xiaotu.transaction;

import com.xiaotu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 张晓
 * @create 2020-05-28 17:10
 */
public class TransactionTest {
    //通用的增删改操作
    public void update(String sql,Object ... args){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            con = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = con.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);//小心参数声明错误
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(con,ps);
        }

    }
}
