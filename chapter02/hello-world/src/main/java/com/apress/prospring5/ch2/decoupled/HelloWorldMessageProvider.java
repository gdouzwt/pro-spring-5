package com.apress.prospring5.ch2.decoupled;

// 一粒 spring Bean 定义在 app-context.xml 里面
// 一个简单地返回 "Hello World" 的 MessageProvider 实现，搭配 StandardOutMessageRenderer
public class HelloWorldMessageProvider implements MessageProvider {

    // bean 的方法
    public HelloWorldMessageProvider() {
        System.out.println(" --> HelloWorldMessageProvider: constructor called");
    }

    // 接口里定义的方法
    @Override
    public String getMessage() {
        return " Hello World!";
    }
}
