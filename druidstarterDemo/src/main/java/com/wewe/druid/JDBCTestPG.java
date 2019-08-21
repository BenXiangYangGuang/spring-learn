package com.wewe.druid;

import com.wewe.druid.sampledruid.DruidDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author: fei2
 * Date:  2018/12/12 18:49
 * Description:
 * Refer To:
 */
public class JDBCTestPG {

    public static void sampleConnection(){
        String URL = "jdbc:postgresql://10.154.96.96:5432/pidb?characterEncoding=utf-8";
        String USER="pidb";
        String PASSWORD="pidb#Admin";
        //1.加载驱动程序
        try {
            Class.forName("org.postgresql.Driver");
            //2.获得数据库链接
            Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
            //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from pi_dl_binhai");
            //4.处理数据库的返回结果(使用ResultSet类)
            while(rs.next()){
                System.out.println(rs.getString("tag_name"));
            }
            //关闭资源
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*

    public static void main(String[] args) {
        DruidDao druidDao = new DruidDao();
        String sql = "INSERT INTO \"public\".\"pi_dl_binhai\" (\"tag_name\", \"tag_value\", \"is_good\", \"pi_ts\", \"send_ts\", \"load_time\") VALUES ('13', '11.0000000000', 't', '2018-12-12 18:55:33', '2018-12-12 18:55:36', '2018-12-10 18:55:39')";
        druidDao.insert(sql);
    }
*/

}
