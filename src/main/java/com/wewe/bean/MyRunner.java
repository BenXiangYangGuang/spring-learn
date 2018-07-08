package com.wewe.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by fei2 on 2018/5/15.
 * 描述：项目启动自动执行的方法
 */

@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("项目启动了1111");
    }
}