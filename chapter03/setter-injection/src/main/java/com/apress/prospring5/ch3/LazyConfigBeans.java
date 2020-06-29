package com.apress.prospring5.ch3;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by iuliana.cosmina on 1/31/17.
 * 演示Bean的懒加载
 */
public class LazyConfigBeans {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-lazy-xml.xml");
        //ctx.load("classpath:spring/app-context-default-lazy-xml.xml"); 两个都可以，Bean的懒加载
        ctx.refresh();
        MessageRenderer messageRenderer = ctx.getBean("renderer",
            MessageRenderer.class);
        messageRenderer.render();
        ctx.close();
    }

}
