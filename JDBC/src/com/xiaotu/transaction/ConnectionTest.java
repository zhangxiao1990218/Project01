package com.xiaotu.transaction;

import com.xiaotu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 张晓
 * @create 2020-05-28 16:58
 */
public class ConnectionTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }

}
