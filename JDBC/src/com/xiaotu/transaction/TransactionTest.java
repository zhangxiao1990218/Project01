package com.xiaotu.transaction;

import com.xiaotu.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 *
 * 1.什么叫数据库事物？
 *事物：一组逻辑操作单元，使数据从一种状态变换到另一种状态
 *          >一组逻辑操作单元：一个或多个DML操作
 * 2.事物处理的原则（事物操作）：保证所有事物都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 *      当在一个事物中执行多个操作时，要么所有的事务都提交，那么这些修改就永久的保存下来，
 *      要么数据库管理系统将放弃所作的所有修改，整个事物回滚到最初的状态。
 *  为确保数据库中数据的一致性，数据的操纵应当是离散的成组的逻辑单元；当它全部完成时，数据一致性可以保持，
 *      而当这个单元中的一部分操作失败，整个事物应全部作为错误，所有从起始点以后的操作应全部回退到开始状态。
 * 3.数据一旦提交，就不可回滚。
 * 4.哪些操作会导致数据的自动提交？
 *          >DDL操作一旦执行，都会自动提交。
 *              >set autocommit = false 对DDL操作失效。
 *          >DML默认情况下，一旦执行，就会自动提交。
 *              >我们可以通过set autocommit = false 的方式取消DML操作的自动提交。
 *          >默认在关闭连接时，会自动的提交数据。
 * @author 张晓
 * @create 2020-05-28 17:10
 */
public class TransactionTest {
    /**
     * 针对于数据表user_table来说：
     * AA用户给BB用户转账100
     *
     *
     * update user_table set balance = balance-100 where user = 'AA';
     * update user_table set balance = balance+100 where user = 'BB';
     */
    @Test
    public void testUpdate(){
        String sql1 = "update user_table set balance = balance-100 where user = ? ";
        update(sql1,"AA");
        //模拟网络异常
        System.out.println(10/0);
        String sql2 = "update user_table set balance = balance+100 where user = ? ";
        update(sql2,"BB");
        System.out.println("转账成功");
    }

    //**********************************未考虑事物的转账操作*********************************
    //通用的增删改操作 ----version 1.0 (未考虑事物)
    public int update(String sql,Object ... args){
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
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(con,ps);
        }

        return 0;
    }

    //**********************************虑事物后的转账操作*********************************
    @Test
    public void testUpdateWithTx(){
        Connection con = null;
        try {
            con = JDBCUtils.getConnection();
            System.out.println(con.getAutoCommit());
            //1.取消数据的自动提交
            con.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance-100 where user = ? ";
            update(con,sql1,"AA");
            //模拟网络异常
            //System.out.println(10/0);
            String sql2 = "update user_table set balance = balance+100 where user = ? ";
            update(con,sql2,"BB");
            System.out.println("转账成功");
            //2.提交数据
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //3.回滚数据
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(con,null);
        }
    }


    //通用的增删改操作 ----version 2.0 (考虑上事物)
    public int update(Connection con,String sql,Object ... args) {
        PreparedStatement ps = null;
        try {
            //1.预编译sql语句，返回PreparedStatement的实例
            ps = con.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数声明错误
            }
            //3.执行
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }


    //******************************************************************
    @Test
    public void testTransactionSelect() throws Exception{

        Connection conn = JDBCUtils.getConnection();
        //获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
        //设置数据库的隔离级别：
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        //取消自动提交数据
        conn.setAutoCommit(false);

        String sql = "select user,password,balance from user_table where user = ?";
        User user = getInstance(conn, User.class, sql, "CC");

        System.out.println(user);

    }

    @Test
    public void testTransactionUpdate() throws Exception{
        Connection conn = JDBCUtils.getConnection();

        //取消自动提交数据
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update(conn, sql, 5000,"CC");

        Thread.sleep(15000);
        System.out.println("修改结束");
    }

    //通用的查询操作，用于返回数据表中的一条记录（version 2.0：考虑上事务）
    public <T> T getInstance(Connection conn,Class<T> clazz,String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);

        }

        return null;
    }

}
