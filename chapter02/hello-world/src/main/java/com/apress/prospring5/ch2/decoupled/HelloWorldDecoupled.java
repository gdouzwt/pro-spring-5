package com.apress.prospring5.ch2.decoupled;

/**
 * 演示解耦合版本的 HelloWorld
 */
public class HelloWorldDecoupled {
    public static void main(String... args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
