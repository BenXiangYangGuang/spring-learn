package com.wewe.druid.sampledruid;

/**
 * Author: fei2
 * Date:  2018/12/12 19:54
 * Description:
 * Refer To:
 */

import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class DruidDao {

    public void insert(String sql){
        DruidPooledConnection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBPoolConnection.getConnection();    //从数据库连接池中获取数据库连接
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps){
                    ps.close();
                }
                if (null != conn){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}