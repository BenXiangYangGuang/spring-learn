package com.wewe.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Author: fei2
 * Date:  18-9-13 上午11:40
 * Description:
 * Refer To:
 */
@RestController
public class HelloController {

    private static Logger log = Logger.getLogger(HelloController.class);

    // 获取请求参数实例化
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody Student student) {
        return "Hello " + student.getName();
    }
}
