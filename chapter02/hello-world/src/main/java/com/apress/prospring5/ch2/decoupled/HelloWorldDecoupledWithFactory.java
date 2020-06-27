package com.apress.prospring5.ch2.decoupled;

/**
 * 通过工厂模式解耦合的例子
 */
public class HelloWorldDecoupledWithFactory {

    public static void main(String... args) {
        // 从工厂获取实例
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
