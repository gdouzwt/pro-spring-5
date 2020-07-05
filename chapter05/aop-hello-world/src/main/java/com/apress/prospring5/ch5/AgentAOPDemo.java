package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String... args) {
        Agent target = new Agent();

        // 手动地获取 ProxyFactory，并添加 Advice，设置 Target
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);

        // 获取被代理的对象
        Agent proxy = (Agent) pf.getProxy();

        target.speak();
        System.out.println("");
        proxy.speak();
    }
}
