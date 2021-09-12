package com.wewe.transitation;

import com.wewe.Application;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangpanwei
 * @Description
 * @create 2021-09-12 下午4:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceTest extends TestCase {

    @Autowired
    UserService userService;

    @Test
    public void testTransition(){
        userService.invokeMethod();
    }

}