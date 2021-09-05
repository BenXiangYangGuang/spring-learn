package com.wewe;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
public class Application {

    private static Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

        log.info("let us inspect the beans provied by spring boot");
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");

	}

}
