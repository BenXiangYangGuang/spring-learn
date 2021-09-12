package com.wewe.transitation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @author zhangpanwei
 * @Description
 * @create 2021-09-12 下午3:20
 */
@Service
public class UserService {

    public void invokeMethod(){

    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUser(){
        int a = 1 ,b = 2;
        int c = 0;
        try{
            System.out.println("transaction:before:-------------");
            System.out.println("c:" + c);
            throw new Exception("insert user transaction");

        }catch (Exception e){

        }

    }

}
