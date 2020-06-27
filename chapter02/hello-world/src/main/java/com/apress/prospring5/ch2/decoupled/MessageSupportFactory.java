package com.apress.prospring5.ch2.decoupled;

import java.util.Properties;

/**
 * 消息支持工厂
 * 静态字段 instance
 * 属性 props
 * 消息渲染 renderer
 * 消息提供者 provider
 */
public class MessageSupportFactory {

    private static MessageSupportFactory instance;
    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    /**
     * 私有构造方法，不允许直接 new
     * 在私有构造方法中新建 Properties 对象，
     * 然后从类路径获取属性文件资源做输入流加载进来，
     * 从属性对象中按照key去获取预先配置好的类名，
     * 接着用 Class.forName的方式去获取新的renderer 和 provider 的实例
     */
    private MessageSupportFactory() {
        props = new Properties();
        try {
            // 这行可以参考一下，作为snippet
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            // getDeclaredConstructor() 是新方法，旧的已过时
            renderer = (MessageRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            provider = (MessageProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 静态代码块，类加载的时候就运行？ 相当于简单的单例模式
    static {
        instance = new MessageSupportFactory();
    }

    // 这个就是工厂模式获取实例的方式，公有的静态 getInstance 方法
    public static MessageSupportFactory getInstance() {
        return instance;
    }

    // 接口，用来获取 renderer
    public MessageRenderer getMessageRenderer() {
        return renderer;
    }

    // 接口，用来获取 provider
    public MessageProvider getMessageProvider() {
        return provider;
    }
}
