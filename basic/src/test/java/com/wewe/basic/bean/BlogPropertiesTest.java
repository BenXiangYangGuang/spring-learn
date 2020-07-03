package com.wewe.basic.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: fei2
 * @Date:2018/6/5 19:55
 * @Description: application.properties 中文乱码 配置
 * @Refer To:https://www.huangyunkun.com/2016/12/08/spring-boot-properties-encoding-issue/
 * http://blog.csdn.net/nimeijian/article/details/53464908
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BlogPropertiesTest {
    
    private static final Log log = LogFactory.getLog(BlogPropertiesTest.class);
    @Autowired
    private BlogProperties blogProperties;
    
    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "程序猿DD");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
    
        Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", blogProperties.getDesc());
    
        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getValue());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());
    }
    
}