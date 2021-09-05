package com.wewe;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangpanwei
 * @Description
 * @create 2021-08-09 下午8:23
 */
@Component
public class PrintTaskComponent implements InitializingBean {
    @Resource
    private TaskMain taskMain;
    @Override
    public void afterPropertiesSet() throws Exception {
        taskMain.printTask();
    }
}
