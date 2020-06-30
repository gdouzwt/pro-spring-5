package com.apress.prospring5.ch4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.security.MessageDigest;

/**
 * FactoryBean of MessageDigest
 */
public class MessageDigestFactoryBean implements
    FactoryBean<MessageDigest>, InitializingBean {
    // 默认情况使用 MD5 算法
    private String algorithmName = "MD5";

    // 在 Bean 初始化回调 afterPropertiesSet() 执行后
    // 这个 messageDigest 将会引用到已初始化的 MessageDigest 对象
    private MessageDigest messageDigest = null;

    // 通过 FactoryBean 的这个方法返回真正想要的 MessageDigest Bean 对象
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * Bean 初始化回调方法，在里面获取 MessageDigest 实例
     * 这个会在 Bean 属性注入后（即先执行setAlgorithmName)执行
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        messageDigest = MessageDigest.getInstance(algorithmName);
    }

    // setter 注入摘要算法类型
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
