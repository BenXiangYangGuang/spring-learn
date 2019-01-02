package com.wewe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 子模块使用父模块自己代码必须添加父模块依赖,如果子模块添加使用父模块添加过的依赖而不用，重新引入
 * <dependencyManagement></dependencyManagement> 中的引入，子模块需要重新进入，次功能只作为jar版本的依赖管理
 * 参考：https://www.cnblogs.com/youzhibing/p/5427130.html
 * spring 的启动程序不能直接放在java包下
 * 参考：https://www.zybuluo.com/Cesar/note/295267
 *
 * 加上 @ServletComponentScan(value = "com.wewe") 注解,不然404
 * 参考:https://www.cnblogs.com/telwanggs/p/7484854.html
 */
@SpringBootApplication
//@ComponentScan(value = "com.wewe")
@ServletComponentScan(value = "com.wewe")
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}
	/*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("let us inspect the beans provied by spring boot");
            
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames){
                System.out.println(beanName);
            }
        };
    }*/
}
