package com.wewe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangpanwei@motie.com
 * @create 2019-08-21 11:43
 **/
@Slf4j
@RestController("/")
public class AsyncController {

    private AtomicLong record = new AtomicLong(0L);

    @RequestMapping("/order")
    public Callable order() throws InterruptedException {
        log.info("主线程开始");
        Long now = System.currentTimeMillis();
        record.getAndAdd(1L);
        Callable<String> result = () -> {
            log.info("子线程开始:线程序号:" + record);
            Thread.sleep(5000L);
            log.info("子线程结束:线程序号:" + record);
            Long timeSuspend = System.currentTimeMillis() - now;
            return "success" +  timeSuspend;
        };
        log.info("主线程返回");
        return result;
    }
}
