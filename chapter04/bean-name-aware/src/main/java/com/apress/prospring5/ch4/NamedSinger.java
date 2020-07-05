package com.apress.prospring5.ch4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * 如果按照 {@link BeanFactory} 里面定义的 bean 初始化顺序
 *  {@link BeanNameAware#setBeanName(String)} 应该时第一个执行的操作
 */
public class NamedSinger implements BeanNameAware {
    private String name;

    /**
     * @Implements {@link BeanNameAware#setBeanName(String)}
     * 可以感知 Bean 名称
     */
    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean 初始化时注入名称");
        this.name = beanName;
    }

    /**
     * 输出 Bean 的名称
     */
    public void sing() {
        System.out.println("Singer [" + name + "] - sing()");
    }
}
