package com.apress.prospring5.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PreDestroy;

/**
 * 这粒 Bean 通过实现 ApplicationContextAware 接口，可以感知当前容器环境（ApplicationContext）
 * 其实这个例子的意思是，通过将某粒 Bean 定义为实现 ApplicationContextAware 以便给 ApplicationContext 注册
 * 一个 ShutdownHook。 这样的话，被 @PreDestroy 之类标记的方法就会在容器关闭前被调用
 */
public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;

    /**
     * @Implements {@link ApplicationContextAware#setApplicationContext(ApplicationContext)}  }
     */
    public void setApplicationContext(ApplicationContext ctx)
        throws BeansException {

        // 如果是 GenericApplicationContext 示例就注册一个容器关闭的钩子（registerShutdownHook）
        if (ctx instanceof GenericApplicationContext) {
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }

    /**
     * 添加用于测试
     */
    @PreDestroy
    public void close() {
        System.out.println("Closing down...");
    }
}
