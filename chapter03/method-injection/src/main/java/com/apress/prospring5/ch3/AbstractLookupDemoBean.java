package com.apress.prospring5.ch3;

/**
 * 不使用注解的情况，就用抽象类
 */
public abstract class AbstractLookupDemoBean implements DemoBean {
    // lookup method，通过这个方法返回非单例bean
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
