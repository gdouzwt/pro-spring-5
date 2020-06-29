package com.apress.prospring5.ch3;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 没什么新意，也只是演示基本spring功能
 */
public class DeclareSpringComponents {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        MessageRenderer messageRenderer = ctx.getBean("renderer",
            MessageRenderer.class);
        messageRenderer.render();
        ctx.close();
    }
}
