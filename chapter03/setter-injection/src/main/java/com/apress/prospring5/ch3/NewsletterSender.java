package com.apress.prospring5.ch3;

public interface NewsletterSender {
    // 作为配置信息，不算是一种依赖项
    void setSmtpServer(String smtpServer);

    String getSmtpServer();

    // 作为配置信息，不算是一种依赖项
    void setFromAddress(String fromAddress);

    String getFromAddress();

    void send();
}
