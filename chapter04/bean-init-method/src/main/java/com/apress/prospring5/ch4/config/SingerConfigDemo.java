package com.apress.prospring5.ch4.config;

import com.apress.prospring5.ch4.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by iuliana.cosmina on 2/26/17.
 */
public class SingerConfigDemo {

    // 本身就配楞佐个 Java Config
    @Configuration
    static class SingerConfig {

        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne() {
            Singer singerOne = new Singer();
            singerOne.setName("John Mayer");
            singerOne.setAge(39);
            return singerOne;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo() {
            Singer singerTwo = new Singer();
            singerTwo.setAge(72);
            return singerTwo;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerThree() {
            Singer singerThree = new Singer();
            singerThree.setName("John Butler");
            // singerThree.setAge(25); 如果设置个年龄，就不会报错了
            return singerThree;
        }
    }

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);

        // 改成Singer.getBean形式清楚些
        Singer.getBean("singerOne", ctx);
        Singer.getBean("singerTwo", ctx);
        Singer.getBean("singerThree", ctx);

        ctx.close();
    }

}
