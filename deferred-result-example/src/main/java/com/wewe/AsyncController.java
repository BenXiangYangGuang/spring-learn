package com.wewe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhangpanwei@motie.com
 * @create 2019-08-21 11:43
 * refer:https://zhuanlan.zhihu.com/p/31223106
 **/
@Slf4j
@RestController("/")
public class AsyncController {

    private AtomicLong record = new AtomicLong(0L);

    @Autowired
    private MockQueue mockQueue;

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

    @RequestMapping("/test")
    public DeferredResult<String> test(Long timeout) throws InterruptedException {
        log.info("/test 收到请求");
        DeferredResult<String> result = new DeferredResult<>(timeout);

        Task<String> task = new Task<>(result,"test任务",false);

        result.onTimeout(() -> {
            log.info("任务超时");
            task.setTimeOut(true);
            result.setErrorResult("任务超时");
        });
        log.info("放入队列中");
        mockQueue.put(task);
        log.info("主线程返回结果");
        return result;
    }
}
