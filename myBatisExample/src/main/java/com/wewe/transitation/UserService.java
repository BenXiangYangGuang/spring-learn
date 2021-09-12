package com.wewe.transitation;

import com.wewe.dao.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhangpanwei
 * @Description
 * @create 2021-09-12 下午3:20
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    @Lazy
    private UserService userService;


    public void invokeMethod(){
        try {
            this.userService.insertUser();
        } catch (Exception e){

        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUser() throws Exception{

        userMapper.insert("zhangsan",20);
        System.out.println("transaction:before:-------------");
        throw new Exception("insert user transaction");


    }

}
