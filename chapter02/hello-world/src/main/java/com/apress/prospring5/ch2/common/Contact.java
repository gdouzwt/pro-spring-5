package com.apress.prospring5.ch2.common;

/**
 * Created by iuliana.cosmina on 4/9/17.
 * 一个普通的类，表示联系人信息，名字，电话号码，电子邮件
 */
public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
