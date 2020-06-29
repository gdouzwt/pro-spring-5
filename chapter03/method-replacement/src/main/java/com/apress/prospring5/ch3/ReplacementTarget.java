package com.apress.prospring5.ch3;

/**
 * 被进行方法替换的对象
 */
public class ReplacementTarget {
    // 具体待被替换的方法
    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }
}
