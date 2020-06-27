package com.apress.prospring5.ch2.annotated;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by iuliana.cosmina on 1/28/17.
 * 主类，应用程序入口
 */

public class HelloWorldSpringAnnotated {

    public static void main(String... args) {
        // 获取基于注解的配置文件（一个带 @Configuration 注解的类）
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (HelloWorldConfiguration.class);
        // 通过 ApplicationContext -> ListableBeanFactory -> BeanFactory 里面的 getBean 方法获得 bean
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        // 调用 render 方法
        mr.render();
    }
}
