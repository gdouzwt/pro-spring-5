package com.apress.prospring5.ch4;

import java.security.MessageDigest;

// factory-bean
public class MessageDigestFactory {
    private String algorithmName = "MD5";

    // factory-method
    public MessageDigest createInstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}
