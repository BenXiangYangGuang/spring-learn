package com.wewe.logOne;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author: fei2
 * Date:  18-9-13 上午9:20
 * Description:
 * Refer To:
 */
@Component
public class TestLogLevleOne implements CommandLineRunner{

    private static Logger log = Logger.getLogger(TestLogLevleOne.class);
    @Override
    public void run(String... strings) throws Exception {
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");
    }
}
