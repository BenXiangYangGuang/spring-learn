package com.wewe.web;

import com.wewe.error.MyException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fei2
 * @Date:2018/6/5 19:21
 * @Description: 错误controller 师范
 * @Refer To:
 */
@RestController
@RequestMapping("/error/")
public class HelloController {
    
    @RequestMapping("/hello2")
    public String index(){
        return "Hello World";
    }
    
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }
    
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
    
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}
