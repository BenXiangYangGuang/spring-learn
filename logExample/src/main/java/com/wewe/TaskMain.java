package com.wewe;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangpanwei
 * @Description
 * @create 2021-08-09 下午8:16
 */
@Component
public class TaskMain {

    @Resource
    private List<Task> list;

    public void printTask(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
