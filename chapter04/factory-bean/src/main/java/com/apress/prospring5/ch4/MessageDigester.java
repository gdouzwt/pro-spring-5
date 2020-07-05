package com.apress.prospring5.ch4;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MessageDigester {
    private MessageDigest digest1;
    private MessageDigest digest2;

    // setter 注入
    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    // setter 注入
    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("Using digest1");
        digest(msg, digest1);

        System.out.println("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
        System.out.println("Using algorithm: " + digest.getAlgorithm());
        digest.reset();  // 为什么要重置一下？
        byte[] bytes = msg.getBytes(); // 获取 Byte Array
        byte[] out = digest.digest(bytes); // 执行摘要算法

        // 以下内容，将摘要消息转为 Hex 输出
        // 其中 SH1 是 40 个字符长度
        // MD5 是 32 个字符长度
        // 结果能正常
        if ("MD5".equals(digest.getAlgorithm())) {
            System.out.println(String.format("%032x", new BigInteger(1, out))); // 输出处理结果
        } else {
            System.out.println(String.format("%040x", new BigInteger(1, out))); // 输出处理结果
        }

    }

//    public String toHex(String arg) {
//        return String.format("%040x", new BigInteger(1, arg.getBytes()));
//    }
}
