package com.apress.prospring5.ch5.compiletimeweaving;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 测试编译器织入
 */
@Aspect
public class DemoAspect {
    static boolean called = false;

    @Before("execution(void advisedMethod())")
    public void logException() {
        System.out.println("Aspect called!");
        setCalled(true);
    }

    public static boolean isCalled() {
        return called;
    }

    public static void setCalled(boolean called) {
        DemoAspect.called = called;
    }
}
