package com.wewe.druid.sampledruid;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Directions: 获取配置文件属性信息
 * PackageName: com.zjenergy.utils.
 * ProjectName: CompressData.
 * Creator: itdeer.
 * CreationTime: 2018/10/16 9:33.
 */

@Slf4j
public class PropertiesUtils {

    private static Properties prop = null;
    private static FileInputStream in = null;

    /**
     * 静态代码块，加载配置文件
     */
    static {
        try {
            if (prop == null) {
                prop = new Properties();
                String runTimePath = System.getProperty("user.dir");
                in = new FileInputStream(new File(runTimePath + File.separator + "config"+ File.separator+ "application.properties"));
                prop.load(in);
                log.info("loading application.properties file finish");
            }
        } catch (Exception e) {
            log.error("loading application.properties file appear exception: " + e.getStackTrace());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    log.error("close InputStream appear exception: " + e.getStackTrace());
                }
            }
        }
    }

    /**
     * 根据传递来的key值获取对应的Value值
     *
     * @return Key值为字符串
     */
    public static String getStringValueByKey(String key) {
        return prop.getProperty(key);
    }

    /**
     * 根据传递来的key值获取对应的Value值
     *
     * @return Key值为整形
     */
    public static Integer getIntValueByKey(String key) {
        return Integer.parseInt(prop.getProperty(key));
    }

    public static Properties getProp(){

        Properties propDruid = null;
        FileInputStream inDruid = null;
        try {
            if (propDruid == null) {
                propDruid = new Properties();
                String runTimePath = System.getProperty("user.dir");
                inDruid = new FileInputStream(new File(runTimePath + File.separator + "config"+ File.separator+ "druidPool.properties"));
                propDruid.load(inDruid);
                log.info("loading druidPool.properties file finish");
            }
        } catch (Exception e) {
            log.error("loading druidPool.properties file appear exception: " + e.getStackTrace());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    log.error("close InputStream appear exception: " + e.getStackTrace());
                }
            }
        }
        return propDruid;
    }

}
