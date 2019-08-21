package com.wewe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhangpanwei@motie.com
 * @create 2019-08-21 14:01
 **/
@Component
@Slf4j
public class MockQueue {

    private BlockingQueue<Task<String>> receiveQueue = new LinkedBlockingQueue<>();

    private BlockingQueue<Task<String>> completeQueue = new LinkedBlockingQueue<>();

    void put(Task<String> task) throws InterruptedException {
        receiveQueue.put(task);
    }

    Task<String> get() throws InterruptedException {
        return completeQueue.take();
    }

    private void excute(){
        new Thread(() -> {
            while (true){

                try {
                    Task<String> task = receiveQueue.take();
                    log.info("队列接受到数据,处理中");
                    Thread.sleep(2000L);

                    task.setMessage("success");

                    //此处,有一个超时标志判断,如果任务超时,可以中断该任务的进行,在正常的service中,可以替换为数据库回滚等操作.
                    if (task.getTimeOut()){
                        log.info("任务超时,处理线程中断该任务");
                        continue;
                    }
                    log.info("队列处理完成");
                    completeQueue.put(task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public MockQueue(){
        excute();
    }

}
