package com.apress.prospring5.ch3.mixed;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by iuliana.cosmina on 1/29/17.
 * 混合xml与注解的配置方式
 */
@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})
@Configuration
public class HelloWorldConfiguration {

}
