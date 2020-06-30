package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.math.BigInteger;
import java.security.MessageDigest;

public class AccessingFactoryBeans {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        ctx.getBean("shaDigest", MessageDigest.class);

        MessageDigestFactoryBean factoryBean =
            (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigest = factoryBean.getObject();

            // 以下内容，将摘要消息转为 Hex 输出
            System.out.println(String.format("%040x",
                new BigInteger(1, shaDigest.digest("Hello World!".getBytes())))); // 输出处理结果
            // 2ef7bde608ce5404e97d5f042f95f89f1c232871
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ctx.close();
    }
}
