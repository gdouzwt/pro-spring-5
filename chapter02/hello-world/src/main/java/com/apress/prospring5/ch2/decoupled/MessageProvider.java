package com.apress.prospring5.ch2.decoupled;

// 通过面向接口解耦，这个接口定义的类型，作为Autowired的目标类型
public interface MessageProvider {
    String getMessage();
}
