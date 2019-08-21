package com.wewe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhangpanwei@motie.com
 * @create 2019-08-21 14:33
 **/
@Slf4j
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private MockQueue mockQueue;

    /**
     * 当spring 容器加载完毕,执行从模拟队列的完成队列中获取数据,
     * 并使用ReferredResult返回
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true){
                try {
                    Task<String> task = mockQueue.get();
                    log.info("监听器获取到成功数据,task:{}",task);
                    task.getResult().setResult(task.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
