package com.wewe.druid.sampledruid;

/**
 * Author: fei2
 * Date:  2018/12/12 19:19
 * Description:
 * Refer To:
 */

import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import lombok.extern.slf4j.Slf4j;

/**
 * 要实现单例模式，保证全局只有一个数据库连接池
 * @author ylf
 *
 * 2016年10月21日
 */
@Slf4j
public class DBPoolConnection {
    private static DBPoolConnection dbPoolConnection = null;
    private static DruidDataSource druidDataSource = null;

    static {
        Properties properties = PropertiesUtils.getProp();
        try {
            druidDataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);    //DruidDataSrouce工厂模式
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据库连接池单例
     * @return
     */
    public static synchronized DBPoolConnection getInstance(){
        if (null == dbPoolConnection){
            dbPoolConnection = new DBPoolConnection();
        }
        return dbPoolConnection;
    }

    /**
     * 返回druid数据库连接
     * @return
     * @throws SQLException
     */
    public static DruidPooledConnection getConnection() throws SQLException{
        return druidDataSource.getConnection();
    }


}
