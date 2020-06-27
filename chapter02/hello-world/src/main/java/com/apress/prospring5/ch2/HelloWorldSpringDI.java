package com.apress.prospring5.ch2;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用spring依赖注入的HelloWorld
 */
public class HelloWorldSpringDI {
    public static void main(String... args) {
        // 在类路径获取XML配置文件，创建ApplicationContext实例
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        // 类型安全地（指定了类型）获取 MessageRenderer Bean
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
