package com.apress.prospring5.ch2.common;

/**
 * Created by iuliana.cosmina on 4/2/17.
 * 一个吉他类，品牌是马丁，play方法返回音阶字符串
 */
public class Guitar {
    private String brand = " Martin";

    public String play() {
        return "G C G C Am D7";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
