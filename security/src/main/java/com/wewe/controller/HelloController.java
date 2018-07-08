package com.wewe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fei2
 * @Date:2018/6/11 21:10
 * @Description:
 * @Refer To:
 */
@Controller
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
