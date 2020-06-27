package com.apress.prospring5.ch2.decoupled;

// 通过面向接口解耦，这个接口定义的类型，作为Autowired的目标类型
public interface MessageRenderer {
    void render();

    // 在 xml 里配置了 p:messageProvider-ref="provider"
    // 即通过 setter 注入的方式，不过不建议放在接口里
    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
