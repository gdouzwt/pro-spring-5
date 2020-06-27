package com.apress.prospring5.ch2.annotated;

import com.apress.prospring5.ch2.decoupled.HelloWorldMessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import com.apress.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 1/28/17.
 * 配置文件
 */

@Configuration
public class HelloWorldConfiguration {

    /**
     * 定义 Bean
     *
     * @return MessageProvider
     */
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    /**
     * 定义 Bean
     *
     * @return MessageRenderer
     */
    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
