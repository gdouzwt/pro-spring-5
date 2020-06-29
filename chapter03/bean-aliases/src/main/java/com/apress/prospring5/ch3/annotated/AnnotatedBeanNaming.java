package com.apress.prospring5.ch3.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by iuliana.cosmina on 2/19/17.
 */
public class AnnotatedBeanNaming {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotated.xml");
        ctx.refresh();

        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        beans.forEach((key, value) -> System.out.println(
            "id: " + key + "\n aliases: "
                + Arrays.toString(ctx.getAliases(key)) + "\n"));

        ctx.close();
    }
}
