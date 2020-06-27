package com.apress.prospring5.ch2.decoupled;

// 一粒 spring Bean 定义在 app-context.xml 里面
// 一个简单地返回 "Hello World" 的 MessageProvider 实现，搭配 StandardOutMessageRenderer
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    // Bean 的构造方法而已
    public StandardOutMessageRenderer() {
        System.out.println(" --> StandardOutMessageRenderer: constructor called");
    }

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                "You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    // 在这里做 setter 注入 p:messageProvider-ref="provider"
    // 注入的 HelloWorldMessageProvider 的实现
    @Override
    public void setMessageProvider(MessageProvider provider) {
        System.out.println(" --> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
